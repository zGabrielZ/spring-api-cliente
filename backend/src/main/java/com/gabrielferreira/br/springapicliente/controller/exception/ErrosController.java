package com.gabrielferreira.br.springapicliente.controller.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielferreira.br.springapicliente.exception.EntidadeNaoEncontradaException;
import com.gabrielferreira.br.springapicliente.exception.modelo.ErroPadrao;

@ControllerAdvice
public class ErrosController {

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(EntidadeNaoEncontradaException e, HttpServletRequest httpServletRequest){
		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(),httpStatus.value(),"Não encontrado.", e.getMessage(),httpServletRequest.getRequestURI());
		return ResponseEntity.status(httpStatus).body(erroPadrao);
	}
}
