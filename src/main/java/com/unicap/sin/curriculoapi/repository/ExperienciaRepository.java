package com.unicap.sin.curriculoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicap.sin.curriculoapi.model.Experiencia;

public interface ExperienciaRepository extends JpaRepository<Experiencia, Integer>{

	@Query("SELECT obj FROM Experiencia obj WHERE obj.curriculo.id = :id_curriculo ORDER BY id")
	List<Experiencia> findAllByCurriculo(@Param(value = "id_curriculo") Integer id_curriculo);

}
