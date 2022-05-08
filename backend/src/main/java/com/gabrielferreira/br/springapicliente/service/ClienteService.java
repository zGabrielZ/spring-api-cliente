package com.gabrielferreira.br.springapicliente.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabrielferreira.br.springapicliente.exception.EntidadeNaoEncontradaException;
import com.gabrielferreira.br.springapicliente.modelo.Cliente;
import com.gabrielferreira.br.springapicliente.modelo.dto.ClienteDTO;
import com.gabrielferreira.br.springapicliente.repositorio.ClienteRepositorio;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepositorio;

	@Transactional
	public ClienteDTO inserirCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		dtoParaEntidade(clienteDTO, cliente);
		cliente = clienteRepositorio.save(cliente);
		return new ClienteDTO(cliente);
	}
	
	@Transactional
	public ClienteDTO atualizarCliente(Long id,ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteRepositorio.getOne(id);
			dtoParaEntidade(clienteDTO, cliente);
			cliente = clienteRepositorio.save(cliente);
			return new ClienteDTO(cliente);
		} catch (EntityNotFoundException e) {
			throw new EntidadeNaoEncontradaException("Cliente não encontrado. ID : " + id);
		}
	}
	
	public Page<ClienteDTO> listagensClientes(PageRequest pageRequest){
		Page<Cliente> clientes = clienteRepositorio.findAll(pageRequest);
		Page<ClienteDTO> clienteDTOs = clientes.map(c -> new ClienteDTO(c));
		return clienteDTOs;
	}
	
	public ClienteDTO buscarPorId(Long id) {
		Optional<Cliente> optionalCliente = clienteRepositorio.findById(id);
		if(optionalCliente.isEmpty()) {
			throw new EntidadeNaoEncontradaException("Cliente não encontrado. ID : " + id);
		}
		ClienteDTO clienteDTO = new ClienteDTO(optionalCliente.get());
		return clienteDTO;
	}
	
	@Transactional
	public void deletarCliente(Long id) {
		try {
			Cliente cliente = clienteRepositorio.getOne(id);
			clienteRepositorio.deleteById(cliente.getId());
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException("Cliente não encontrado. ID : " + id);
		}
	}
	
	private void dtoParaEntidade(ClienteDTO clienteDTO, Cliente cliente) {
		cliente.setNome(clienteDTO.getNome());
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setRenda(clienteDTO.getRenda());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());
		cliente.setCrianca(clienteDTO.getCrianca());
	}
}
