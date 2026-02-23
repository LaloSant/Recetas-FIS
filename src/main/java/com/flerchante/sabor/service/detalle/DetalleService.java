package com.flerchante.sabor.service.detalle;

import java.util.List;

import com.flerchante.sabor.model.entity.Detalle;
import com.flerchante.sabor.model.entity.Receta;

public interface DetalleService {

	public List<Detalle> listarTodoDetalle();

	public List<Detalle> buscarPorIngredientes(List<Long> ids);

	public List<Long> buscarPorIngredientes(List<Long> ids, Long size);

	public List<Detalle> detallePorIdReceta(Long idReceta);

	public Detalle guardarDetalle(Detalle detalle);

	public void guardarDetalles(List<Detalle> detalles, Receta receta);

	public void actualizarDetalle(Long idDetalle, Double cantidad, Long idIngrediente);

	public void eliminarDetalle(Detalle detalle);

}
