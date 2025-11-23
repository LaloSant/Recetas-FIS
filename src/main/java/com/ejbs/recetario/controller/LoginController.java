package com.ejbs.recetario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.service.usuario.UsuarioServiceImpl;

@Controller
public class LoginController {

	@Autowired
	UsuarioServiceImpl usuarioRepositorio;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping({ "/login" })
	public String login(Model model, @RequestParam(required = false) String error,
			@RequestParam(required = false) String logout) {

		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user != null) {
			model.addAttribute("nomUser", user.getNombre());
			model.addAttribute("usuarioSesion", user);
		}
		boolean reintento = (error != null);
		boolean logoutExito = (logout != null);
		model.addAttribute("reintento", reintento);
		model.addAttribute("logout", logoutExito);
		model.addAttribute("usuario", new Usuario());
		return "login";
	}

}
