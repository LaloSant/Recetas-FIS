package com.ejbs.recetario.service.ingrediente;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Ingrediente;
import com.ejbs.recetario.repository.IngredienteRepository;

@Service
public class IngredienteServiceImpl implements IngredienteService {

	@Autowired
	IngredienteRepository repositorio;

	@Override
	public Ingrediente obtenerIngrediente(Long idIngrediente) {
		if (idIngrediente == null) {
			return null;
		}
		return repositorio.findById(idIngrediente).get();
	}

	@Override
	public List<Ingrediente> listarTodoIngrediente() {
		return repositorio.findAll().stream()
				.sorted(Comparator.comparing(Ingrediente::getNombre))
				.collect(Collectors.toList());
	}

	@Override
	public Ingrediente guardarIngrediente(Ingrediente ingrediente) {
		if (ingrediente == null) {
			return null;
		}
		return repositorio.save(ingrediente);
	}

	@Override
	public Ingrediente actualizarIngrediente(Ingrediente ingrediente) {
		return this.guardarIngrediente(ingrediente);
	}

}
