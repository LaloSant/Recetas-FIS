package com.flerchante.sabor.service.ingrediente;

import java.util.List;

import com.flerchante.sabor.model.entity.Ingrediente;

public interface IngredienteService {
	public List<Ingrediente> listarTodo();

	public Ingrediente obtener(Long idIngrediente);

	public Ingrediente guardar(Ingrediente ingrediente);

	//public Ingrediente actualizar(Ingrediente ingrediente);
}
