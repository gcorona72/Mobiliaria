package org.example.mobiliaria.ui;

import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.model.PiezaSimple;
import org.example.mobiliaria.service.KitService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Panel para crear y mostrar un Kit usando el KitService.
 */
public class KitPanel extends JPanel {

    private final JTextArea outputArea;
    private final KitService kitService;

    public KitPanel(KitService kitService) {
        this.kitService = kitService;

        setLayout(new BorderLayout());
        JPanel controls = new JPanel();
        JButton btnEstandar = new JButton("Kit Oficina (Factory)");
        JButton btnPersonalizado = new JButton("Kit Demo (Builder)");

        controls.add(btnEstandar);
        controls.add(btnPersonalizado);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(controls, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        btnEstandar.addActionListener(e -> mostrarKitEstandar());
        btnPersonalizado.addActionListener(e -> mostrarKitPersonalizado());
    }

    private void mostrarKitEstandar() {
        Kit kit = kitService.crearKitEstandar("oficina");
        renderizar(kit);
    }

    private void mostrarKitPersonalizado() {
        // Demo: código 999 con dos piezas
        Kit kit = kitService.crearKitPersonalizado(
                999,
                List.of(
                        new PiezaSimple(10, 30.0),
                        new PiezaSimple(11, 70.0)
                )
        );
        renderizar(kit);
    }

    private void renderizar(Kit kit) {
        StringBuilder sb = new StringBuilder();
        sb.append("Kit código: ").append(kit.getCodigo()).append("\n")
                .append("Precio total: ").append(kit.getPrecio()).append("\n")
                .append("Componentes:\n");
        kit.getComponentes().forEach(c ->
                sb.append("  • Código ").append(c.getCodigo())
                        .append(" → ").append(c.getPrecio()).append("\n")
        );
        outputArea.setText(sb.toString());
    }
}
