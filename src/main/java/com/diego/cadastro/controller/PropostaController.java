package com.diego.cadastro.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.diego.cadastro.model.Proposta;
import com.diego.cadastro.service.PropostaService;

/**
 * Controller de propostas
 * @author Diego Rangel - diegorangeljpa@gmail.com
 */
//@RequestMapping ("/admin")
@RestController
@RequestMapping ("/")
public class PropostaController {

	@Autowired
	PropostaService PropostaService;

	//End point
	@RequestMapping(method = RequestMethod.POST, value="/Propostas",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proposta> cadastrarProposta(@RequestBody Proposta Proposta) {
		
		if (Proposta.getStatusProposta() == null) {
			Proposta.setStatusProposta("pendente");
		}
		if (Proposta.getStatusDocumentos() == null) {
			Proposta.setStatusDocumentos("pendente");
		}
		if (Proposta.getStatusSPC() == null) {
			Proposta.setStatusSPC("pendente");
		}
		Proposta PropostaCadastrado = PropostaService.cadastrar(Proposta);
		return new ResponseEntity<Proposta>(PropostaCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Propostas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Proposta>> buscarTodosPropostas() {
		Collection< Proposta> PropostasBuscados= PropostaService.buscarTodos();
		return new ResponseEntity<>(PropostasBuscados, HttpStatus.OK);
	}

	/*
	@RequestMapping(method = RequestMethod.GET, value="/CountPropostas",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Collection< long>> retornaQuantidadeDePropostas() {
		Collection <long> quant = PropostaService.retornaQuantidadeDePropostasCadastradas();
		return new ResponseEntity<>(quant, HttpStatus.OK);
	}
	*/
	
	@RequestMapping(method = RequestMethod.DELETE, value="/Propostas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection< Proposta>> excluirProposta(@PathVariable Integer id) {
		Proposta PropostaEncontrado = PropostaService.buscarPorId(id);
		if (PropostaEncontrado == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			PropostaService.excluir(PropostaEncontrado);
			return new ResponseEntity<>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/Propostas/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proposta> buscarPropostaPorId(@PathVariable Integer id) {
		Proposta Proposta = PropostaService.buscarPorId(id);
		if (Proposta == null) {
			//mensagem de nao encontrato
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>( Proposta,HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/Propostas",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Proposta> alterarProposta(@RequestBody Proposta Proposta) {
		Proposta PropostaAlterado = PropostaService.alterar(Proposta);		
		return new ResponseEntity<Proposta>(PropostaAlterado, HttpStatus.OK);
	}
	
	/**
	//End point TESTE
	@RequestMapping(method = RequestMethod.GET, value="/Propostas")
	public void busca() {
		System.out.println("Deu certo");
	}
	*/
	
}
