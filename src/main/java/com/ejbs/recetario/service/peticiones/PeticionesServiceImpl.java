package com.ejbs.recetario.service.peticiones;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.PeticionIA;
import com.ejbs.recetario.repository.PeticionesRepository;

import jakarta.transaction.Transactional;

@Service
public class PeticionesServiceImpl implements PeticionesService{

	@Autowired
	PeticionesRepository repositorio;

	@Override
	public PeticionIA obtenerPeticion(Long idPeticion) {
		return repositorio.findById(idPeticion).get();
	}

	@Override
	public List<PeticionIA> obtenerTodaPeticion() {
		return repositorio.findAll();
	}

	@Override
	@Transactional
	public void actualizarPeticion(Long idPeticion, String estatus) {
		repositorio.actualizarEstatus(idPeticion, estatus);
	}

	@Override
	public PeticionIA generarPeticion(String descripcion) {
		return repositorio.save(new PeticionIA(descripcion));
	}

	@Override
	public void eliminarPeticion(Long idPeticion) {
		repositorio.deleteById(idPeticion);
	}
	
}
