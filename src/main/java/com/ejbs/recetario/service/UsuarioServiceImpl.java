package com.ejbs.recetario.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<Usuario> listarTodoUsuario() {
        return (List<Usuario>) repositorio.findAll();
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorID(Long idUsuario) {
        return repositorio.findById(idUsuario).get();
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        return repositorio.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        repositorio.deleteById(idUsuario);
    }
    
}
