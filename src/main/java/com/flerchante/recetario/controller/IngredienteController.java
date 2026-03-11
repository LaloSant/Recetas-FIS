package com.flerchante.recetario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flerchante.recetario.model.entity.Ingrediente;
import com.flerchante.recetario.model.entity.Usuario;
import com.flerchante.recetario.service.ingrediente.IngredienteServiceImpl;
import com.flerchante.recetario.service.usuario.UsuarioServiceImpl;

@Controller
public class IngredienteController {

	@Autowired
	private UsuarioServiceImpl usuarioRepositorio;

	@Autowired
	private IngredienteServiceImpl ingredienteRepositorio;

	private static final String RUTA_VISTA = "/vistas/ingredientes/";

	@GetMapping("/ingredientes")
	public String getListaIngredientes(Model modelo) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		modelo.addAttribute("rol", user.getRol().getNombre());
		modelo.addAttribute("nomUser", user.getNombre());
		List<Ingrediente> lista = ingredienteRepositorio.listarTodo();
		modelo.addAttribute("ingredientes", lista);
		return RUTA_VISTA + "lista";
	}

	@GetMapping("/ingredientes/id")
	public String getIngrediente(Model modelo, @RequestParam(required = true, defaultValue = "1") Long idIngrediente) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		modelo.addAttribute("rol", user.getRol().getNombre());
		modelo.addAttribute("nomUser", user.getNombre());
		Ingrediente i = ingredienteRepositorio.obtener(idIngrediente);

		modelo.addAttribute("idIngrediente", i.getNombre());

		return RUTA_VISTA + "ver";
	}
}
