package com.flerchante.sabor.model.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.flerchante.sabor.model.entity.Detalle;
import com.flerchante.sabor.model.entity.Paso;
import com.flerchante.sabor.model.entity.Receta;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class RecetaCompDTO {
	@Getter
	@Setter
	private Receta receta;

	@Getter
	@Setter
	private List<Paso> pasos;

	@Getter
	@Setter
	private List<Detalle> detalles;

	@Getter
	@Setter
	private MultipartFile imagen;

	@Getter
	@Setter
	private List<PasoDTO> pasoDTOs;

}
