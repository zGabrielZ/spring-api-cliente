package com.gabrielferreira.br.springapicliente.modelo;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome",nullable = false)
	private String nome;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "renda", nullable = false)
	private Double renda;
	
	@Column(name = "data_nascimento", nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant dataNascimento; 
	
	@Column(name = "crianca", nullable = false)
	private Integer crianca;

	@Column(name = "criado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant criado;

	@Column(name = "atualizado", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant atualizado;
	
	public Cliente() {}

	public Cliente(Long id, String nome, String cpf, Double renda, Instant dataNascimento, Integer crianca) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.renda = renda;
		this.dataNascimento = dataNascimento;
		this.crianca = crianca;
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

	@PrePersist
	private void preInsercao(){
		criado = Instant.now();
	}

	@PreUpdate
	private void preUpdate(){
		atualizado = Instant.now();
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
		Cliente other = (Cliente) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", renda=" + renda + ", dataNascimento="
				+ dataNascimento + ", crianca=" + crianca + "]";
	}
	
	
	
	

}
