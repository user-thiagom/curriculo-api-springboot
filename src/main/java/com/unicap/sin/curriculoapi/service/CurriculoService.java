package com.unicap.sin.curriculoapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.repository.CurriculoRepository;

@Service
public class CurriculoService {
	
	@Autowired
	CurriculoRepository repository;
	
	public Curriculo findById(Integer id) {
		Optional<Curriculo> obj = repository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado " + "id: " + id));
	}
}
