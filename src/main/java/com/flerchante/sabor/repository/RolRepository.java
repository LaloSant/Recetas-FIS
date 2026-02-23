package com.flerchante.sabor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flerchante.sabor.model.entity.Rol;

@Repository
//<Entidad, id>
public interface RolRepository extends JpaRepository<Rol, String> {

}
