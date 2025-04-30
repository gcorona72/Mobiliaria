package org.example.mobiliaria.factory;

import org.example.mobiliaria.model.Elemento;
import org.example.mobiliaria.model.Kit;
import org.example.mobiliaria.model.PiezaSimple;

/**
 * Implementación concreta de KitCreator.
 * Define varios kits "estándar" precargados.
 */
public class KitFactory implements KitCreator {

    @Override
    public Kit createKit(String tipo) {
        // Ejemplo sencillo: según el tipo, agregamos piezas con códigos y precios fijos.
        Kit kit;
        switch (tipo.toLowerCase()) {
            case "oficina":
                kit = new Kit(1000);
                kit.addElemento(new PiezaSimple(1, 50.0));   // silla
                kit.addElemento(new PiezaSimple(2, 150.0));  // mesa
                break;
            case "hogar":
                kit = new Kit(2000);
                kit.addElemento(new PiezaSimple(3, 80.0));   // estantería
                kit.addElemento(new PiezaSimple(4, 120.0));  // mesa de centro
                break;
            default:
                throw new IllegalArgumentException("Tipo de kit desconocido: " + tipo);
        }
        return kit;
    }
}
