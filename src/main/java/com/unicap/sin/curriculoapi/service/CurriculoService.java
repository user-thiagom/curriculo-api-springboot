package com.unicap.sin.curriculoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.unicap.sin.curriculoapi.dto.CurriculoDTO;
import com.unicap.sin.curriculoapi.exceptions.DataIntegratyViolationException;
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
	
	public List<Curriculo> findAll(){
		return repository.findAll();
	}
	
	public Curriculo create(Curriculo obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Curriculo update(Integer id, CurriculoDTO objDTO) {
		Curriculo obj = findById(id);
		updateData(obj,objDTO);
		return repository.save(obj);
	}

	private void updateData(Curriculo obj, CurriculoDTO objDTO) {
		obj.setEmail(obj.getEmail().equals(objDTO.getEmail()) ? obj.getEmail() : objDTO.getEmail());
		obj.setGithub(obj.getGithub().equals(objDTO.getGithub()) ? obj.getGithub() : objDTO.getGithub());
		obj.setLinkedin(obj.getLinkedin().equals(objDTO.getLinkedin()) ? obj.getLinkedin() : objDTO.getLinkedin());
		obj.setNome(obj.getNome().equals(objDTO.getNome()) ? obj.getNome() : objDTO.getNome());
		obj.setProfissao(obj.getProfissao().equals(objDTO.getProfissao()) ? obj.getProfissao() : objDTO.getProfissao());
		obj.setResumo(obj.getResumo().equals(objDTO.getResumo()) ? obj.getResumo() : objDTO.getResumo());
		obj.setTelefone(obj.getTelefone().equals(objDTO.getTelefone()) ? obj.getTelefone() : objDTO.getTelefone());
		
	}
	
	public void delete(Integer id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegratyViolationException("Objeto não pode ser deletado. possui livros associados");
		}
		
	}

}
