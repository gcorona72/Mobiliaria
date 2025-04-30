package org.example.mobiliaria.service;

import org.example.mobiliaria.factory.KitCreator;
import org.example.mobiliaria.builder.KitBuilder;
import org.example.mobiliaria.model.Elemento;
import org.example.mobiliaria.model.Kit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para orquestar la creación y consulta de Kits.
 */
@Service
public class KitService {

    private final KitCreator factory;
    private final KitBuilder builder;

    @Autowired
    public KitService(KitCreator factory, KitBuilder builder) {
        this.factory = factory;
        this.builder = builder;
    }

    /**
     * Crea un kit estándar.
     */
    public Kit crearKitEstandar(String tipo) {
        return factory.createKit(tipo);
    }

    /**
     * Crea un kit personalizado.
     */
    public Kit crearKitPersonalizado(int codigo, List<Elemento> elementos) {
        builder.setCodigo(codigo);
        elementos.forEach(builder::addElemento);
        return builder.build();
    }
}
