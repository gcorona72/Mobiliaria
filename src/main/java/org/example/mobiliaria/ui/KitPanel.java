package org.example.mobiliaria.ui;

import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.model.PiezaSimple;
import org.example.mobiliaria.builder.KitBuilder;

import javax.swing.*;
import java.awt.*;

/**
 * Panel para crear y mostrar un Kit con Builder.
 */
public class KitPanel extends JPanel {

    private final JTextArea outputArea;

    public KitPanel() {
        setLayout(new BorderLayout());

        JPanel controls = new JPanel();
        JButton btnCrear = new JButton("Crear Kit Demo");
        controls.add(btnCrear);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        add(controls, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        btnCrear.addActionListener(e -> crearYMostrarKit());
    }

    private void crearYMostrarKit() {
        // Ejemplo de kit con Builder
        KitBuilder builder = new KitBuilder();
        Kit kit = builder
                .setCodigo(999)
                .addElemento(new PiezaSimple(10, 30.0))
                .addElemento(new PiezaSimple(11, 70.0))
                .build();

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
