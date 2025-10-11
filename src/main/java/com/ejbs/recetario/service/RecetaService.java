package com.ejbs.recetario.service;

import java.util.List;

import com.ejbs.recetario.model.entity.Receta;

public interface RecetaService {

    public List<Receta> listarTodaReceta();

    public Receta guardarReceta(Receta receta);

    public Receta obtenerRecetaPorID(Long idReceta);

    public Receta actualizarReceta(Receta receta);

    public void eliminarReceta(Long idReceta);
}
