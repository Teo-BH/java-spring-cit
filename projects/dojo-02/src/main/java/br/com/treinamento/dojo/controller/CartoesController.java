package br.com.treinamento.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.dojo.dto.ResponseProtocol;

@RestController
@RequestMapping(value = "/v1")
public class CartoesController {
	
	@RequestMapping(value = "/cartoes", method = RequestMethod.GET)
	public ResponseEntity<ResponseProtocol> cartoes(@RequestParam String cpf) {
		ResponseProtocol result = new ResponseProtocol();

		
//		protocol.getData();
//		protocol.setData(nil);
		// TODO: Responder a uma lista de cartões
		return new ResponseEntity<ResponseProtocol>(result, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cartoes/{id_cartao}/faturas", method = RequestMethod.GET)
	public ResponseEntity<String> cartao(@RequestHeader("CPF") String cpf, @PathVariable String id_cartao) {
		// TODO: Responder um cartão
		return new ResponseEntity<String>("cartão", HttpStatus.OK);
	}

	@RequestMapping(value = "/cartoes", method = RequestMethod.POST)
	public ResponseEntity<String> cartoesPost(@RequestHeader("CPF") String cpf, @RequestBody String body) {
		
		
		// TODO: Retornar mensagem
		return new ResponseEntity<String>("mensagem", HttpStatus.OK);
	}
}
