package br.com.treinamento.dojo.model;

import org.springframework.stereotype.Component;

@Component
public class Desconto10 implements Desconto {

	@Override
	public double calcula(Carrinho carrinho) {
		if (carrinho.getValor() > 1000) {
			return carrinho.getValor() * 10 / 100;
		} else {
			return 0;
		}
	}

	@Override
	public void setProximo(Desconto desconto) {
		// TODO Auto-generated method stub	
	}

}
