package org.example.mobiliaria.config;

import org.example.mobiliaria.factory.KitCreator;
import org.example.mobiliaria.factory.KitFactory;
import org.example.mobiliaria.builder.KitBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /**
     * Bean para el Factory Method de Kits.
     */
    @Bean
    public KitCreator kitCreator() {
        return new KitFactory();
    }

    /**
     * Bean para el Builder de Kits.
     */
    @Bean
    public KitBuilder kitBuilder() {
        return new KitBuilder();
    }
}
