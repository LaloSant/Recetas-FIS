package com.flerchante.recetario.model.entity;

import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "INGREDIENTES")
public class Ingrediente {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIngrediente;

	@Getter
	@Setter
	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@Getter
	@Setter
	@Column(name = "COSTO_UNITARIO")
	private Double costoUnitario;

	@Getter
	@Setter
	@Column(name = "IMAGEN")
	private Blob imagen;

	@Getter
	@Setter
	@Column(name = "MAGNITUD", length = 200, nullable = false)
	private String magnitud;

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nombre=" + nombre + "]";
	}
}
