package com.ejbs.recetario.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ejbs.recetario.service.ImageGenerationService;

@Controller
public class HomeController {

    private final ImageGenerationService imageGenerationService;

    public HomeController(ImageGenerationService imageGenerationService) {
        this.imageGenerationService = imageGenerationService;
    }

    @RequestMapping({"/", "/home", "/index"})
    public String index() {
        generarImagen("Mujer mexicana cocinando enchiladas");
        return "index.html";
    }

    private void generarImagen(String prompt) {
        String resultado = imageGenerationService.generarImg(prompt);
        Path filePath = Path.of("salida.txt");
        try {
            Files.writeString(filePath, resultado);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File written successfully!");
    }
}
