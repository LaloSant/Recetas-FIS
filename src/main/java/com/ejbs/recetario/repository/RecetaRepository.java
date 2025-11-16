package com.ejbs.recetario.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ejbs.recetario.model.entity.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

	public List<Receta> findAllByOrderByVisitasSemanalesDesc();

	public List<Receta> findAllByOrderByVisitasTotalesDesc();
}
