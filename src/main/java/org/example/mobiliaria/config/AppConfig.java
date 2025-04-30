package org.example.mobiliaria.config;

import org.example.mobiliaria.factory.KitCreator;
import org.example.mobiliaria.factory.KitFactory;
import org.example.mobiliaria.builder.KitBuilder;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * Bean para el Factory Method de Kits (singleton por defecto).
     */
    @Bean
    public KitCreator kitCreator() {
        return new KitFactory();
    }

    /**
     * Bean para el Builder de Kits (prototype para nueva instancia en cada petición).
     */
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public KitBuilder kitBuilder() {
        return new KitBuilder();
    }
}
