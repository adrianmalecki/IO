package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInPanel {
    static JFrame signInFrame = new JFrame("Wypożyczalnia pojazdów");
    static JFrame checkPanel = new JFrame("Wypożyczalnia pojazdów");

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
                    Facade.signIn(loginTextField.getText(), String.valueOf(hasloPasswordField.getPassword()));
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

    /*private void signIn(String userName, char[] password){
        int cID = User.checkLoginData(userName, String.valueOf(password));
        if(cID == -1){
            JOptionPane.showMessageDialog(signInFrame,"Niepoprawny login lub/i hasło");
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
    }*/

    public static void runSignInPanel(){
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