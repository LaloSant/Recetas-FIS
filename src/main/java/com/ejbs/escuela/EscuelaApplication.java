package com.ejbs.escuela;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Getter;

@SpringBootApplication
public class EscuelaApplication {

    @Getter
    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        /* ApplicationContext context = SpringApplication.run(escuelaApplication.class, args); */
        SpringApplication.run(EscuelaApplication.class, args);

    }

}
