package com.ejbs.recetario.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ejbs.recetario.model.entity.Rol;
import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.service.rol.RolServiceImpl;
import com.ejbs.recetario.service.usuario.UsuarioServiceImpl;

@Controller
public class RegistroController {

	@Autowired
	private UsuarioServiceImpl repositorioUsuario;

	@Autowired
	private RolServiceImpl repositorioRol;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping(value = "/registro")
	public String registro(Model model) {
		model.addAttribute("usuario", new Usuario());
		Usuario user = repositorioUsuario.getUsuarioSesion();
		if (user != null) {
			model.addAttribute("nomUser", user.getNombre());
		}
		return "registro";
	}

	@PostMapping(value = "/registro")
	public String guardarUsuario(@ModelAttribute Usuario usuario) {
		Optional<Rol> rolOptional = repositorioRol.obtenerRolPorID("USER");
		if (!rolOptional.isPresent()) {
			usuario.setRol(null);
			return "login";
		}
		usuario.setRol(rolOptional.get());
		usuario.setContrasenia(passwordEncoder.encode(usuario.getContrasenia()));
		repositorioUsuario.guardarUsuario(usuario);
		return "login";
	}

}
