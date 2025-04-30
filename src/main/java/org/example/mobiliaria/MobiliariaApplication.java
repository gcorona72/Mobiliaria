// src/main/java/org/example/mobiliaria/MobiliariaApplication.java
package org.example.mobiliaria;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.mobiliaria.service.KitService;
import org.example.mobiliaria.ui.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SpringBootApplication
public class MobiliariaApplication {

    public static void main(String[] args) {
        // 1) Aplica FlatLaf antes de iniciar Swing
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("No se pudo aplicar FlatLaf: " + ex.getMessage());
        }

        // 2) Arranca Spring
        ApplicationContext ctx = SpringApplication.run(MobiliariaApplication.class, args);

        // 3) Lanza la UI en el hilo de Swing
        SwingUtilities.invokeLater(() -> {
            KitService kitService = ctx.getBean(KitService.class);
            MainFrame frame = new MainFrame(kitService);
            frame.setVisible(true);
        });
    }
}
