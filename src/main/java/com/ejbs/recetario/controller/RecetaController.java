package com.ejbs.recetario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejbs.recetario.model.entity.Paso;
import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.service.ingrediente.IngredienteServiceImpl;
import com.ejbs.recetario.service.receta.RecetaServiceImpl;
import com.ejbs.recetario.service.usuario.UsuarioServiceImpl;

@Controller
public class RecetaController {

	private static final String RUTA_VISTA = "/vistas/recetas/";

	@Autowired
	RecetaServiceImpl recetaRepositorio;

	@Autowired
	UsuarioServiceImpl usuarioRepositorio;

	@Autowired
	IngredienteServiceImpl ingredienteRepositorio;

	@GetMapping({ "/recetas", "/" })
	public String listarRecetas(Model modelo,
			@RequestParam(required = false, defaultValue = "semana") String ordenarPor) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
			modelo.addAttribute("usuarioSesion", user);
		}
		List<Receta> recetas;
		if ("semana".equals(ordenarPor)) {
			recetas = recetaRepositorio.obtenerTopSemana();
			modelo.addAttribute("textoOrden", "Visitas semanales");
		} else {
			recetas = recetaRepositorio.obtenerTopTotal();
			modelo.addAttribute("textoOrden", "Visitas totales");
		}
		modelo.addAttribute("recetas", recetas);
		return RUTA_VISTA + "verRecetas";
	}

	@GetMapping("/recetas/ver")
	public String vistaReceta(Model modelo, @RequestParam(required = false, defaultValue = "1") Long idReceta) {
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(idReceta);
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
		}
		if (!recetaOpt.isPresent()) {
			return "redirect:/recetas";
		}
		Receta receta = recetaOpt.get();
		recetaRepositorio.aumentarVisita(idReceta);
		modelo.addAttribute("receta", receta);
		return RUTA_VISTA + "vistaReceta";
	}

	@GetMapping("/recetas/agregar")
	public String agregarReceta(Model modelo) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
		}
		return RUTA_VISTA + "agregarReceta";
	}

	@GetMapping("/recetas/{idReceta}")
	public String eliminarReceta(@PathVariable Long idReceta) {
		recetaRepositorio.eliminarReceta(idReceta);
		return RUTA_VISTA + "redirect:/recetas";
	}

	@GetMapping("/recetas/editar")
	public String editarReceta(Model modelo, @RequestParam(required = false) Long idReceta) {
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(idReceta);
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
		}
		if (!recetaOpt.isPresent()) {
			return "redirect:/recetas";
		}
		modelo.addAttribute("ingredientes", ingredienteRepositorio.listarTodoIngrediente());
		modelo.addAttribute("receta", recetaOpt.get());
		modelo.addAttribute("pasos", recetaOpt.get().getPasos());
		modelo.addAttribute("detalles", recetaOpt.get().getDetalles());
		System.out.println(recetaOpt.get());
		return RUTA_VISTA + "editarReceta";
	}

	@PostMapping("/recetas/editado")
	public String actualizarReceta(@ModelAttribute("receta") Receta recetaModelo) {
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(recetaModelo.getIdReceta());
		if (!recetaOpt.isPresent()) {
			return "redirect:/recetas";
		}
		Receta recetaExistente = recetaOpt.get();
		recetaRepositorio.actualizarNombre(recetaExistente.getIdReceta(), recetaModelo.getNombre());
		return "redirect:/recetas";
	}

	@PostMapping("/recetas/editado/pasos")
	public String actualizarPasos(@ModelAttribute("pasos") List<Paso> listaPasos) {
		for (Paso paso : listaPasos) {
			System.out.println(paso);
		}
		return "redirect:/recetas";
	}

	@PostMapping("/recetas/{numControl}")
	public String actualizarReceta(@PathVariable Long idReceta, @ModelAttribute("receta") Receta receta) {
		/*
		 * Receta existente = servicio.obtenerEstudianteID(numControl);
		 * existente.setNumControl(numControl);
		 * existente.setNombre(estudiante.getNombre());
		 * existente.setApPat(estudiante.getApPat());
		 * existente.setApMat(estudiante.getApMat());
		 * existente.setCorreo(estudiante.getCorreo());
		 * existente.setCreditos(estudiante.getCreditos());
		 * servicio.actualizarEstudiante(existente);
		 * return "redirect:/recetas";
		 */
		return "";
	}

}
