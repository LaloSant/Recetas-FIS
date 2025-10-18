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
@Table(name = "Rol")
public class Rol {
    
    @Getter
    @Setter
    @Id
    @Column(name = "ID_ROL", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;

    @Getter
    @Setter
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter
    @Setter
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;
}
