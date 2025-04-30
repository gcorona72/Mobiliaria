package org.example.mobiliaria;

import org.example.mobiliaria.factory.KitCreator;
import org.example.mobiliaria.factory.KitFactory;
import org.example.mobiliaria.builder.KitBuilder;
import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.model.PiezaSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryAndBuilderTest {

    @Test
    void factoryCreaKitOficinaConDosElementos() {
        KitCreator factory = new KitFactory();
        Kit kit = factory.createKit("oficina");
        assertEquals(1000, kit.getCodigo());
        // Silla(50) + Mesa(150) = 200 → 200*0.9 = 180
        assertEquals(180.0, kit.getPrecio(), 0.001);
        assertEquals(2, kit.getComponentes().size());
    }

    @Test
    void builderCreaKitPersonalizado() {
        KitBuilder builder = new KitBuilder()
                .setCodigo(500)
                .addElemento(new PiezaSimple(5, 30.0))
                .addElemento(new PiezaSimple(6, 70.0));
        Kit kit = builder.build();
        assertEquals(500, kit.getCodigo());
        // 30 + 70 = 100 → 100*0.9 = 90
        assertEquals(90.0, kit.getPrecio(), 0.001);
    }
}
