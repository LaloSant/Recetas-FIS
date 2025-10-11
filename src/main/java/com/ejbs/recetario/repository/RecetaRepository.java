package com.ejbs.recetario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejbs.recetario.model.entity.Receta;

@Repository
//<Entidad, id>
public interface RecetaRepository extends CrudRepository<Receta, Long>{
    
}
