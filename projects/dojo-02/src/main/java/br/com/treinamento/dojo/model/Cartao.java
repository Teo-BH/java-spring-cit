package br.com.treinamento.dojo.model;

import org.springframework.stereotype.Repository;

@Repository
public class Cartao {

	public String validade;
	public String nro;
	public double limite;

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getNro() {
		return nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}
	
	

}
