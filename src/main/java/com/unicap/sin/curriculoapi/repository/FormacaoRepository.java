package com.unicap.sin.curriculoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unicap.sin.curriculoapi.model.Formacao;

public interface FormacaoRepository extends JpaRepository<Formacao, Integer>{

	@Query("SELECT obj FROM Formacao obj WHERE obj.curriculo.id = :id_curriculo ORDER BY instituicao")
	List<Formacao> findAllByCurriculo(@Param(value = "id_curriculo") Integer id_curriculo);

}
