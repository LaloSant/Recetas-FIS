package com.flerchante.sabor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.flerchante.sabor.service.usuario.UsuarioServiceImpl;

@Controller
public class UsuarioController {

	private static final String RUTA_VISTA = "/vistas/usuarios/";

	@Autowired
	private UsuarioServiceImpl repositorioUsuario;

	@GetMapping("/usuarios")
	public String listarUsuarios(Model modelo) {
		modelo.addAttribute("usuarios", repositorioUsuario.listarTodoUsuario());
		return RUTA_VISTA + "usuarios";
	}
}
