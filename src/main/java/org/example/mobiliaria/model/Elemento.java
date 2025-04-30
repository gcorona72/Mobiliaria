package org.example.mobiliaria.model;

/**
 * Clase base para todos los elementos de la mobiliaria.
 */
public abstract class Elemento {
    private final int codigo;
    private final double precioBase;

    public Elemento(int codigo, double precioBase) {
        this.codigo = codigo;
        this.precioBase = precioBase;
    }

    public int getCodigo() {
        return codigo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Obtiene el precio del elemento.
     * - En PiezaSimple: será el precioBase.
     * - En Kit: aplicará el descuento correspondiente.
     */
    public abstract double getPrecio();
}
