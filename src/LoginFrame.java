import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Color BG_COLOR = new Color(245, 247, 251);
        Color PRIMARY = new Color(37, 99, 235);
        Color BORDER = new Color(229, 231, 235);
        Color TEXT_DARK = new Color(17, 24, 39);
        Color TEXT_GRAY = new Color(107, 114, 128);

        setLayout(new BorderLayout());
        getContentPane().setBackground(BG_COLOR);

        // ===== HEADER =====
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(PRIMARY);
        header.setPreferredSize(new Dimension(0, 70));
        header.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

        JLabel headerTitle = new JLabel("Lost & Found Portal");
        headerTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
        headerTitle.setForeground(Color.WHITE);
        header.add(headerTitle, BorderLayout.WEST);

        JLabel campus = new JLabel("College Campus • Secure Access");
        campus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        campus.setForeground(new Color(191,219,254));
        header.add(campus, BorderLayout.EAST);
        add(header, BorderLayout.NORTH);

        // ===== CENTER =====
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setBackground(BG_COLOR);

        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.WHITE);
        main.setBorder(new LineBorder(BORDER, 1, true));
        main.setPreferredSize(new Dimension(900, 500));

        // LEFT - BRANDING PANEL
        JPanel left = new JPanel();
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
        left.setBackground(new Color(37, 99, 235));
        left.setPreferredSize(new Dimension(380, 500));
        left.setBorder(new EmptyBorder(40, 35, 40, 35));

        JLabel icon = new JLabel("🎓");
        icon.setFont(new Font("Segoe UI", Font.PLAIN, 48));
        icon.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel bigTitle = new JLabel("<html><div style='width:300px'><span style='font-size:28px;font-weight:bold;color:white'>Welcome Back</span><br><br><span style='font-size:14px;color:#bfdbfe;line-height:1.5'>Access your lost & found dashboard. Report, track and recover campus items securely.</span></div></html>");
        bigTitle.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel stats = new JPanel(new GridLayout(1,3,10,0));
        stats.setBackground(new Color(37, 99, 235));
        stats.setMaximumSize(new Dimension(320, 60));
        stats.setAlignmentX(Component.LEFT_ALIGNMENT);
        stats.setBorder(new EmptyBorder(30,0,0,0));
        stats.add(createStat("1.2k+", "Items Found"));
        stats.add(createStat("98%", "Returned"));
        stats.add(createStat("24h", "Avg Time"));

        JLabel trust = new JLabel("🔒 Secured with College ID");
        trust.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        trust.setForeground(new Color(147,197,253));
        trust.setBorder(new EmptyBorder(40,0,0,0));
        trust.setAlignmentX(Component.LEFT_ALIGNMENT);

        left.add(icon);
        left.add(Box.createVerticalStrut(15));
        left.add(bigTitle);
        left.add(stats);
        left.add(Box.createVerticalGlue());
        left.add(trust);

        // RIGHT - LOGIN FORM
        JPanel right = new JPanel();
        right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
        right.setBackground(Color.WHITE);
        right.setBorder(new EmptyBorder(40, 40, 30, 40));

        JLabel title = new JLabel("LOGIN");
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(TEXT_DARK);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel subtitle = new JLabel("Enter your college credentials");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        subtitle.setForeground(TEXT_GRAY);
        subtitle.setAlignmentX(Component.LEFT_ALIGNMENT);
        subtitle.setBorder(new EmptyBorder(6,0,25,0));

        right.add(title);
        right.add(subtitle);

         // Fields
        right.add(createField("College ID:", new JTextField(), "Ex: CS21-045"));
        right.add(Box.createVerticalStrut(16));
        right.add(createField("Password:", new JPasswordField(), "••••••••"));
        right.add(Box.createVerticalStrut(8));


        JPanel rememberPanel = new JPanel(new BorderLayout());
        rememberPanel.setBackground(Color.WHITE);
        rememberPanel.setMaximumSize(new Dimension(1000, 30));
        JCheckBox remember = new JCheckBox("Remember me");
        remember.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        remember.setBackground(Color.WHITE);
        remember.setForeground(TEXT_GRAY);
        JLabel forgot = new JLabel("Forgot password?");
        forgot.setFont(new Font("Segoe UI", Font.BOLD, 12));
        forgot.setForeground(PRIMARY);
        forgot.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rememberPanel.add(remember, BorderLayout.WEST);
        rememberPanel.add(forgot, BorderLayout.EAST);

        right.add(rememberPanel);
        right.add(Box.createVerticalStrut(25));

        JButton loginButton = new JButton("LOGIN →");
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        loginButton.setBackground(PRIMARY);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(new EmptyBorder(12,0,12,0));
        loginButton.setFocusPainted(false);
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setMaximumSize(new Dimension(1000, 46));
        loginButton.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel divider = new JPanel(new BorderLayout());
        divider.setBackground(Color.WHITE);
        divider.setMaximumSize(new Dimension(1000, 30));
        divider.setBorder(new EmptyBorder(18,0,18,0));
        JSeparator l = new JSeparator();
        JSeparator r = new JSeparator();
        JLabel or = new JLabel("  or  ");
        or.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        or.setForeground(TEXT_GRAY);
        divider.add(l, BorderLayout.CENTER);
        divider.add(or, BorderLayout.EAST);

        // Actually make centered OR
        JPanel divWrap = new JPanel(new GridBagLayout());
        divWrap.setBackground(Color.WHITE);
        divWrap.setMaximumSize(new Dimension(1000, 20));
        divWrap.add(l);
        JLabel or2 = new JLabel("  OR  ");
        or2.setFont(new Font("Segoe UI", Font.BOLD, 11));
        or2.setForeground(TEXT_GRAY);
        divWrap.add(or2);

        JPanel bottomActions = new JPanel(new GridLayout(1,2,12,0));
        bottomActions.setBackground(Color.WHITE);
        bottomActions.setMaximumSize(new Dimension(1000, 44));
        bottomActions.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton registerButton = new JButton("REGISTER");
        registerButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        registerButton.setBackground(Color.WHITE);
        registerButton.setBorder(new LineBorder(BORDER,1,true));
        registerButton.setFocusPainted(false);

        JButton backButton = new JButton("BACK");
        backButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        backButton.setBackground(new Color(249,250,251));
        backButton.setBorder(new LineBorder(BORDER,1,true));
        backButton.setFocusPainted(false);

        bottomActions.add(registerButton);
        bottomActions.add(backButton);

        right.add(loginButton);
        right.add(Box.createVerticalStrut(12));
        right.add(divWrap);
        right.add(Box.createVerticalStrut(12));
        right.add(bottomActions);

        JLabel noAcc = new JLabel("<html><center>Don't have an account? <span style='color:#2563eb;font-weight:bold'>Create account</span></center></html>");
        noAcc.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        noAcc.setForeground(TEXT_GRAY);
        noAcc.setAlignmentX(Component.CENTER_ALIGNMENT);
        noAcc.setBorder(new EmptyBorder(18,0,0,0));
        right.add(noAcc);

        main.add(left, BorderLayout.WEST);
        main.add(right, BorderLayout.CENTER);
        wrapper.add(main);
        add(wrapper, BorderLayout.CENTER);
    }

    private JPanel createStat(String num, String label) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(new Color(29,78,216));
        p.setBorder(new EmptyBorder(10,10,10,10));
        JLabel n = new JLabel(num);
        n.setFont(new Font("Segoe UI", Font.BOLD, 16));
        n.setForeground(Color.WHITE);
        JLabel l = new JLabel(label);
        l.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        l.setForeground(new Color(191,219,254));
        p.add(n); p.add(l);
        return p;
    }

    private JPanel createField(String labelText, JTextField field, String placeholder) {
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.setBackground(Color.WHITE);
        p.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        label.setForeground(new Color(55,65,81));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(new Color(209,213,219),1,true),
            new EmptyBorder(11,12,11,12)
        ));
        field.setMaximumSize(new Dimension(1000, 42));
        field.setAlignmentX(Component.LEFT_ALIGNMENT);

        p.add(label);
        p.add(Box.createVerticalStrut(6));
        p.add(field);
        return p;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame().setVisible(true));
    }
}
