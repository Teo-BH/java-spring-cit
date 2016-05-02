package br.com.treinamento.dojo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinamento.dojo.model.Carrinho;
import br.com.treinamento.dojo.model.Desconto;

@Component
public class CalculadoraDeDescontosImpl implements CalculadoraDeDescontos {
	@Autowired
	private List<Desconto> descontos;
	
	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

	@Override
	public double calcula(Carrinho carrinho) {
		for (Desconto desconto : descontos) {
			double value = desconto.calcula(carrinho);
			if (value > 0) {
				return value;
			}
		}

		return 0;
	}
}
