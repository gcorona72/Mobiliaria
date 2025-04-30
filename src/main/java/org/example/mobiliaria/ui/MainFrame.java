package org.example.mobiliaria.ui;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de la aplicación.
 */
public class MainFrame extends JFrame {

    private final KitPanel kitPanel;

    public MainFrame() {
        super("Mobiliaria - Gestión de Kits");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        kitPanel = new KitPanel();
        add(kitPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Para lanzar la UI sin arranque Spring
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }
}
