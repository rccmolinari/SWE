package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Login {

    private JPanel mainPanel;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;

    public Login() {
        createUI();
    }

   private void createUI() {

    // --------------------------
    // PALETTE Ladybug Theme
    // --------------------------
    Color bgSoftRed = new Color(253, 236, 236);
    Color primaryRed = new Color(255, 107, 107);
    Color green = new Color(76, 175, 80);
    Color borderGray = new Color(208, 208, 208);

    // --------------------------
    // MAIN PANEL
    // --------------------------
    mainPanel = new JPanel(new GridBagLayout());
    mainPanel.setBackground(bgSoftRed);
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.insets = new Insets(0, 0, 0, 0);

    // ==========================
    // LEFT PANEL (immagine)
    // ==========================
    JPanel leftPanel = new JPanel(new BorderLayout());
    leftPanel.setBackground(bgSoftRed);

    JLabel imgLabel = new JLabel();
    imgLabel.setHorizontalAlignment(SwingConstants.CENTER);
    imgLabel.setVerticalAlignment(SwingConstants.CENTER);

    // Carica immagine ridimensionata
    ImageIcon icon = new ImageIcon(getClass().getResource("/gui/images/bug4.png"));
    Image img = icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH); // dimensione fissa
    imgLabel.setIcon(new ImageIcon(img));

    leftPanel.add(imgLabel, BorderLayout.CENTER);

    gbc.gridx = 0;
    gbc.weightx = 0.25;  // occupa 25% larghezza
    gbc.weighty = 1.0;
    mainPanel.add(leftPanel, gbc);

    // ==========================
    // RIGHT PANEL (login)
    // ==========================
    JPanel rightWrapper = new JPanel(new GridBagLayout());
    rightWrapper.setBackground(bgSoftRed);

    JPanel formPanel = new JPanel();
    formPanel.setBackground(Color.WHITE);
    formPanel.setBorder(new LineBorder(new Color(230, 230, 230), 2, true));
    formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

    int squareSize = 400; // lato quadrato
    formPanel.setPreferredSize(new Dimension(squareSize, squareSize));

    formPanel.add(Box.createVerticalStrut(25));

    JLabel title = new JLabel("Welcome!");
    title.setFont(new Font("Arial", Font.BOLD, 26));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    formPanel.add(title);

    formPanel.add(Box.createVerticalStrut(10));

    JLabel subtitle = new JLabel("Sign in to continue");
    subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
    subtitle.setForeground(new Color(70, 70, 70));
    subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
    formPanel.add(subtitle);

    formPanel.add(Box.createVerticalStrut(30));

    // INPUT FIELDS
    emailField = new JTextField("Email Address");
    emailField.setMaximumSize(new Dimension(300, 45));
    emailField.setBorder(new LineBorder(borderGray, 2, true));
    emailField.setFont(new Font("Arial", Font.PLAIN, 15));
    emailField.setMargin(new Insets(10, 10, 10, 10));

    passwordField = new JPasswordField("Password");
    passwordField.setMaximumSize(new Dimension(300, 45));
    passwordField.setBorder(new LineBorder(borderGray, 2, true));
    passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
    passwordField.setMargin(new Insets(10, 10, 10, 10));

    formPanel.add(emailField);
    formPanel.add(Box.createVerticalStrut(15));
    formPanel.add(passwordField);

    formPanel.add(Box.createVerticalStrut(25));

    // BUTTONS
    JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
    btnPanel.setBackground(Color.WHITE);

    loginButton = new JButton("Login");
    loginButton.setPreferredSize(new Dimension(130, 40));
    loginButton.setBackground(primaryRed);
    loginButton.setForeground(Color.WHITE);
    loginButton.setBorder(new EmptyBorder(5, 15, 5, 15));

    registerButton = new JButton("Registrati");
    registerButton.setPreferredSize(new Dimension(130, 40));
    registerButton.setBackground(green);
    registerButton.setForeground(Color.WHITE);
    registerButton.setBorder(new EmptyBorder(5, 15, 5, 15));

    btnPanel.add(loginButton);
    btnPanel.add(registerButton);

    formPanel.add(btnPanel);

    rightWrapper.add(formPanel);

    gbc.gridx = 1;
    gbc.weightx = 0.75; // occupa 75% larghezza
    gbc.weighty = 1.0;
    mainPanel.add(rightWrapper, gbc);
}

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
