package com.flerchante.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.flerchante.recetario.service.usuario.UserUtils;
import com.flerchante.recetario.service.usuario.UsuarioServiceImpl;


@Controller
public class UsuarioController {

	private final UserUtils userUtils;
 
	
	@Autowired
	private UsuarioServiceImpl repositorioUsuario;

	private static final String RUTA_VISTA = "/vistas/usuarios/";

	public UsuarioController(UserUtils userUtils) {
        this.userUtils = userUtils;
    }

	@GetMapping("/usuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", repositorioUsuario.listarTodoUsuario());
		return RUTA_VISTA + "usuarios";
	}

	@GetMapping("/editar")
	public String editarUsuario(Model modelo) {
		return RUTA_VISTA+ "editar";
	}
	
}
