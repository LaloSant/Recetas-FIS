package com.ejbs.recetario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService, UserDetailsService{

    @Autowired
    private UsuarioRepository repositorio;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repositorio.findByEmail(correo);
        if (usuario.isPresent()) {
            Usuario usuarioObj = usuario.get();
            return User.builder()
                        .username(usuarioObj.getNombre())
                        .password(usuarioObj.getContrasenia())
                        .build();
        }else{
            throw new UsernameNotFoundException(correo);
        }
    }

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
