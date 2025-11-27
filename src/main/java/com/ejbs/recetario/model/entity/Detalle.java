package com.ejbs.recetario.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "DETALLES")
public class Detalle {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalle;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ID_RECETA")
	private Receta receta;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ID_INGREDIENTE")
	private Ingrediente ingrediente;

	@Getter
	@Setter
	@Column(name = "CANTIDAD", nullable = false)
	private Double cantidad;

	@Getter
	@Setter
	@Column(name = "COSTO", nullable = false)
	private Double costo;

	public Double calcularCosto(){
		costo = ingrediente.getCostoUnitario() * cantidad;
		return costo;
	}

}
