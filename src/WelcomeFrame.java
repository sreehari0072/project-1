import javax.swing.*;
import java.awt.*;

public class WelcomeFrame extends JFrame {

    public WelcomeFrame() {

        setTitle("Lost & Found Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("LOST & FOUND MANAGEMENT");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Find it. Report it. Return it.");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton loginButton = new JButton("LOGIN");
        JButton registerButton = new JButton("CREATE ACCOUNT");
        JButton exitButton = new JButton("EXIT");

        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createVerticalStrut(50));
        panel.add(title);
        panel.add(Box.createVerticalStrut(15));
        panel.add(subtitle);
        panel.add(Box.createVerticalStrut(40));
        panel.add(loginButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(registerButton);
        panel.add(Box.createVerticalStrut(15));
        panel.add(exitButton);

        add(panel);

        exitButton.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WelcomeFrame().setVisible(true);
        });
    }
}
