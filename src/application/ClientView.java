package application;

import data.Client;
import data.Reservation;
import data.Status;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ClientView {
    public JPanel clientPanel;
    private JTabbedPane tabbedPane1;
    private JPanel reservePanel;
    private JPanel myDataPanel;
    private JLabel IDLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel peselLabel;
    private JButton modifyDataButton;
    private JTextField IDtextField;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField peselNameTextField;
    private JComboBox comboBox;
    private JTextField startDateTextField;
    private JTextField endDateTextField;
    private JLabel inputDate;
    private JButton showAvailableCarsBtn;

    private JTextField addressTextField;
    private JTextField cityTextField;
    private JTextField postCodeTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JButton deleteData;
    private JTable carsTable;
    private JButton reserveVehicle;
    //private Client client;
    int clicked = 0;
    int selected_dep = -1;


    public ClientView(Client client) {
        tabbedPane1.addComponentListener(new ComponentAdapter() {
        });
        reservePanel.addComponentListener(new ComponentAdapter() {
        });
        myDataPanel.addComponentListener(new ComponentAdapter() {
        });
        IDtextField.setText(String.valueOf(Facade.getClientList().indexOf(client)));
        firstNameTextField.setText(client.getFirstName());
        lastNameTextField.setText(client.getLastName());
        peselNameTextField.setText(client.getPESEL());
        addressTextField.setText(client.getAddress());
        cityTextField.setText(client.getCity());
        postCodeTextField.setText(client.getPostCode());
        emailTextField.setText(client.getEmail());
        phoneTextField.setText(client.getPhoneNumber());


        String[] departments = new String[Facade.getDepartmentsList().size()];
        for (int i=0; i<Facade.getDepartmentsList().size(); i++) {
            departments[i] = Facade.getDepartmentsList().get(i).getCity();
        }

        DefaultComboBoxModel deparmentsModel = new DefaultComboBoxModel(departments);
        comboBox.setModel(deparmentsModel);


        modifyDataButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clicked==0) editData(e);
                else {
                    Facade.modifyData(client, firstNameTextField.getText(), lastNameTextField.getText(), phoneTextField.getText(), emailTextField.getText(), postCodeTextField.getText(), cityTextField.getText(), addressTextField.getText());
                    saveData(e);
                }
            }
        });


        deleteData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame deleteDataFrame = new JFrame("Usuń konto");
                deleteDataFrame.setContentPane(new ConfirmDeleting(client.getLogin(), client.getPassword()).deleteDataPanel);
                deleteDataFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                deleteDataFrame.pack();
                deleteDataFrame.setVisible(true);
            }
        });


        showAvailableCarsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDateValid(startDateTextField.getText()) && isDateValid(endDateTextField.getText())) {
                    if (LocalDate.parse(startDateTextField.getText()).isBefore(LocalDate.parse(endDateTextField.getText())) || LocalDate.parse(startDateTextField.getText()).isEqual(LocalDate.parse(endDateTextField.getText()))) {
                        String columns[] = {"Marka","Model","Rok produkcji", "Przebieg"};
                        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
                        Object rowData[] = new Object[4];
                        for (int i=0; i<Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().size(); i++) {
                            if (Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(i).getStatus().equals(Status.AVAILABLE)) {
                                rowData[0] = Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(i).getBrand();
                                rowData[1] = Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(i).getModel();
                                rowData[2] = Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(i).getYearOfProduction();
                                rowData[3] = Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(i).getCarsMileage();
                                tableModel.addRow(rowData);
                            }
                            else {
                                rowData[0] = "";
                                rowData[1] = "";
                                rowData[2] = "";
                                rowData[3] = "";
                                tableModel.addRow(rowData);
                            }
                        }
                        carsTable.setModel(tableModel);
                    }

                    else {
                        JOptionPane.showMessageDialog(reservePanel, "Błędna chronologia dat!");
                    }
                }

                else {
                    JOptionPane.showMessageDialog(reservePanel, "Zły format dat!");
                }
            }
        });

        reserveVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDateValid(startDateTextField.getText()) && isDateValid(endDateTextField.getText())) {
                    if (LocalDate.parse(startDateTextField.getText()).isBefore(LocalDate.parse(endDateTextField.getText())) || LocalDate.parse(startDateTextField.getText()).isEqual(LocalDate.parse(endDateTextField.getText()))) {
                        if (carsTable.getSelectedRow() > -1 && Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(carsTable.getSelectedRow()).getStatus().equals(Status.AVAILABLE)) {
                            Reservation reservation = new Reservation();
                            reservation.setClient(client);
                            reservation.setStartDate(LocalDate.parse(startDateTextField.getText()));
                            reservation.setEndDate(LocalDate.parse(endDateTextField.getText()));
                            reservation.setVehicle(Facade.getDepartmentsList().get(comboBox.getSelectedIndex()).getVehicles().get(carsTable.getSelectedRow()));
                            Facade.getReservationList().add(reservation);
                            String confirmation = "Pomyślnie zarezerwowano pojazd " + reservation.getVehicle().getBrand() + " " + reservation.getVehicle().getModel() + " w terminie od " + reservation.getStartDate().toString() + " do " + reservation.getEndDate().toString() + ".";
                            JOptionPane.showMessageDialog(reservePanel, confirmation);
                        }
                        else {
                            JOptionPane.showMessageDialog(reservePanel, "Kliknij na wiersz z wybranym pojazdem!");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(reservePanel, "Błędna chronologia dat!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(reservePanel, "Zły format dat!");
                }
            }
        });
    }

    public boolean isDateValid(String dateStr) {
        try {
            LocalDate.parse(dateStr);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    public void editData(ActionEvent e) {

        firstNameTextField.setEditable(true);
        lastNameTextField.setEditable(true);
        addressTextField.setEditable(true);
        cityTextField.setEditable(true);
        postCodeTextField.setEditable(true);
        emailTextField.setEditable(true);
        phoneTextField.setEditable(true);
        modifyDataButton.setText("Zapisz zmiany");
        clicked = 1;
    }
    public void saveData(ActionEvent e) {

        firstNameTextField.setEditable(false);
        lastNameTextField.setEditable(false);
        addressTextField.setEditable(false);
        cityTextField.setEditable(false);
        postCodeTextField.setEditable(false);
        emailTextField.setEditable(false);
        phoneTextField.setEditable(false);
        modifyDataButton.setText("Edytuj dane");
        clicked=0;
    }

    public void deleteData() {
    }

    public void cancelReservation() {
    }

    public void chooseDepartment() {

    }

    public void showReservations() {
    }

    public void reserveCar() {

    }

    private void createUIComponents() {
        tabbedPane1 = new JTabbedPane();
        //showAvailableCarsBtn = new JButton();
        carsTable = new JTable();
        comboBox = new JComboBox();
        deleteData = new JButton();
    }
}
