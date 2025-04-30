// src/main/java/org/example/mobiliaria/ui/MainFrame.java
package org.example.mobiliaria.ui;

import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.model.PiezaSimple;
import org.example.mobiliaria.service.KitService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {

    private final KitService kitService;

    public MainFrame(KitService kitService) {
        super("Mobiliaria - Gestión de Kits");
        this.kitService = kitService;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        // Panel raíz con BorderLayout
        JPanel root = new JPanel(new BorderLayout());
        root.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Zona de botones en la parte superior
        JPanel controls = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        JButton btnFactory = new JButton("Kit Oficina (Factory)");
        JButton btnBuilder = new JButton("Kit Demo (Builder)");
        controls.add(btnFactory);
        controls.add(btnBuilder);
        root.add(controls, BorderLayout.NORTH);

        // Contenedor de tarjetas dentro de scroll
        JPanel cardsContainer = new JPanel();
        cardsContainer.setLayout(new BoxLayout(cardsContainer, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(cardsContainer);
        scrollPane.setBorder(null);
        root.add(scrollPane, BorderLayout.CENTER);

        // Listeners de botones
        btnFactory.addActionListener(e -> {
            cardsContainer.removeAll();
            Kit kit = kitService.crearKitEstandar("oficina");
            cardsContainer.add(makeCard(kit));
            cardsContainer.revalidate();
            cardsContainer.repaint();
        });

        btnBuilder.addActionListener(e -> {
            cardsContainer.removeAll();
            Kit kit = kitService.crearKitPersonalizado(
                    999,
                    List.of(new PiezaSimple(10, 30.0), new PiezaSimple(11, 70.0))
            );
            cardsContainer.add(makeCard(kit));
            cardsContainer.revalidate();
            cardsContainer.repaint();
        });

        setContentPane(root);
    }

    /**
     * Construye un JPanel estilo "card" para mostrar la información del Kit.
     */
    private JPanel makeCard(Kit kit) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(UIManager.getColor("Panel.background"));
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1, true),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel title = new JLabel("Kit código: " + kit.getCodigo());
        title.setFont(title.getFont().deriveFont(Font.BOLD, 16f));
        card.add(title);
        card.add(Box.createVerticalStrut(5));

        JLabel price = new JLabel(String.format("Precio total: %.2f", kit.getPrecio()));
        price.setFont(price.getFont().deriveFont(14f));
        card.add(price);
        card.add(Box.createVerticalStrut(10));

        // Lista de componentes
        for (var componente : kit.getComponentes()) {
            JLabel line = new JLabel(
                    String.format("• Código %d → %.2f",
                            componente.getCodigo(),
                            componente.getPrecio())
            );
            line.setFont(line.getFont().deriveFont(13f));
            card.add(line);
        }

        return card;
    }
}
