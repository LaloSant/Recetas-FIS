package com.ejbs.recetario.model.dto;

import org.springframework.web.multipart.MultipartFile;

import com.ejbs.recetario.model.entity.Paso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class PasoDTO {
	@Getter
	@Setter
	private Paso paso;

	@Getter
	@Setter
	private MultipartFile imagen;
}
