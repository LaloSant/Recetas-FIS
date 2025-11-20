package com.ejbs.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.service.Usuario.UsuarioService;

@Controller
public class LoginController {

	@Autowired
	UsuarioService repositorioUsuario;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping({ "/login" })
	public String login(Model model, @RequestParam(name = "error", required = false) String error, 
			@RequestParam(name = "logout", required = false) String logout) {
		boolean reintento = (error != null);
		boolean logoutExito = (logout != null);
		model.addAttribute("reintento", reintento);
		model.addAttribute("logout", logoutExito);
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

}
