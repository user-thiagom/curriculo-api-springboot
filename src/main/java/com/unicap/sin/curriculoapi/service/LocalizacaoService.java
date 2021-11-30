package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.DataIntegratyViolationException;
import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Localizacao;
import com.unicap.sin.curriculoapi.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
	@Autowired
	LocalizacaoRepository repository;

	public Localizacao findById(Integer id) {
		Optional<Localizacao> obj = repository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto com o id: " + id +" não encontrado"));
	}

	public List<Localizacao> findAll() {
		return repository.findAll();
	}

	public Localizacao create(Localizacao obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Localizacao update(Integer id, Localizacao obj) {
		Localizacao newObj = findById(id);
		newObj.setCidade(obj.getCidade());
		newObj.setPais(obj.getPais());
		newObj.setUf(obj.getUf());
		return repository.save(newObj);
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
