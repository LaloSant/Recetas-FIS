package com.ejbs.recetario.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor

@Entity
@Table(name = "ROL")
public class Rol {

    public Rol() {
        this.idRol = "USER";
    }

    @Getter
    @Setter
    @Id
    private String idRol;

    @Getter
    @Setter
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(name = "DESCRIPCION", nullable = false)
    private String descripcion;

    @Getter
    @Setter
    @OneToMany(mappedBy = "rol")
    private List<Usuario> usuario;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rol{");
        sb.append("idRol=").append(idRol);
        sb.append(", nombre=").append(nombre);
        sb.append(", descripcion=").append(descripcion);
        sb.append(", usuario=").append(usuario);
        sb.append('}');
        return sb.toString();
    }

}
