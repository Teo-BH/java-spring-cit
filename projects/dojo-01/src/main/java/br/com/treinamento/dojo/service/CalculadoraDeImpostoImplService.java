package br.com.treinamento.dojo.service;

import org.springframework.stereotype.Component;

import br.com.treinamento.dojo.model.Imposto;
import br.com.treinamento.dojo.model.Produto;

@Component
public class CalculadoraDeImpostoImplService implements CalculadoraDeImpostoService {

	@Override
	public double executaCalculo(Produto produto, Imposto imposto) {
		return imposto.calcula(produto);
}

}
