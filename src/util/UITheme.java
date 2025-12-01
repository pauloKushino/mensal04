package util;

import javax.swing.*;
import java.awt.*;

public class UITheme {
    public static final Color PRIMARY_COLOR = new Color(44, 62, 80);
    public static final Color SECONDARY_COLOR = new Color(236, 240, 241);
    public static final Color BUTTON_COLOR = new Color(52, 152, 219);
    public static final Color TEXT_COLOR = new Color(33, 33, 33);
    public static final Font MAIN_FONT = new Font("Segoe UI", Font.PLAIN, 14);

    public static void styleButton(JButton button) {
        button.setBackground(BUTTON_COLOR);
        button.setForeground(Color.WHITE);
        button.setFont(MAIN_FONT);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 15));
    }

    public static void styleLabel(JLabel label) {
        label.setFont(MAIN_FONT);
        label.setForeground(TEXT_COLOR);
    }

    public static void styleField(JTextField field) {
        field.setFont(MAIN_FONT);
        field.setBackground(SECONDARY_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setBorder(BorderFactory.createLineBorder(PRIMARY_COLOR, 1));
    }

    public static void styleFrame(JFrame frame) {
        frame.getContentPane().setBackground(SECONDARY_COLOR);
    }
}
