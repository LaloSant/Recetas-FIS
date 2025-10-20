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

@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "RECETA_INGRED")
public class RecetaIngrediente {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRecetaIngrediente;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_RECETA")
    private Receta idReceta;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_INGREDIENTE")
    private Ingrediente idIngrediente;

    @Getter
    @Setter
    @Column(name = "CANTIDAD", nullable = true)
    private Long cantidad;

    @Getter
    @Setter
    @Column(name = "NOTAS", length = 200, nullable = true)
    private String notas;

    @Getter
    @Setter
    @Column(name = "COSTO", nullable = true)
    private Long costo;
}
