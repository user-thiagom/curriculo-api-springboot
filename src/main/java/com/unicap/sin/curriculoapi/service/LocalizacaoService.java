package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.DataIntegratyViolationException;
import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.model.Localizacao;
import com.unicap.sin.curriculoapi.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
	@Autowired
	LocalizacaoRepository repository;
	
	@Autowired
	CurriculoService curriculoService;

	public Localizacao findById(Integer id) {
		Optional<Localizacao> obj = repository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto com o id: " + id +" não encontrado"));
	}

	public List<Localizacao> findAll() {
		return repository.findAll();
	}

	public Localizacao create(Integer id_cur ,Localizacao obj) {
		obj.setId(null);
		Curriculo curriculo = curriculoService.findById(id_cur);
		obj.setCurriculo(curriculo);
		return repository.save(obj);
	}

	public Localizacao update(Integer id, Localizacao obj) {
		Localizacao newObj = findById(id);
		updateData(newObj,obj);
		return repository.save(newObj);
	}

	private void updateData(Localizacao newObj, Localizacao obj) {
		newObj.setCidade(newObj.getCidade().equals(obj.getCidade()) ? newObj.getCidade() : obj.getCidade());
		newObj.setPais(newObj.getPais().equals(obj.getPais()) ? newObj.getPais() : obj.getPais());
		newObj.setUf(newObj.getUf().equals(obj.getUf()) ? newObj.getUf() : obj.getUf());
	}

	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegratyViolationException("Objeto não pode ser deletado");
		}
	}
}
