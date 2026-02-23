package com.flerchante.sabor.service.rol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flerchante.sabor.model.entity.Rol;
import com.flerchante.sabor.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService {

	@Autowired
	RolRepository rolRepository;

	@Override
	public Optional<Rol> obtenerRolPorID(String idRol) {
		if (idRol == null) {
			return null;
		}
		return rolRepository.findById(idRol);
	}

}
