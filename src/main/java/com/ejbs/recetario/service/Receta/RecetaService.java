package com.ejbs.recetario.service.Receta;

import java.util.List;
import java.util.Optional;

import com.ejbs.recetario.model.entity.Receta;

public interface RecetaService {

	public List<Receta> listarTodaReceta();

	public Receta guardarReceta(Receta receta);

	public Optional<Receta> obtenerRecetaPorID(Long idReceta);

	public List<Receta> obtenerTopSemana();

	public List<Receta> obtenerTopTotal();

	public Optional<Receta> obtenerRecetasTotal();

	public Receta actualizarReceta(Receta receta);

	public void eliminarReceta(Long idReceta);
}
