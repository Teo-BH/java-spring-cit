package br.com.treinamento.dojo.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.treinamento.dojo.model.Cartao;
import br.com.treinamento.dojo.model.Endereco;
import br.com.treinamento.dojo.model.Pessoa;
import br.com.treinamento.dojo.service.PessoaImplService;
import br.com.treinamento.dojo.service.PessoaService;

@Configuration
@ComponentScan("br.com.treinamento.dojo")
public class TestConfig {
	
	@Bean(name = "pessoaService")
	public PessoaService pessoaService() {
		return new PessoaImplService();
	}

	@Bean(name = "pessoa")
	public Pessoa pessoa() {
		return new Pessoa();
	}

	@Bean(name = "pessoas")
	public ArrayList<Pessoa> pessoas() {
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Cartao cartao = new Cartao();
		cartao.nro = "1234";
		cartao.limite = 1000;
		cartao.validade = "12/21";
		
		Endereco bh = new Endereco();
		bh.setRua("Av Contorno, 1234");
		bh.setCidade("Belo Horizonte");
		bh.setEstado("MG");
		bh.setCep("30123123");
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = "John";
		pessoa1.cpf = "01234567890";
		pessoa1.cartoes = new ArrayList<Cartao>();
		pessoa1.cartoes.add(cartao);
		pessoa1.enderecos = new ArrayList<Endereco>();
		pessoa1.enderecos.add(bh);
		pessoas.add(pessoa1);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.nome = "Marie";
		pessoa2.cpf = "32949557317";
		pessoas.add(pessoa2);
				
		return pessoas;
	}

}
