package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.Client;

public class SignInPanel {
    static JFrame signInFrame = new JFrame("Wypożyczalnia pojazdów");
    static JFrame checkPanel = new JFrame("Wypożyczalnia pojazdów");
    //private static ArrayList<Client> clientList;
    //private static ArrayList<Department> departmentsList;
    //private static ArrayList<Vehicle> vehicleList;


    public JPanel loginPanel;
    private JTextField loginTextField;
    private JPasswordField hasloPasswordField;
    private JButton loginButton;
    private JButton registerButton;

    public SignInPanel() {

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    signIn(loginTextField.getText(), hasloPasswordField.getPassword());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signInFrame.setVisible(false);
                checkPanel.setContentPane(new CheckPeselView().checkPeselPanel);
                checkPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                checkPanel.pack();
                checkPanel.setVisible(true);
            }
        });
    }

    private void signIn(String userName, char[] password){
        int cID = Facade.verifyData(userName, String.valueOf(password));
        if(cID == -1){
            JOptionPane.showMessageDialog(null,"Niepoprawny login lub/i hasło");
        }
        else{
            signInFrame.setVisible(false);
            JFrame clientFrame = new JFrame("Wypożyczalnia pojazdów");
            Client client = Facade.getClientList().get(cID);
            clientFrame.setContentPane(new ClientView(client).clientPanel);
            clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            clientFrame.pack();
            clientFrame.setVisible(true);
        }
    }

    public static void runSignInPanel(){
        /*try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
        }
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ClassNotFoundException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        }*/       // interfejs Nimbus

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  // This line gives Windows Theme
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        signInFrame.setContentPane(new SignInPanel().loginPanel);
        signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signInFrame.pack();
        signInFrame.setVisible(true);
    }
}