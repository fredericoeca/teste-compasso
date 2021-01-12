package com.compasso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.entity.Cidade;
import com.compasso.repository.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repository;
	
	/***
	 * Cadastrar cidade
	 * 
	 * @param cidade
	 * @return cidade
	 */
	public Cidade save(Cidade cidade) {
		return repository.save(cidade);
	}
	
	/***
	 * Consultar cidade pelo nome
	 * 
	 * @param nome
	 * @return cidades
	 */
	public List<Cidade> findByNome(String nome) {
		return repository.findByNome(nome);
	}

	/***
	 * Consultar cidade pelo estado
	 * 
	 * @param estado
	 * @return cidades
	 */
	public List<Cidade> findByEstado(String estado) {
		return repository.findByEstado(estado);
	} 
}
