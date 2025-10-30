package com.ejbs.recetario.service.Rol;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Rol;
import com.ejbs.recetario.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    RolRepository rolRepository;

    @Override
    public Optional<Rol> obtenerRolPorID(String idRol) {
        return rolRepository.findById(idRol);
    }
    
}
