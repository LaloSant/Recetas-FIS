package com.flerchante.recetario.model.entity;

import java.sql.Blob;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@JsonIgnore
	private Blob imagen;

	@Getter
	@Setter
	@Column(name = "MAGNITUD", length = 200, nullable = false)
	private String magnitud;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ID_PATROCINADOR")
	@JsonBackReference
	private Patrocinador patrocinador;

	@Getter
	@Setter
	@OneToMany(mappedBy = "ingrediente")
	@JsonIgnore
	private List<Detalle> detalles;

	@Override
	public String toString() {
		return "Ingrediente [idIngrediente=" + idIngrediente + ", nombre=" + nombre + "]";
	}

	public String calcularVecesUsado() {
		int aparicion = 0;
		String formateado = "0";
		for (Detalle detalle : detalles) {
			if(Objects.equals(detalle.getIngrediente().getIdIngrediente(), idIngrediente)){
			aparicion += 1;
			formateado = String.valueOf(aparicion);
			}
		}
		return formateado;
	}

}
