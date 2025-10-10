package com.ejbs.recetario.service;

import java.util.List;

import com.ejbs.recetario.model.entity.Estudiante;

public interface EstudianteService {

    public List<Estudiante> listarTodoEstudiante();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudianteID(String numControl);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(String numControl);
}
