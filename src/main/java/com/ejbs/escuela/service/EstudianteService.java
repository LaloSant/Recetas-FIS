package com.ejbs.escuela.service;

import java.util.List;

import com.ejbs.escuela.model.entity.Estudiante;

public interface EstudianteService {

    public List<Estudiante> listarTodoEstudiante();

    public Estudiante guardarEstudiante(Estudiante estudiante);
    
}
