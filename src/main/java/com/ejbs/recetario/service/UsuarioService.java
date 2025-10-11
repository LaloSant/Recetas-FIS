package com.ejbs.recetario.service;

import java.util.List;

import com.ejbs.recetario.model.entity.Usuario;

public interface UsuarioService {

    public List<Usuario> listarTodoUsuario();

    public Usuario guardarUsuario(Usuario usuario);

    public Usuario obtenerUsuarioPorID(Long idUsuario);

    public Usuario actualizarUsuario(Usuario usuario);

    public void eliminarUsuario(Long idUsuario);
    
}
