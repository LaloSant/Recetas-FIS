package com.ejbs.recetario.service.detalle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejbs.recetario.model.entity.Detalle;
import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.repository.DetalleRepository;

import jakarta.transaction.Transactional;

@Service
public class DetalleServiceImpl implements DetalleService {

	@Autowired
	DetalleRepository repositorio;

	@Override
	public List<Detalle> listarTodoDetalle() {
		return repositorio.findAll();
	}

	@Override
	public List<Detalle> detallePorIdReceta(Long idReceta) {
		return repositorio.findByReceta_IdReceta(idReceta);
	}

	@Override
	public Detalle guardarDetalle(Detalle detalle) {
		return repositorio.save(detalle);
	}

	@Override
	@Transactional
	public void actualizarDetalle(Long idDetalle, Double cantidad, Long idIngrediente) {
		repositorio.actualizarDetalle(idDetalle, cantidad, idIngrediente);
	}

	@Override
	public void guardarDetalles(List<Detalle> detalles, Receta receta) {
		if (detalles != null) {
			for (Detalle detalle : detalles) {
				detalle.setReceta(receta);
				System.out.println(detalle.getIngrediente());
				detalle.setCosto(0d);
				repositorio.save(detalle);
			}
		}
	}

	@Override
	public void eliminarDetalle(Detalle detalle) {
		repositorio.delete(detalle);
	}

}
