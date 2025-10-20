package com.ejbs.recetario.model.entity;

import java.sql.Blob;
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
    @Column(name = "IMAGEN", nullable = true)
    private Blob imagen;

    @Getter
    @Setter
    @Column(name = "PRECIO_UNITARIO", nullable = true)
    private Long precioUnitario;

    @Getter
    @Setter
    @OneToMany(mappedBy = "idIngrediente")
    private List<RecetaIngrediente> recetasIngredientes;

}
