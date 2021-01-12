package com.compasso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.entity.Cliente;
import com.compasso.service.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(service.save(cliente));
	}
	
	@RequestMapping(value = "/{id}/nome", method = RequestMethod.PUT)
	public ResponseEntity<Cliente> updateName(@PathVariable Integer id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok().body(service.updateNome(id, cliente));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
	@RequestMapping(value = "/consulta", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findByName(@RequestParam("nome") String nome) {
		return ResponseEntity.ok().body(service.findByName(nome));
	}
}
