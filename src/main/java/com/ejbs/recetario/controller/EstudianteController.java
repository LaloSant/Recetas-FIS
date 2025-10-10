package com.ejbs.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejbs.recetario.model.entity.Estudiante;
import com.ejbs.recetario.service.EstudianteService;



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

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante) {
        servicio.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{numControl}")
    public String editarEstudiante(Model modelo, @PathVariable String numControl) {
        modelo.addAttribute("estudiante", servicio.obtenerEstudianteID(numControl));
        return "editarEstudiante";
    }

    @PostMapping("/estudiantes/{numControl}")
    public String actualizarEstudiante(@PathVariable String numControl, @ModelAttribute("estudiante") Estudiante estudiante) {
        Estudiante existente = servicio.obtenerEstudianteID(numControl);
        existente.setNumControl(numControl);
        existente.setNombre(estudiante.getNombre());
        existente.setApPat(estudiante.getApPat());
        existente.setApMat(estudiante.getApMat());
        existente.setCorreo(estudiante.getCorreo());
        existente.setCreditos(estudiante.getCreditos());
        servicio.actualizarEstudiante(existente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{numControl}")
    public String eliminarEstudiante(@PathVariable String numControl) {
        servicio.eliminarEstudiante(numControl);
        return "redirect:/estudiantes";
    }

    

}
