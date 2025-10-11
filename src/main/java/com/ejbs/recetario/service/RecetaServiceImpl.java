package com.ejbs.recetario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements RecetaService{

    @Autowired
    private RecetaRepository repositorio;

    @Override
    public List<Receta> listarTodaReceta() {
        return (List<Receta>) repositorio.findAll();
    }

    @Override
    public Receta guardarReceta(Receta receta) {
        return repositorio.save(receta);
    }

    @Override
    public Receta obtenerRecetaPorID(Long idReceta) {
        return repositorio.findById(idReceta).get();
    }

    @Override
    public Receta actualizarReceta(Receta receta) {
        return repositorio.save(receta);
    }

    @Override
    public void eliminarReceta(Long idReceta) {
        repositorio.deleteById(idReceta);
    }

}
