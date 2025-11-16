package com.ejbs.recetario.controller;

import java.sql.Blob;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ejbs.recetario.service.Receta.RecetaServiceImpl;

@Controller
public class ImagenController {

	@Autowired
	RecetaServiceImpl recetaService;

	@GetMapping("/recetas/imagen/{id}")
	@ResponseBody
	public ResponseEntity<byte[]> obtenerImagen(@PathVariable("id") Long recetaId) {
		Blob img = recetaService.obtenerRecetaPorID(recetaId).get().getImagen();
		byte[] bytes = null;
		try {
			bytes = img.getBytes(1, (int) img.length());
		} catch (SQLException ex) {

		}
		String mimeType = "image/jpeg";
		if (bytes == null || bytes.length == 0) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity
				.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.body(bytes);
	}

}
