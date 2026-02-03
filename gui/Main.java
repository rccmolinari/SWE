package gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Finestra principale
            JFrame frame = new JFrame("Login SWE");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Crea il pannello Login
            Login loginPanel = new Login();
            frame.setContentPane(loginPanel.getMainPanel());

            // Adatta la finestra al contenuto
            frame.pack();

            // Centra la finestra sullo schermo
            frame.setLocationRelativeTo(null);

            // Imposta una dimensione minima per evitare deformazioni
            frame.setMinimumSize(frame.getSize());

            frame.setVisible(true);
        });
    }
}
