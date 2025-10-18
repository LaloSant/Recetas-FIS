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
@Table(name = "RECETAS")
public class Receta {

    @Getter
    @Setter
    @Id
    @Column(name = "ID_RECETA", nullable = false)
    private Long idReceta;

/*     @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false)
    private Usuario usuario; */

    @Getter
    @Setter
    @Column(name = "nombre", length = 40, nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(name = "PROCEDIMIENTO", length = 200, nullable = false)
    private String procedimiento;

    @Getter
    @Setter
    @Column(name = "INGREDIENTES", length = 200, nullable = false)
    private String ingredientes;

    @Override
    public String toString() {
        return "Receta [idReceta=" + idReceta + ", usuario=" + ", nombre=" + nombre + ", procedimiento="
                + procedimiento + ", ingredientes=" + ingredientes + "]";
    }

    
}
