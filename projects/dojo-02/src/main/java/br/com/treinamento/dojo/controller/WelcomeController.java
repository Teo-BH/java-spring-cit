package br.com.treinamento.dojo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public ResponseEntity<String> helloWorld() {

		return new ResponseEntity<String>("hello world", HttpStatus.OK);
	}

}
