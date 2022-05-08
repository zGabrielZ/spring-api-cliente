package com.gabrielferreira.br.springapicliente.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gabrielferreira.br.springapicliente.modelo.dto.ClienteDTO;
import com.gabrielferreira.br.springapicliente.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<ClienteDTO> inserirCliente(@RequestBody ClienteDTO clienteDTO){
		clienteDTO = clienteService.inserirCliente(clienteDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteDTO);
	}
	
	@GetMapping
	public ResponseEntity<Page<ClienteDTO>> listagensClientes(
			@RequestParam(required = false, value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(required = false, value = "quantidadePagina", defaultValue = "12") Integer quantidadePagina,
			@RequestParam(required = false, value = "direcao", defaultValue = "ASC") String direcao,
			@RequestParam(required = false, value = "ordenarPor", defaultValue = "nome") String ordenarPor){
		PageRequest pageRequest = PageRequest.of(pagina, quantidadePagina, Direction.valueOf(direcao), ordenarPor);
		Page<ClienteDTO> clienteDTOs = clienteService.listagensClientes(pageRequest);
		return ResponseEntity.ok().body(clienteDTOs);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscarPorIdCliente(@PathVariable Long id){
		ClienteDTO clienteDTO = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(clienteDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
		clienteService.deletarCliente(id);
		return ResponseEntity.noContent().build();
	}
}
