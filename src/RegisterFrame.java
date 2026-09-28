import javax.swing.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    public RegisterFrame() {

        setTitle("Create Account");
        setSize(500, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("CREATE ACCOUNT", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();

        JLabel idLabel = new JLabel("College ID:");
        JTextField idField = new JTextField();

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JLabel roleLabel = new JLabel("Role:");

        String[] roles = {"Student", "Staff"};
        JComboBox<String> roleBox = new JComboBox<>(roles);

        JButton registerButton = new JButton("REGISTER");
        JButton backButton = new JButton("BACK");

        panel.add(title);
        panel.add(new JLabel());

        panel.add(nameLabel);
        panel.add(nameField);

        panel.add(idLabel);
        panel.add(idField);

        panel.add(emailLabel);
        panel.add(emailField);

        panel.add(passwordLabel);
        panel.add(passwordField);

        panel.add(roleLabel);
        panel.add(roleBox);

        panel.add(registerButton);
        panel.add(backButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RegisterFrame().setVisible(true);
        });
    }
}
