package com.ejbs.recetario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejbs.recetario.model.entity.Detalle;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
	public List<Detalle> findByReceta_IdReceta(Long idReceta);
}
