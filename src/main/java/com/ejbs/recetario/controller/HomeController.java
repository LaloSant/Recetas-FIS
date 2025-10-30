package com.ejbs.recetario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    /* @Value("${spring.application.name}")
    private String appName; */
    
    @RequestMapping({"/index"})
    public String index() {
        return "index";
    }
}
