package br.com.treinamento.dojo.model;

import org.springframework.stereotype.Component;

@Component
public class Produto {
	
	private String nome;
	private double valor;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}


}
