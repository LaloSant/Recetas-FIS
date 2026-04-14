package com.flerchante.recetario.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "paso")
// @ToString

@Entity
@Table(name = "PETICION_IA")
public class PeticionIA {

	public PeticionIA(String descripcion){
		this.descripcion = descripcion;
		this.estatus = "PEN";
	}

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PETICION_IA")
    private Long idPeticionIA;

    @Getter
    @Setter
    @Column(name = "ESTATUS", nullable = false, length = 3)
    private String estatus;

    @Getter
    @Setter
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    private String descripcion;

	@Getter
	@Setter
	@OneToOne(mappedBy="peticionIA")
	private Paso paso;
}
