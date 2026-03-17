package com.flerchante.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.flerchante.recetario.model.entity.Usuario;
import com.flerchante.recetario.service.usuario.UserUtils;
import com.flerchante.recetario.service.usuario.UsuarioServiceImpl;

@Controller
public class UsuarioController {

	@Autowired
	private UserUtils userUtils;

	@Autowired
	private UsuarioServiceImpl usuarioRepositorio;
	
	@Autowired
	private UsuarioServiceImpl repositorioUsuario;

	private static final String RUTA_VISTA = "/vistas/usuarios/";

	@GetMapping("/usuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", repositorioUsuario.listarTodoUsuario());
		return RUTA_VISTA + "usuarios";
	}

	@GetMapping("/usuarios/editar")
	public String editarUsuario(Model modelo) {
		userUtils.setUserSession(modelo);
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user == null) {
			return "redirect:/recetas";
		}
		return RUTA_VISTA + "editar";
	}

}
