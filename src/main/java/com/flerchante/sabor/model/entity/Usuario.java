package com.flerchante.sabor.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Getter
    @Setter
    @Column(name = "NOMBRE", nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Getter
    @Setter
    @Column(name = "CONTRASENIA", nullable = false)
    private String contrasenia;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private Rol rol;
	
	@Getter
	@Setter
	@OneToMany(mappedBy = "usuario")
	private List<Receta> recetas;

    /*     @Getter
    @Setter
    @OneToMany(mappedBy = "idUsuario")
    private List<Receta> recetas; */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Usuario{");
        sb.append("idUsuario=").append(idUsuario);
        sb.append(", nombre=").append(nombre);
        sb.append(", contrasenia=").append("[PROTEGIDO]");
        sb.append(", email=").append(email);
        sb.append(", rol=").append(rol.getIdRol());
        sb.append('}');
        return sb.toString();
    }

}
