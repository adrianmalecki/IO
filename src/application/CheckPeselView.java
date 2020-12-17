package application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPeselView {
    static JFrame registerFrame = new JFrame("Rejestracja klienta");
    public JPanel checkPeselPanel;
    private JTextField enterPESEL;
    private JButton zatwierdzButton;

    public CheckPeselView() {
        zatwierdzButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Facade.checkPESEL(enterPESEL.getText())) {
                    JOptionPane.showMessageDialog(SignInPanel.checkPanel,"Istnieje już konto użytkownika o takim samym numerze PESEL!");
                    SignInPanel.checkPanel.setVisible(false);
                    SignInPanel.signInFrame.setContentPane(new SignInPanel().loginPanel);
                    SignInPanel.signInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    SignInPanel.signInFrame.pack();
                    SignInPanel.signInFrame.setVisible(true);
                }
                else {
                    SignInPanel.checkPanel.setVisible(false);
                    registerFrame.setContentPane(new RegisterView(enterPESEL.getText()).registerPanel);
                    registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    registerFrame.pack();
                    registerFrame.setVisible(true);
                }
            }
        });
    }
}
