package com.ejbs.recetario.service.paso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Paso;
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
}
