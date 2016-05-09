package br.com.treinamento.dojo.service;

import java.util.List;

import br.com.treinamento.dojo.model.Pessoa;

public interface PessoaService {
	public List<Pessoa> getAll();
	public Pessoa get(String cpf);
}
