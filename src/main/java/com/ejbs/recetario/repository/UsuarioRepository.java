package com.ejbs.recetario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ejbs.recetario.model.entity.Usuario;

@Repository
public interface  UsuarioRepository extends CrudRepository<Usuario, Long>{
    
}
