
import javax.swing.*;
import java.awt.*;

public class ClaimFrame extends JFrame {

    public ClaimFrame() {

        setTitle("Claim Item");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        JLabel title = new JLabel("CLAIM ITEM", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel itemLabel = new JLabel("Item: Black Wallet");
        JLabel reasonLabel = new JLabel("Why is this yours?");

        JTextArea reasonArea = new JTextArea();

        JLabel detailsLabel = new JLabel("Identifying Details:");

        JTextArea detailsArea = new JTextArea();

        JButton submitButton = new JButton("SUBMIT CLAIM");
        JButton clearButton = new JButton("CLEAR");
        JButton backButton = new JButton("BACK");

        panel.add(title);
        panel.add(new JLabel());

        panel.add(itemLabel);
        panel.add(new JLabel());

        panel.add(reasonLabel);
        panel.add(new JScrollPane(reasonArea));

        panel.add(detailsLabel);
        panel.add(new JScrollPane(detailsArea));

        panel.add(submitButton);
        panel.add(clearButton);

        panel.add(backButton);
        panel.add(new JLabel());

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClaimFrame().setVisible(true);
        });
    }
}
