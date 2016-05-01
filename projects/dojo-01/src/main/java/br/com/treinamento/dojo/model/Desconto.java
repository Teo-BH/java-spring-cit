package br.com.treinamento.dojo.model;

public interface Desconto {
	
	public double calcula(Carrinho carrinho);
	public void setProximo(Desconto desconto);
}
