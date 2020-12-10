package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.Client;

public class SignInPanel {
    static JFrame frame = new JFrame("Wypożyczalnia pojazdów");
    private static ArrayList<Client> clientList;
    private JPanel loginPanel;
    private JTextField loginTextField;
    private JPasswordField hasloPasswordField;
    private JButton loginButton;
    private JButton registerButton;

    public SignInPanel(ArrayList<Client> clientList) {
        this.clientList = clientList;
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
                JOptionPane.showMessageDialog(null,"Rejestracja w przygotowaniu");
            }
        });
    }
    public int verifyData(String login, String password){
        for (Client c:clientList) {
            if(login.equals(c.getLogin())) {
                if (password.equals(c.getPassword())) {
                    return c.getClientID();
                }
            }
        }
        return -1;
    }

    //String hashed = BCrypt.hashpw("password", BCrypt.gensalt(12));  // https://www.mindrot.org/projects/jBCrypt/
    // szyfrowane hasło

    private void signIn(String userName, char[] password){
        String enteredPassword = String.valueOf(password);
        String enteredLogin = String.valueOf(userName);
        int cID = verifyData(enteredLogin, enteredPassword);
        if(cID == -1){
            JOptionPane.showMessageDialog(null,"Niepoprawny login lub/i hasło");
        }
        else{
            frame.setVisible(false);
            JFrame clientFrame = new JFrame("Wypożyczalnia pojazdów");
            clientFrame.setContentPane(new ClientView().clientPanel);
            clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            clientFrame.pack();
            clientFrame.setVisible(true);
        }

    }

    public void register() {}

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

        frame.setContentPane(new SignInPanel(clientList).loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
