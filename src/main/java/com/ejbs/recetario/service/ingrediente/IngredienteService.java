package com.ejbs.recetario.service.ingrediente;

import java.util.List;

import com.ejbs.recetario.model.entity.Ingrediente;

public interface IngredienteService {
	public List<Ingrediente> listarTodoIngrediente();

	public Ingrediente obtenerIngrediente(Long idIngrediente);

	public Ingrediente guardarIngrediente(Ingrediente ingrediente);

	public Ingrediente actualizarIngrediente(Ingrediente ingrediente);
}
