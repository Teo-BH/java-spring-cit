package br.com.treinamento.dojo.model;

import org.springframework.stereotype.Component;

@Component
public class Desconto5 implements Desconto {

	@Override
	public double calcula(Carrinho carrinho) {
		if (carrinho.getProdutos().size() > 2) {
			return carrinho.getValor() * 5 / 100;
		} else {
			return 0;
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		// TODO Auto-generated method stub
		
	}

}
