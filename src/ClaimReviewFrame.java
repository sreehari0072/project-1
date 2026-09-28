import javax.swing.*;
import java.awt.*;

public class ClaimReviewFrame extends JFrame {

    public ClaimReviewFrame() {

        setTitle("Claim Review");
        setSize(550, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        JLabel title = new JLabel("CLAIM REVIEW");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel claimId = new JLabel("Claim ID: CL101");
        JLabel item = new JLabel("Item: Black Wallet");
        JLabel user = new JLabel("Claimed By: Student 102");

        JLabel reasonTitle = new JLabel("Reason:");
        JLabel reason = new JLabel(
                "It has my college ID inside."
        );

        JLabel detailsTitle = new JLabel("Additional Details:");
        JLabel details = new JLabel(
                "Small scratch on the left side."
        );

        JButton approveButton = new JButton("APPROVE CLAIM");
        JButton rejectButton = new JButton("REJECT CLAIM");
        JButton backButton = new JButton("BACK");

        claimId.setAlignmentX(Component.CENTER_ALIGNMENT);
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        user.setAlignmentX(Component.CENTER_ALIGNMENT);
        reasonTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        reason.setAlignmentX(Component.CENTER_ALIGNMENT);
        detailsTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        details.setAlignmentX(Component.CENTER_ALIGNMENT);
        approveButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        rejectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(title);
        panel.add(Box.createVerticalStrut(25));
        panel.add(claimId);
        panel.add(Box.createVerticalStrut(10));
        panel.add(item);
        panel.add(Box.createVerticalStrut(10));
        panel.add(user);
        panel.add(Box.createVerticalStrut(20));
        panel.add(reasonTitle);
        panel.add(reason);
        panel.add(Box.createVerticalStrut(15));
        panel.add(detailsTitle);
        panel.add(details);
        panel.add(Box.createVerticalStrut(25));
        panel.add(approveButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(rejectButton);
        panel.add(Box.createVerticalStrut(10));
        panel.add(backButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ClaimReviewFrame().setVisible(true);
        });
    }
}
