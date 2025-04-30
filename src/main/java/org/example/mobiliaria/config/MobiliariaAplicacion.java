package org.example.mobiliaria.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example.mobiliaria")
public class MobiliariaAplicacion {
    public static void main(String[] args) {
        SpringApplication.run(MobiliariaAplicacion.class, args);
    }
}
