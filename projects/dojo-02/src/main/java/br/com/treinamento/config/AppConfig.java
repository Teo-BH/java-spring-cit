package br.com.treinamento.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import br.com.treinamento.dojo.model.Cartao;
import br.com.treinamento.dojo.model.Pessoa;
import br.com.treinamento.dojo.service.PessoaImplService;
import br.com.treinamento.dojo.service.PessoaService;

@Configuration
@ComponentScan("br.com.treinamento.dojo")
public class AppConfig {

	@Bean
	@Scope(value = "singleton")
	public Map<String, Object> getDb() {
		return new HashMap<String, Object>();
	}
	
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
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.nome = "John";
		pessoa1.cpf = "01234567890";
		pessoa1.cartoes = new ArrayList<Cartao>();
		pessoa1.cartoes.add(cartao);
		pessoas.add(pessoa1);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.nome = "Marie";
		pessoa2.cpf = "32949557317";
		pessoas.add(pessoa2);
				
		return pessoas;
	}

}
