package com.ejbs.escuela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejbs.escuela.model.entity.Estudiante;
import com.ejbs.escuela.service.EstudianteService;


@Controller
public class EstudianteController {

    @Autowired
    EstudianteService servicio;

    @GetMapping({"/estudiantes"})
    public String listarEstudiantes(Model modelo) {
        //Spring se va solo a la implementacion
        modelo.addAttribute("estudiantes", servicio.listarTodoEstudiante());
        return "estudiantes";
    }

    @GetMapping({"/estudiantes/nuevo"})
    public String nuevoEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "nuevoEstudiante";
    }

    @GetMapping({"/estudiantes/editar"})
    public String editarEstudiante(Model modelo) {
        modelo.addAttribute("estudiantes", servicio.listarTodoEstudiante());
        return "editarEstudiante";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }
    

}
