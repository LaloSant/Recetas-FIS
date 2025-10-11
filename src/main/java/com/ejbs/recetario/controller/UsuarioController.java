package com.ejbs.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejbs.recetario.service.UsuarioService;

@Controller
public class UsuarioController {

    @Autowired
    UsuarioService servicio;

    @GetMapping({"/usuarios"})
    public String listarUsuarios(Model modelo) {
        modelo.addAttribute("usuarios", servicio.listarTodoUsuario());
        return "usuarios";
    }
}
