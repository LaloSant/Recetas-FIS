package com.ejbs.recetario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Rol;
import com.ejbs.recetario.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    RolRepository rolRepository;

    @Override
    public Rol obtenerRolPorID(Long idRol) {
        return rolRepository.findById(idRol).get();
    }
    
}
