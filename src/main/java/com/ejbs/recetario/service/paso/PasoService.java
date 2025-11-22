package com.ejbs.recetario.service.paso;

import com.ejbs.recetario.model.entity.Paso;

public interface PasoService {
	public void actualizarPaso(Long idPaso, String notas);

	public Paso obtenerPaso(Long idPaso);
}
