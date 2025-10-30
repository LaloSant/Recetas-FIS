package com.ejbs.recetario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.service.Receta.RecetaServiceImpl;

@Controller
public class RecetaController {

	private static final String RUTA_VISTA = "/vistas/recetas/";

	@Autowired
	RecetaServiceImpl servicio;

	@GetMapping({ "/recetas", "/" })
	public String listarRecetas(Model modelo,
			@RequestParam(name = "ordenarPor", required = false, defaultValue = "semana") String ordenarPor) {
		List<Receta> recetas;
		if ("semana".equals(ordenarPor)) {
			recetas = servicio.obtenerTopSemana();
			modelo.addAttribute("textoFiltro", "Visitas semanales");
			modelo.addAttribute("porSemana", true);
		} else {
			// if("total".equals(ordenarPor))
			recetas = servicio.obtenerTopTotal();
			modelo.addAttribute("textoFiltro", "Visitas totales");
			modelo.addAttribute("porTotal", true);
		}
		modelo.addAttribute("recetas", recetas);
		return RUTA_VISTA + "verRecetas";
	}

	@GetMapping({ "/recetas/ver" })
	public String nuevaReceta(Model modelo,
			@RequestParam(name = "idReceta", required = false, defaultValue = "1") Long idReceta) {
		modelo.addAttribute("idReceta", idReceta);
		return RUTA_VISTA + "vistaReceta";
	}

	@GetMapping("/recetas/editar/{idReceta}")
	public String editarReceta(Model modelo, @PathVariable Long idReceta) {
		modelo.addAttribute("receta", servicio.obtenerRecetaPorID(idReceta));
		return RUTA_VISTA + "editarReceta";
	}

	@GetMapping("/recetas/{idReceta}")
	public String eliminarReceta(@PathVariable Long idReceta) {
		servicio.eliminarReceta(idReceta);
		return RUTA_VISTA + "redirect:/recetas";
	}

	@PostMapping("/recetas")
	public String guardarReceta(@ModelAttribute("receta") Receta receta) {
		servicio.guardarReceta(receta);
		return RUTA_VISTA + "redirect:/recetas";
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
