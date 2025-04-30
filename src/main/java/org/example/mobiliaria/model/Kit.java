package org.example.mobiliaria.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Composite: un Kit agrupa múltiples Elemento (simples o kits).
 * El precio es la suma de sus componentes con un 10% de descuento.
 */
public class Kit extends Elemento {
    private final List<Elemento> componentes = new ArrayList<>();

    public Kit(int codigo) {
        super(codigo, 0.0);
    }

    public void addElemento(Elemento elemento) {
        componentes.add(elemento);
    }

    public List<Elemento> getComponentes() {
        return Collections.unmodifiableList(componentes);
    }

    @Override
    public double getPrecio() {
        double total = componentes.stream()
                .mapToDouble(Elemento::getPrecio)
                .sum();
        return total * 0.9; // aplicar 10% de descuento
    }
}
