package com.unicap.sin.curriculoapi.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unicap.sin.curriculoapi.dto.CurriculoDTO;
import com.unicap.sin.curriculoapi.model.Curriculo;
import com.unicap.sin.curriculoapi.service.CurriculoService;

@RestController
@RequestMapping(value = "/curriculo")
public class CurriculoController {

	@Autowired
	CurriculoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Curriculo> findById(@PathVariable Integer id){
		Curriculo obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<CurriculoDTO>> findAll(){
		List<Curriculo> list = service.findAll();
		List<CurriculoDTO> listDTO = list.stream().map(obj -> new CurriculoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@PostMapping
	public ResponseEntity<Integer> create(@RequestBody Curriculo obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj.getId());
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CurriculoDTO> update(@PathVariable Integer id, @RequestBody CurriculoDTO objDTO){
		Curriculo newObjt = service.update(id,objDTO);
		return ResponseEntity.ok().body(new CurriculoDTO(newObjt));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
