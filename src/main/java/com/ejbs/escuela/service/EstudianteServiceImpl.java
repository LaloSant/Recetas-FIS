package com.ejbs.escuela.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.escuela.model.entity.Estudiante;
import com.ejbs.escuela.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService{

    @Autowired
    private EstudianteRepository repositorio;

    @Override
    public List<Estudiante> listarTodoEstudiante() {
        return (List<Estudiante>) repositorio.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }
    
}
