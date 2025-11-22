package com.ejbs.recetario.service.detalle;

import java.util.List;


import com.ejbs.recetario.model.entity.Detalle;

public interface DetalleService {

	public List<Detalle> listarTodoDetalle();

	public List<Detalle> detallePorIdReceta(Long idReceta);

	public Detalle guardarDetalle(Detalle detalle);

	public void actualizarDetalle(Long idDetalle, Double cantidad, Long idIngrediente);

}
