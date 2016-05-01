package br.com.treinamento.dojo.model;

import java.util.List;

public class Carrinho {

	private double valor;
	private List<Produto> produtos;

	public Carrinho(double valor, List<Produto> produtos){
		this.valor = valor;
		this.produtos = produtos;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
