package com.ejbs.recetario.controller;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;

import com.ejbs.recetario.model.dto.PasoDTO;
import com.ejbs.recetario.model.dto.RecetaCompDTO;
import com.ejbs.recetario.model.entity.Detalle;
import com.ejbs.recetario.model.entity.Paso;
import com.ejbs.recetario.model.entity.Receta;
import com.ejbs.recetario.model.entity.Usuario;
import com.ejbs.recetario.service.detalle.DetalleServiceImpl;
import com.ejbs.recetario.service.ingrediente.IngredienteServiceImpl;
import com.ejbs.recetario.service.paso.PasoServiceImpl;
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

	@Autowired
	PasoServiceImpl pasoRepositorio;

	@Autowired
	DetalleServiceImpl detalleRepositorio;

	@GetMapping({ "/recetas", "/" })
	public String listarRecetas(Model modelo,
			@RequestParam(required = false, defaultValue = "semana") String ordenarPor,
			@RequestParam(required = false) String nombreReceta,
			@RequestParam(required = false) List<Long> ingredientes,
			@RequestParam(required = false) Integer exclusivo) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		modelo.addAttribute("ingredientes", ingredienteRepositorio.listarTodoIngrediente());
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
			modelo.addAttribute("usuarioSesion", user);
		}
		List<Receta> recetas;
		if (nombreReceta != null && !nombreReceta.isBlank()) {
			recetas = recetaRepositorio.obtenerTodoPor(nombreReceta);
			modelo.addAttribute("recetas", recetas);
			return RUTA_VISTA + "verRecetas";
		}
		if (ingredientes != null) {
			if (exclusivo != null && exclusivo == 1) {
				modelo.addAttribute("exclusivo", 1);
				List<Long> recetasIds = detalleRepositorio.buscarPorIngredientes(ingredientes,
						(long) ingredientes.size());
				recetas = recetaRepositorio.obtenerTodoPor(recetasIds);
				modelo.addAttribute("recetas", recetas);
				modelo.addAttribute("ingredientesSel", ingredientes);
				return RUTA_VISTA + "verRecetas";
			}
			List<Detalle> detalles = detalleRepositorio.buscarPorIngredientes(ingredientes);
			Set<Receta> set = new HashSet<>();
			for (Detalle detalle : detalles) {
				set.add(detalle.getReceta());
			}
			recetas = new ArrayList<>(set);
			modelo.addAttribute("exclusivo", 0);
			modelo.addAttribute("recetas", recetas);
			modelo.addAttribute("ingredientesSel", ingredientes);
			return RUTA_VISTA + "verRecetas";
		}
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

	@PostMapping("/recetas/calificar")
	public String calificarReceta(@RequestParam("idReceta") Long idReceta,
			@RequestParam("calificacion") int calificacionNueva) {
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(idReceta);
		if (recetaOpt.isPresent()) {
			Receta receta = recetaOpt.get();
			receta.actualizarCalificacion(calificacionNueva);
			recetaRepositorio.actualizarCalificacion(idReceta, receta.getCalificacion());
		}
		return String.format("redirect:/recetas/ver?idReceta=%d", idReceta);
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
		modelo.addAttribute("costo", receta.calcularCosto());
		return RUTA_VISTA + "vistaReceta";
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
		Receta rec = recetaOpt.get();
		List<PasoDTO> pasoImagenes = new ArrayList<>();
		for (int i = 0; i < rec.getPasos().size(); i++) {
			pasoImagenes.add(new PasoDTO(rec.getPasos().get(i), null));
		}
		RecetaCompDTO dto = new RecetaCompDTO(rec, rec.getPasos(), rec.getDetalles(), null, pasoImagenes);
		modelo.addAttribute("ingredientes", ingredienteRepositorio.listarTodoIngrediente());
		modelo.addAttribute("dto", dto);
		return RUTA_VISTA + "editarReceta";
	}

	@PostMapping("/recetas/editar")
	public String actualizarReceta(@ModelAttribute("dto") RecetaCompDTO dto) {
		if (dto == null || dto.getReceta() == null || dto.getReceta().getIdReceta() == null) {
			System.out.println("[actualizarReceta] ERROR: dto o receta o idReceta es nulo");
			return "redirect:/recetas";
		}
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(dto.getReceta().getIdReceta());
		if (!recetaOpt.isPresent()) {
			return "redirect:/recetas";
		}
		Receta recetaExistente = recetaOpt.get();
		List<Paso> pasos = dto.getPasos();
		List<PasoDTO> pasoImagenes = dto.getPasoDTOs();

		if (pasos != null) {
			for (int i = 0; i < pasos.size(); i++) {
				Paso paso = pasos.get(i);
				if (paso.getIdPaso() != null && paso.getNotas() != null) {
					Paso pasoExistente = pasoRepositorio.obtenerPaso(paso.getIdPaso());
					pasoExistente.setNotas(paso.getNotas());
					if (pasoImagenes != null && i < pasoImagenes.size() && pasoImagenes.get(i).getImagen() != null
							&& !pasoImagenes.get(i).getImagen().isEmpty()) {
						try {
							byte[] bytes = pasoImagenes.get(i).getImagen().getBytes();
							Blob blob = new SerialBlob(bytes);
							pasoExistente.setImagen(blob);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					pasoRepositorio.actualizarPaso(pasoExistente.getIdPaso(), pasoExistente.getNotas(),
							pasoExistente.getImagen());
				} else {
					pasoRepositorio.guardarPasos(Arrays.asList(paso), recetaExistente, i + 1l); // nuevo
				}
			}
		}
		List<Detalle> detalles = dto.getDetalles();
		if (detalles != null) {
			for (Detalle detalle : detalles) {
				if (detalle.getIdDetalle() != null && detalle.getCantidad() != null
						&& detalle.getIngrediente() != null && detalle.getIngrediente().getIdIngrediente() != null) {
					detalleRepositorio.actualizarDetalle(detalle.getIdDetalle(), detalle.getCantidad(),
							detalle.getIngrediente().getIdIngrediente());
				} else if (detalle.getIdDetalle() == null) {
					detalleRepositorio.guardarDetalles(Arrays.asList(detalle), recetaExistente);
				}
			}
		}
		MultipartFile archivo = dto.getImagen();
		if (archivo != null && !archivo.isEmpty()) {
			try {
				byte[] bytes = archivo.getBytes();
				Blob blob = new SerialBlob(bytes);
				recetaExistente.setImagen(blob);
				recetaRepositorio.guardarReceta(recetaExistente);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (dto.getReceta().getNombre() != null) {
			recetaRepositorio.actualizarNombre(recetaExistente.getIdReceta(), dto.getReceta().getNombre());
		}

		return "redirect:/recetas";
	}

	@GetMapping("/receta/agregar")
	public String agregarRecetaVista(Model modelo) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		RecetaCompDTO dto = new RecetaCompDTO();
		PasoDTO pdto = new PasoDTO();
		if (user != null) {
			modelo.addAttribute("nomUser", user.getNombre());
		}
		modelo.addAttribute("dto", dto);
		modelo.addAttribute("pdto", pdto);
		modelo.addAttribute("ingredientes", ingredienteRepositorio.listarTodoIngrediente());
		return RUTA_VISTA + "agregarReceta";
	}

	@PostMapping("/receta/agregar")
	public String agregarReceta(@ModelAttribute("dto") RecetaCompDTO dto) {
		Usuario user = usuarioRepositorio.getUsuarioSesion();
		if (user == null) {
			return "redirect:/login";
		}
		Receta nuevaReceta = dto.getReceta();
		nuevaReceta.setUsuario(user);

		MultipartFile archivo = dto.getImagen();
		if (archivo != null && !archivo.isEmpty()) {
			try {
				byte[] bytes = archivo.getBytes();
				Blob blob = new SerialBlob(bytes);
				nuevaReceta.setImagen(blob);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Receta recetaGuardada = recetaRepositorio.guardarReceta(nuevaReceta);
		List<Paso> pasos = dto.getPasos();
		pasoRepositorio.guardarPasos(pasos, recetaGuardada);
		List<Detalle> detalles = dto.getDetalles();
		detalleRepositorio.guardarDetalles(detalles, recetaGuardada);
		return "redirect:/recetas";
	}

	@GetMapping("/recetas/eliminar")
	public String eliminarReceta(Model modelo, @RequestParam(required = true) Long idReceta,
			@RequestParam(required = true) String nom) {
		Optional<Receta> recetaOpt = recetaRepositorio.obtenerRecetaPorID(idReceta);
		if (!recetaOpt.isPresent()) {
			return "redirect:/recetas";
		}
		if (!recetaOpt.get().getUsuario().getNombre().equals(nom)) {
			return "redirect:/recetas";
		}
		for (Detalle detalle : recetaOpt.get().getDetalles()) {
			detalleRepositorio.eliminarDetalle(detalle);
		}
		for (Paso paso : recetaOpt.get().getPasos()) {
			pasoRepositorio.eliminarPaso(paso);
		}
		recetaRepositorio.eliminarReceta(idReceta);
		return "redirect:/recetas";
	}

}
