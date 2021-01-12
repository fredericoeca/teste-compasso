package com.compasso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compasso.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{

	List<Cidade> findByNome(String nome);
		
	List<Cidade> findByEstado(String estado);
	
}
