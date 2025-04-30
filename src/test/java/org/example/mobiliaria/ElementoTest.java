package org.example.mobiliaria;

import org.example.mobiliaria.model.PiezaSimple;
import org.example.mobiliaria.model.Kit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementoTest {

    @Test
    void piezaSimpleDevuelvePrecioBase() {
        PiezaSimple pieza = new PiezaSimple(1, 100.0);
        assertEquals(100.0, pieza.getPrecio(), 0.001);
    }

    @Test
    void kitAplicaDescuentoDel10PorCiento() {
        Kit kit = new Kit(10);
        kit.addElemento(new PiezaSimple(1, 50.0));
        kit.addElemento(new PiezaSimple(2, 50.0));
        // Total sin descuento = 100.0 → con 10% de dto = 90.0
        assertEquals(90.0, kit.getPrecio(), 0.001);
    }
}
