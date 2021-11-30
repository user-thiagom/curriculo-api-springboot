package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.exceptions.ObjectNotFoundException;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.model.Experiencia;
import com.unicap.sin.curriculoapi.repository.ExperienciaRepository;

@Service
public class ExperienciaService {
	
	@Autowired
	ExperienciaRepository repository;
	
	@Autowired
	CurriculoService curriculoService;

	public Experiencia findById(Integer id) {
		Optional<Experiencia> obj = repository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado " + "id: " + id));
	}

	public List<Experiencia> findAll() {
		return repository.findAll();
	}

	public List<Experiencia> findAllByCurriculo(Integer id_curriculo) {
		curriculoService.findById(id_curriculo);
		return repository.findAllByCurriculo(id_curriculo);
	}

	public Experiencia update(Integer id, Experiencia obj) {
		Experiencia newObj = findById(id);
		updateData(newObj, obj);
		return repository.save(newObj);
	}

	private void updateData(Experiencia newObj, Experiencia obj) {
		newObj.setAnoFim(newObj.getAnoFim().equals(obj.getAnoFim()) ? newObj.getAnoFim() : obj.getAnoFim());
		newObj.setAnoComeco(newObj.getAnoComeco().equals(obj.getAnoComeco()) ? newObj.getAnoComeco() : obj.getAnoComeco());
		newObj.setCargo(newObj.getCargo().equals(obj.getCargo()) ? newObj.getCargo() : obj.getCargo());
		newObj.setNomeDaEmpresa(newObj.getNomeDaEmpresa().equals(obj.getNomeDaEmpresa()) ? newObj.getNomeDaEmpresa() : obj.getNomeDaEmpresa());
	}

	public Experiencia create(Integer id_cur, Experiencia obj) {
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
