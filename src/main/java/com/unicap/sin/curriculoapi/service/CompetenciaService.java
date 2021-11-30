package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Competencia;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.repository.CompetenciaRepository;

@Service
public class CompetenciaService {
	
	@Autowired
	CompetenciaRepository repository;
	
	@Autowired
	CurriculoService curriculoService;
	
	public Competencia findById(Integer id) {
		Optional<Competencia> obj = repository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado " + "id: " + id));
	}

	public List<Competencia> findAll() {
		return repository.findAll();
	}

	public List<Competencia> findAllByCurriculo(Integer id_curriculo) {
		curriculoService.findById(id_curriculo);
		return repository.findAllByCurriculo(id_curriculo);
	}

	public Competencia update(Integer id, Competencia obj) {
		Competencia newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Competencia newObj, Competencia obj) {
		newObj.setCompetencia(newObj.getCompetencia().equals(obj.getCompetencia()) ? newObj.getCompetencia() : obj.getCompetencia());
		newObj.setDescricao(newObj.getDescricao().equals(obj.getDescricao()) ? newObj.getDescricao() : obj.getDescricao());
	}

	public Competencia create(Integer id_cur, Competencia obj) {
		obj.setId(null);
		Curriculo cur = curriculoService.findById(id_cur);
		obj.setCurriculo(cur);
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
