package br.com.treinamento.dojo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.treinamento.dojo.model.Pessoa;

@Component
public class PessoaImplService implements PessoaService {
	
	@Autowired
	private ArrayList<Pessoa> pessoas;

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@Override
	public List<Pessoa> getAll() {
		return this.getPessoas();
	}

	@Override
	public Pessoa get(String cpf) {
		for (Pessoa item : getPessoas()) {
			if (item.cpf.equals(cpf))
				return item;
		}
		return null;
	}
}
