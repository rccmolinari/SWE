package gui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AdminPanelBlue extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    // Palette blu
    private final Color bgSoftBlue = new Color(230, 240, 255);
    private final Color primaryBlue = new Color(50, 100, 200);
    private final Color accentBlue = new Color(100, 150, 255);
    private final Color borderGray = new Color(200, 200, 200);

    public AdminPanelBlue() {
        setTitle("IssueTrack Pro - Admin (Layout Demo)");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ========================
        // Menu di navigazione
        // ========================
        JPanel topMenu = new JPanel();
        topMenu.setLayout(new BoxLayout(topMenu, BoxLayout.X_AXIS));
        topMenu.setBackground(primaryBlue);
        topMenu.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        JButton dashboardBtn = createMenuButton("Dashboard");
        JButton createBtn = createMenuButton("Create Issue");

        // Pulsante Logout rosso a destra
        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBackground(Color.RED);
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFocusPainted(false);

        // Aggiungi i bottoni a sinistra
        topMenu.add(dashboardBtn);
        topMenu.add(Box.createHorizontalStrut(10));
        topMenu.add(createBtn);

        // Spacer flessibile
        topMenu.add(Box.createHorizontalGlue());

        // Logout a destra
        topMenu.add(logoutBtn);

        add(topMenu, BorderLayout.NORTH);

        // ========================
        // Main panel con CardLayout
        // ========================
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(bgSoftBlue);

        mainPanel.add(createDashboardPanel(), "dashboard");
        mainPanel.add(createIssueFormPanel(), "create");
        mainPanel.add(createIssueDetailPanel(), "detail");

        add(mainPanel, BorderLayout.CENTER);

        cardLayout.show(mainPanel, "dashboard");
    }

    private JButton createMenuButton(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(accentBlue);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        return btn;
    }

    // =======================
    // Dashboard layout
    // =======================
    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(bgSoftBlue);

        JLabel title = new JLabel("Admin Dashboard", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(primaryBlue);
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(title, BorderLayout.NORTH);

        // JTable placeholder
        String[] columns = { "ID", "Title", "Type", "Status", "Priority", "Actions" };
        Object[][] data = {}; // vuoto
        JTable table = new JTable(data, columns);
        table.setFillsViewportHeight(true);
        table.setGridColor(borderGray);
        table.setShowGrid(true);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new LineBorder(borderGray, 1));
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    // =======================
    // Create Issue layout
    // =======================
    private JPanel createIssueFormPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(bgSoftBlue);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Create New Issue");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(primaryBlue);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));

        JTextField titleField = new JTextField();
        titleField.setMaximumSize(new Dimension(400, 30));
        titleField.setBorder(new LineBorder(borderGray, 2, true));
        titleField.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(titleField);
        panel.add(Box.createVerticalStrut(10));

        JTextArea descField = new JTextArea(5, 30);
        descField.setBorder(new LineBorder(borderGray, 2, true));
        panel.add(descField);
        panel.add(Box.createVerticalStrut(10));

        JComboBox<String> typeCombo = new JComboBox<>(new String[] { "bug", "feature", "question", "documentation" });
        typeCombo.setMaximumSize(new Dimension(200, 25));
        typeCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(typeCombo);
        panel.add(Box.createVerticalStrut(10));

        JComboBox<String> priorityCombo = new JComboBox<>(new String[] { "low", "medium", "high" });
        priorityCombo.setMaximumSize(new Dimension(200, 25));
        priorityCombo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(priorityCombo);
        panel.add(Box.createVerticalStrut(20));

        JButton createBtn = new JButton("Create Issue");
        createBtn.setBackground(primaryBlue);
        createBtn.setForeground(Color.WHITE);
        createBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(createBtn);

        return panel;
    }

    // =======================
    // Issue Detail layout
    // =======================
    private JPanel createIssueDetailPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(bgSoftBlue);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Issue Detail");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setForeground(primaryBlue);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));

        panel.add(createLabelField("Title: [Placeholder]"));
        panel.add(createLabelField("Description: [Placeholder]"));
        panel.add(createLabelField("Type: [Placeholder]"));
        panel.add(createLabelField("Status: [Placeholder]"));
        panel.add(createLabelField("Priority: [Placeholder]"));
        panel.add(createLabelField("Labels: [Placeholder]"));
        panel.add(Box.createVerticalStrut(10));

        JButton assignBugBtn = new JButton("Assign Bug");
        assignBugBtn.setBackground(primaryBlue);
        assignBugBtn.setForeground(Color.WHITE);
        assignBugBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(assignBugBtn);
        panel.add(Box.createVerticalStrut(5));

        JButton addLabelBtn = new JButton("Add Label");
        addLabelBtn.setBackground(accentBlue);
        addLabelBtn.setForeground(Color.WHITE);
        addLabelBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(addLabelBtn);
        panel.add(Box.createVerticalStrut(5));

        JButton removeLabelBtn = new JButton("Remove Label");
        removeLabelBtn.setBackground(primaryBlue);
        removeLabelBtn.setForeground(Color.WHITE);
        removeLabelBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(removeLabelBtn);

        return panel;
    }

    private JLabel createLabelField(String text) {
        JLabel lbl = new JLabel(text);
        lbl.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        lbl.setOpaque(true);
        lbl.setBackground(Color.WHITE);
        lbl.setMaximumSize(new Dimension(600, 25));
        return lbl;
    }

    // =======================
    // Main
    // =======================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new AdminPanelBlue().setVisible(true);
        });
    }
}
