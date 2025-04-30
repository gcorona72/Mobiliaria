package org.example.mobiliaria;

import org.example.mobiliaria.service.KitService;
import org.example.mobiliaria.ui.MainFrame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.swing.SwingUtilities;
import java.awt.GraphicsEnvironment;

@SpringBootApplication
public class MobiliariaApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(MobiliariaApplication.class, args);

        // Solo arrancar Swing si existe un entorno gráfico disponible
        if (!GraphicsEnvironment.isHeadless()) {
            SwingUtilities.invokeLater(() -> {
                KitService kitService = ctx.getBean(KitService.class);
                MainFrame frame = new MainFrame(kitService);
                frame.setVisible(true);
            });
        } else {
            System.out.println("No hay entorno gráfico disponible. UI Swing no se iniciará.");
        }
    }
}
