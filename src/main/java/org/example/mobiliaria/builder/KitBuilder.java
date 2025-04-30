package org.example.mobiliaria.builder;

import org.example.mobiliaria.model.Elemento;
import org.example.mobiliaria.model.Kit;

import java.util.ArrayList;
import java.util.List;

/**
 * Builder para componer Kits paso a paso.
 */
public class KitBuilder {
    private int codigo;
    private final List<Elemento> componentes = new ArrayList<>();

    /** Establece el código del Kit. */
    public KitBuilder setCodigo(int codigo) {
        this.codigo = codigo;
        return this;
    }

    /** Añade un elemento (PiezaSimple o Kit) al Kit. */
    public KitBuilder addElemento(Elemento elemento) {
        this.componentes.add(elemento);
        return this;
    }

    /** Construye y devuelve el Kit completo. */
    public Kit build() {
        Kit kit = new Kit(codigo);
        for (Elemento e : componentes) {
            kit.addElemento(e);
        }
        return kit;
    }
}
