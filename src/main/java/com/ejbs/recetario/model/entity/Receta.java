package com.ejbs.recetario.model.entity;

import java.sql.Blob;
import java.util.List;

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
@Table(name = "RECETAS")
public class Receta {

	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReceta;

	@Getter
	@Setter
	@Column(name = "NOMBRE", length = 50, nullable = false)
	private String nombre;

	@Getter
	@Setter
	@Column(name = "IMAGEN")
	private Blob imagen;

	@Getter
	@Setter
	@Column(name = "VISITAS_TOTALES")
	private Long visitasTotales;

	@Getter
	@Setter
	@Column(name = "VISITAS_SEMANALES")
	private Long visitasSemanales;

	@Getter
	@Setter
	@Column(name = "CALIFICACIONES_TOTALES")
	private Long calificacionesTotales;

	@Getter
	@Setter
	@Column(name = "CALIFICACION", columnDefinition = "NUMBER CHECK (CALIFICACION >= 0 AND CALIFICACION <= 5)")
	private Double calificacion;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "ID_USUARIO")
	private Usuario usuario;

	@Getter
	@Setter
	@OneToMany(mappedBy = "receta")
	private List<Detalle> detalles;

	@Getter
	@Setter
	@OneToMany(mappedBy = "receta")
	private List<Paso> pasos;

	public double calcularCosto(){
		double costo = 0d;
		for (Detalle detalle : detalles) {
			costo += detalle.getCosto();
		}
		return costo;
	}

	public Double actualizarCalificacion(int calificacionNueva) {
		double mult = calificacion * calificacionesTotales;
		mult += calificacionNueva;
		calificacionesTotales++;
		calificacion = roundAvoid(mult / calificacionesTotales, 2);
		return calificacion;
	}

	public static double roundAvoid(double value, int places) {
		double scale = Math.pow(10, places);
		return Math.round(value * scale) / scale;
	}
}
