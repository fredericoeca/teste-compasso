package com.compasso.service;

import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.entity.Cliente;
import com.compasso.repository.ClienteRepository;
import com.compasso.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	/***
	 * Consultar cliente pelo Id
	 * 
	 * @param id
	 * @return Cliente
	 */
	public Cliente findById(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado"));
	}
	
	/***
	 * Cadastrar Cliente
	 * 
	 * @param cliente
	 * @return Cliente
	 */
	public Cliente save(Cliente cliente) {
		cliente.setIdade(calcularIdade(cliente.getDataNascimento()));
		return repository.save(cliente);
	}
	
	/***
	 * Alterar o nome do cliente
	 * 
	 * @param id
	 * @param cliente
	 * @return cliente
	 */
	public Cliente updateNome(Integer id, Cliente cliente) {
		Cliente c = findById(id);
		c.setNomeCompleto(cliente.getNomeCompleto());
		return repository.save(c);
	}
	
	/***
	 * Remover cliente
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		Cliente cliente = findById(id);
		repository.delete(cliente);
	}
	
	/***
	 * Consultar cliente pelo nome
	 * 
	 * @param nome
	 * @return Clientes
	 */
	public List<Cliente> findByName(String nome) {
		return repository.findByNomeCompletoContainingIgnoreCase(nome);
	}
	
	/***
	 * Calcular idade do cliente pela data de nascimento
	 * 
	 * @param dataNascimento
	 * @return idade
	 */
	public Integer calcularIdade(Date dataNascimento) {
		Calendar hoje = Calendar.getInstance();
		Calendar nascimento = Calendar.getInstance();
		nascimento.setTime(dataNascimento);
		
		int idade = hoje.get(Calendar.YEAR) - nascimento.get(Calendar.YEAR);
	
		return (hoje.get(Calendar.DAY_OF_YEAR) < nascimento.get(Calendar.DAY_OF_YEAR)) ? idade - 1 : idade;
	}
	
}
