package com.flerchante.sabor.service.rol;

import java.util.Optional;

import com.flerchante.sabor.model.entity.Rol;

public interface  RolService {
    public Optional<Rol> obtenerRolPorID(String idRol);
}
