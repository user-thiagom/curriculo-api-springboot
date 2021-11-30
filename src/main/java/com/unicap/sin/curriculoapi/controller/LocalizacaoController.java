package com.unicap.sin.curriculoapi.controller;

import java.net.URI;
import java.util.List;

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

import com.unicap.sin.curriculoapi.model.Localizacao;
import com.unicap.sin.curriculoapi.service.LocalizacaoService;

@RestController
@RequestMapping(value = "localizacao")
public class LocalizacaoController {
	
	@Autowired
	LocalizacaoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Localizacao> findById(@PathVariable Integer id){
		Localizacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Localizacao>> findAll(){
		List<Localizacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping
	public ResponseEntity<Localizacao> create(@RequestBody Localizacao obj){
		obj = service.create(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Localizacao> update(@PathVariable Integer id, @RequestBody Localizacao obj){
		Localizacao newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
