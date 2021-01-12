package com.compasso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.entity.Cidade;
import com.compasso.service.CidadeService;

@RestController
@RequestMapping(value = "cidades")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
		cidade = service.save(cidade);
		return ResponseEntity.ok().body(cidade);	
	}
	
	@RequestMapping(value = "/{nome}", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByNome(@PathVariable(value = "nome") String nome) {
		return ResponseEntity.ok().body(service.findByNome(nome));
	}
	
	@RequestMapping(value = "/{estado}/estado", method = RequestMethod.GET)
	public ResponseEntity<List<Cidade>> findByEstado(@PathVariable(value = "estado") String estado) {
		return ResponseEntity.ok().body(service.findByEstado(estado));
	}
}
