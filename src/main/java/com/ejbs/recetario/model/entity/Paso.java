package com.ejbs.recetario.model.entity;

import java.sql.Blob;

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

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PASOS")
public class Paso {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaso;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_RECETA")
    private Receta receta;

    @Getter
    @Setter
    @Column(name = "INDICE_PASO", nullable = false)
    private Long indicePaso;

    @Getter
    @Setter
    @Column(name = "NOTAS", nullable = false, length = 200)
    private String notas;

    @Getter
    @Setter
    @Column(name = "IMAGEN", nullable = true)
    private Blob imagen;

    @Getter
    @Setter
	@ManyToOne
	@JoinColumn(name = "ID_PET_IA")
    private PeticionIA peticionIA;
}
