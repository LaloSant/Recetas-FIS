package com.ejbs.escuela.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejbs.escuela.model.entity.Estudiante;

@Repository
//<Entidad, id>
public interface EstudianteRepository extends CrudRepository<Estudiante, String>{
    
}
