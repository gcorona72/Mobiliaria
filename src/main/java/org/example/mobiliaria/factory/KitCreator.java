package org.example.mobiliaria.factory;

import org.example.mobiliaria.model.Elemento;
import org.example.mobiliaria.model.Kit;

/**
 * Interfaz del Factory Method para crear Kits.
 */
public interface KitCreator {
    /**
     * Crea un Kit estándar según el tipo indicado.
     *
     * @param tipo identificador del kit (por ejemplo, "oficina", "hogar", etc.)
     * @return instancia de Kit ya configurada
     */
    Kit createKit(String tipo);
}
