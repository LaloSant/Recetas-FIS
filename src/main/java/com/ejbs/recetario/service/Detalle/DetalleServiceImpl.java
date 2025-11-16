package com.ejbs.recetario.service.Detalle;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ejbs.recetario.model.entity.Detalle;
import com.ejbs.recetario.repository.DetalleRepository;

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
	public Detalle actualizarDetalle(Detalle detalle) {
		return repositorio.save(detalle);
	}

}
