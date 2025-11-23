package com.ejbs.recetario.service.paso;

import java.util.List;

import com.ejbs.recetario.model.entity.Paso;
import com.ejbs.recetario.model.entity.Receta;

public interface PasoService {
	public void actualizarPaso(Long idPaso, String notas);

	public Paso obtenerPaso(Long idPaso);

	public void guardarPasos(List<Paso> pasos, Receta receta);

	public void eliminarPaso(Paso paso);
}
