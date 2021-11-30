package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.model.Formacao;
import com.unicap.sin.curriculoapi.repository.FormacaoRepository;

@Service
public class FormacaoService {
	
	@Autowired
	FormacaoRepository repository;
	
	@Autowired
	CurriculoService curriculoService;

	public Formacao findById(Integer id) {
		Optional<Formacao> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado " + "id: " + id));
	}

	public List<Formacao> findAll() {
		return repository.findAll();
	}

	public List<Formacao> findAllByCurriculo(Integer id_curriculo) {
		curriculoService.findById(id_curriculo);
		return repository.findAllByCurriculo(id_curriculo);
	}

	public Formacao update(Integer id, Formacao obj) {
		Formacao newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Formacao newObj, Formacao obj) {
		newObj.setAnoFim(newObj.getAnoFim().equals(obj.getAnoFim()) ? newObj.getAnoFim() : obj.getAnoFim());
		newObj.setAnoInicio(newObj.getAnoInicio().equals(obj.getAnoInicio()) ? newObj.getAnoInicio() : obj.getAnoInicio());
		newObj.setCurso(newObj.getCurso().equals(obj.getCurso()) ? newObj.getCurso() : obj.getCurso());
		newObj.setInstituicao(newObj.getInstituicao().equals(obj.getInstituicao()) ? newObj.getInstituicao() : obj.getInstituicao());
		
	}

	public Formacao create(Integer id_cur, Formacao obj) {
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
