package com.unicap.sin.curriculoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicap.sin.curriculoapi.model.Competencia;

public interface CompetenciaRepository extends JpaRepository<Competencia, Integer>{

	@Query("SELECT obj FROM Competencia obj WHERE obj.curriculo.id = :id_curriculo ORDER BY id")
	List<Competencia> findAllByCurriculo(@Param(value = "id_curriculo") Integer id_curriculo);

}
