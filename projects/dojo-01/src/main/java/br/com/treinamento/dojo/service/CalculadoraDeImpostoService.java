package br.com.treinamento.dojo.service;

import br.com.treinamento.dojo.model.Imposto;
import br.com.treinamento.dojo.model.Produto;

public interface CalculadoraDeImpostoService {
	
	public double executaCalculo(Produto produto, Imposto imposto);

}