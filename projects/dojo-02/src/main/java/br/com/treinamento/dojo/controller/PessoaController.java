package br.com.treinamento.dojo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.treinamento.dojo.dto.ResponseProtocol;
import br.com.treinamento.dojo.model.Pessoa;
import br.com.treinamento.dojo.service.PessoaService;

@RestController
@RequestMapping(value = "/v1")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;

	public PessoaService getPessoaService() {
		return pessoaService;
	}

	public void setPessoaService(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@RequestMapping(value = "/pessoa", method = RequestMethod.GET)
	public ResponseEntity<ResponseProtocol> pessoa(@RequestHeader("CPF") String cpf) {
		Pessoa pessoa = getPessoaService().get(cpf);
		ResponseProtocol response = new ResponseProtocol();
		if (pessoa != null) {
			response.setData(pessoa);
			return new ResponseEntity<ResponseProtocol>(response, HttpStatus.OK);
		} else {
			response.setMensagem("Não existe pessoa com o CPF informado");
			return new ResponseEntity<ResponseProtocol>(response, HttpStatus.NOT_FOUND);
		}
 	}
}
