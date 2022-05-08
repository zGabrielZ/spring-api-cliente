package com.gabrielferreira.br.springapicliente.modelo.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.gabrielferreira.br.springapicliente.modelo.Cliente;

public class ClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String cpf;
	private Double renda;
	private Instant dataNascimento; 
	private Integer crianca;
	
	public ClienteDTO() {}
	
	public ClienteDTO(Cliente cliente) {
		id = cliente.getId();
		nome = cliente.getNome();
		cpf = cliente.getCpf();
		renda = cliente.getRenda();
		dataNascimento = cliente.getDataNascimento();
		crianca = cliente.getCrianca();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getRenda() {
		return renda;
	}

	public void setRenda(Double renda) {
		this.renda = renda;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getCrianca() {
		return crianca;
	}

	public void setCrianca(Integer crianca) {
		this.crianca = crianca;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", renda=" + renda + ", dataNascimento="
				+ dataNascimento + ", crianca=" + crianca + "]";
	}
	
	

}
