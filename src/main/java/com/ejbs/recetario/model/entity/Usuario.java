package com.ejbs.recetario.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "USUARIOS")
public class Usuario {

    @Getter
    @Setter
    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Getter
    @Setter
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(name = "AP_PAT", nullable = false)
    private String apPat;

    @Getter
    @Setter
    @Column(name = "CONTRASENIA", nullable = false)
    private String contrasenia;

    @Getter
    @Setter
    @Column(name = "CORREO", nullable = false)
    private String correo;

    @Getter
    @Setter
    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL, orphanRemoval = true) //mappedBy -> nombre de variable
    private List<Receta> recetas;

}
