package com.ejbs.recetario.model.entity;

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

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PETICION_IA")
public class PeticionIA {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PETICION_IA")
    private Long idPeticionIA;

    @Getter
    @Setter
    @Column(name = "ESTATUS", nullable = false, length = 3)
    private String estatus;

    @Getter
    @Setter
    @Column(name = "DESCRCRIPCION", nullable = false, length = 50)
    private String descripcion;

	@Getter
	@Setter
	@OneToMany(mappedBy="peticionIA")
	private List<Paso> pasos;
}
