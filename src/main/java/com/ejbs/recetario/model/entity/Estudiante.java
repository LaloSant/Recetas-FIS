package com.ejbs.recetario.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ESTUDIANTE")
public class Estudiante {

    @Getter
    @Setter
    @Id
    @Column(name = "numControl", length = 9)
    private String numControl;

    @Getter
    @Setter
    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(name = "apPat", length = 50, nullable = false)
    private String apPat;

    @Getter
    @Setter
    @Column(name = "apMat", length = 50, nullable = false)
    private String apMat;

    @Getter
    @Setter
    @Column(name = "correo", length = 50, nullable = false)
    private String correo;

    @Getter
    @Setter
    @Column(name = "creditos")
    private Integer creditos;

}
