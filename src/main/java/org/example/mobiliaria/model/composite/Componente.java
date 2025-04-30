package org.example.mobiliaria.model.composite;

/**
 * Interfaz para el patrón Composite.
 * Tanto Elemento (leaf) como Kit (composite) la implementarán.
 */
public interface Componente {
    int getCodigo();
    double getPrecio();
}
