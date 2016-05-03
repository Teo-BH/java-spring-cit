package br.com.treinamento.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1")
public class PessoaController {

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public ResponseEntity<String> cartoes(@RequestHeader("CPF") String cpf) {
		// TODO: Responder a uma lista de pessoas
		
		
		return new ResponseEntity<String>("pessoas", HttpStatus.OK);
	}
}
