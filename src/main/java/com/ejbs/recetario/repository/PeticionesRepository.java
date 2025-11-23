package com.ejbs.recetario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ejbs.recetario.model.entity.PeticionIA;

@Repository
public interface PeticionesRepository extends JpaRepository<PeticionIA, Long> {
	@Modifying
	@Query("UPDATE PeticionIA p SET p.estatus = :estatus WHERE p.idPeticionIA = :idPeticion")
	public void actualizarEstatus(@Param("idPeticion") Long idPeticion, @Param("estatus") String estatus);
}
