package com.ejbs.recetario.model.entity;

import java.sql.Blob;
import java.sql.Date;

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
    @Column(name = "FECHA_REGISTRO", nullable = true)
    private Date fechaRegistro;

    @Getter
    @Setter
    @Column(name = "IMAGEN", nullable = true)
    private Blob imagen;

/*     @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario idUsuario;

    @Getter
    @Setter
    @OneToMany(mappedBy = "idReceta")
    private List<RecetaIngrediente> recetasIngredientes;

    @Getter
    @Setter
    @OneToMany(mappedBy = "idReceta")
    private List<Paso> pasos; */

}
