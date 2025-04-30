package org.example.mobiliaria;

import org.example.mobiliaria.factory.KitCreator;
import org.example.mobiliaria.builder.KitBuilder;
import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.service.KitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
class KitServiceIntegrationTest {

    @Autowired
    private KitService kitService;

    @Autowired
    private KitCreator kitCreator;

    @Autowired
    private KitBuilder kitBuilder;

    @Test
    void crearKitEstandarDesdeService() {
        Kit kit = kitService.crearKitEstandar("hogar");
        assertEquals(2000, kit.getCodigo());
        //  estantería(80)+mesa centro(120)=200*0.9=180
        assertEquals(180.0, kit.getPrecio(), 0.001);
    }

    @Test
    void crearKitPersonalizadoDesdeService() {
        Kit kit = kitService.crearKitPersonalizado(
                777,
                List.of(new org.example.mobiliaria.model.PiezaSimple(7, 40.0))
        );
        assertEquals(777, kit.getCodigo());
        assertEquals(36.0, kit.getPrecio(), 0.001);
    }
}
