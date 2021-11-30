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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unicap.sin.curriculoapi.model.Formacao;
import com.unicap.sin.curriculoapi.service.FormacaoService;

@RestController
@RequestMapping(value = "/formacao")
public class FormacaoController {
	
	@Autowired
	FormacaoService service; 
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Formacao> findById(@PathVariable Integer id){
		Formacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Formacao>> findAll(){
		List<Formacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/")
	public ResponseEntity<List<Formacao>> findAllByCurriculo(@RequestParam(value = "curriculo", defaultValue = "0")Integer id_curriculo){
		List<Formacao> list = service.findAllByCurriculo(id_curriculo);
		return ResponseEntity.ok().body(list);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Formacao> update(@PathVariable Integer id, @RequestBody Formacao obj){
		Formacao newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PostMapping
	public ResponseEntity<Formacao> create(@RequestParam(value = "curriculo", defaultValue = "0") Integer id_cur, @RequestBody Formacao obj){
		Formacao newObj = service.create(id_cur,obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/formacao/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
