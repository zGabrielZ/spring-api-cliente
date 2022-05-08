package com.gabrielferreira.br.springapicliente.exception.modelo;

import java.io.Serializable;
import java.time.Instant;

public class ErroPadrao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Instant data;
	private Integer statusErro;
	private String erro;
	private String descricao;
	private String caminho;
	
	public ErroPadrao() {}

	public ErroPadrao(Instant data, Integer statusErro, String erro, String descricao, String caminho) {
		this.data = data;
		this.statusErro = statusErro;
		this.erro = erro;
		this.descricao = descricao;
		this.caminho = caminho;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public Integer getStatusErro() {
		return statusErro;
	}

	public void setStatusErro(Integer statusErro) {
		this.statusErro = statusErro;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
	
	
	

}
