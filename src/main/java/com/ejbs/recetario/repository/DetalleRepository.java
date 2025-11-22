package com.ejbs.recetario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ejbs.recetario.model.entity.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
	public List<Detalle> findByReceta_IdReceta(Long idReceta);

	@Modifying
	@Query(value = "UPDATE DETALLES SET CANTIDAD = :cantidad, ID_INGREDIENTE = :idIngrediente WHERE ID_DETALLE = :idDetalle", nativeQuery = true)
	void actualizarDetalle(@Param("idDetalle") Long idDetalle, @Param("cantidad") Double cantidad,
			@Param("idIngrediente") Long idIngrediente);
}
