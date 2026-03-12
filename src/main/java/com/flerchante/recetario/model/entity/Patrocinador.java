package com.flerchante.recetario.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
// @ToString(exclude = "peticionIA")
@ToString

@Entity
@Table(name = "PATROCINADOR")
public class Patrocinador {


	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPatrocinador;

	@Getter
	@Setter
	@Column(name = "NOMBRE", nullable = false, length = 100)
	private String nombre;


	@Getter
	@Setter
	@Column(name = "ENLACE", nullable = true, length = 100)
	private String enlace;

	@Getter
	@Setter
	@OneToMany(mappedBy="patrocinador")
	private List<Ingrediente> ingredientes;

}
