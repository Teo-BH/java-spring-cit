package br.com.treinamento.dojo.model;

import org.springframework.stereotype.Component;

@Component
public class ImpostoICMS implements Imposto {

	@Override
	public double calcula(Produto produto) {
		return produto.getValor() * 18 / 100;
	}

}
