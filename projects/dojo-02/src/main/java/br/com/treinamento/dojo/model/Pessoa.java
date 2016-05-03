package br.com.treinamento.dojo.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class Pessoa {

	public String cpf;
	public String nome;
	public List<Cartao> cartoes;
	public List<Endereco> enderecos;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cartao> getCartoes() {
		return cartoes;
	}

	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public void addEndereco(Endereco endereco){
		enderecos.add(endereco);
	}

}
