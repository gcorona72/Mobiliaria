package org.example.mobiliaria.ui;

import org.example.mobiliaria.service.KitService;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal de la aplicación, recibe KitService inyectado.
 */
public class MainFrame extends JFrame {

    private final KitPanel kitPanel;

    public MainFrame(KitService kitService) {
        super("Mobiliaria - Gestión de Kits");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Inyectamos kitService en el panel
        kitPanel = new KitPanel(kitService);
        add(kitPanel, BorderLayout.CENTER);
    }
}
