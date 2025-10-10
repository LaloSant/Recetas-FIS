package com.ejbs.recetario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Estudiante;
import com.ejbs.recetario.repository.EstudianteRepository;

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

    @Override
    public Estudiante obtenerEstudianteID(String numControl) {
        return repositorio.findById(numControl).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return repositorio.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(String numControl) {
        repositorio.deleteById(numControl);
    }

}
