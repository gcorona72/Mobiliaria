package org.example.mobiliaria.model;

/**
 * Hoja del Composite: pieza independiente con su propio precio.
 */
public class PiezaSimple extends Elemento {

    public PiezaSimple(int codigo, double precioBase) {
        super(codigo, precioBase);
    }

    @Override
    public double getPrecio() {
        return getPrecioBase();
    }
}
