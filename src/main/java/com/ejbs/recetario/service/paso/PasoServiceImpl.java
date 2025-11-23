package com.ejbs.recetario.service.paso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Paso;
import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.repository.PasoRepository;

import jakarta.transaction.Transactional;

@Service
public class PasoServiceImpl implements PasoService {

	@Autowired
	PasoRepository repositorio;

	@Override
	@Transactional
	public void actualizarPaso(Long idPaso, String notas) {
		repositorio.actualizarNombre(idPaso, notas);
	}

	@Override
	public Paso obtenerPaso(Long idPaso) {
		return repositorio.findById(idPaso).get();
	}

	@Override
	public void guardarPasos(List<Paso> pasos, Receta receta) {
		if (pasos != null) {
			for (int i = 0; i < pasos.size(); i++) {
				Paso paso = pasos.get(i);
				paso.setReceta(receta);
				paso.setIndicePaso(i + 1l); // Asignamos el número de paso
				repositorio.save(paso);
			}
		}
	}

	@Override
	public void eliminarPaso(Paso paso) {
		repositorio.delete(paso);
	}

}
