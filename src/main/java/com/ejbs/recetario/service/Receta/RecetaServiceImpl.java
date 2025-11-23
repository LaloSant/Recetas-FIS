package com.ejbs.recetario.service.receta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.repository.RecetaRepository;

@Service
public class RecetaServiceImpl implements RecetaService {

	@Autowired
	private RecetaRepository repositorio;

	@Override
	public List<Receta> listarTodaReceta() {
		return repositorio.findAll();
	}

	@Override
	public Receta guardarReceta(Receta receta) {
		receta.setVisitasSemanales(0l);
		receta.setVisitasTotales(0l);
		receta.setCalificacion(0l);
		return repositorio.save(receta);
	}

	@Override
	public Optional<Receta> obtenerRecetaPorID(Long idReceta) {
		return repositorio.findById(idReceta);
	}

	@Override
	public List<Receta> obtenerTopSemana() {
		return repositorio.findAllByOrderByVisitasSemanalesDesc();
	}

	@Override
	public List<Receta> obtenerTopTotal() {
		return repositorio.findAllByOrderByVisitasTotalesDesc();
	}

	@Override
	public Optional<Receta> obtenerRecetasTotal() {
		throw new UnsupportedOperationException("Unimplemented method 'obtenerRecetasTotal'");
	}

	@Override
	public Receta actualizarReceta(Receta receta) {
		return repositorio.save(receta);
	}

	@Override
	public void eliminarReceta(Long idReceta) {
		repositorio.deleteById(idReceta);
	}

	@Override
	@Transactional
	public void aumentarVisita(Long idReceta) {
		repositorio.aumentarVisita(idReceta);
		
	}

	@Override
	@Transactional
	public void actualizarNombre(Long idReceta, String nombre) {
		repositorio.actualizarNombre(idReceta, nombre);
	}

}
