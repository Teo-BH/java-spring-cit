package br.com.treinamento.dojo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.treinamento.dojo.config.TesteConfig;
import br.com.treinamento.dojo.model.Imposto;
import br.com.treinamento.dojo.model.Produto;
import br.com.treinamento.dojo.service.CalculadoraDeImpostoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TesteConfig.class)
public class CalculadoraDeImpostosTeste {

	@Autowired
	@Qualifier("impostoICMS")
	private Imposto icms;

	public Imposto getICMS() {
		return icms;
	}

	public void setICMS(Imposto icms) {
		this.icms = icms;
	}

	@Autowired
	@Qualifier("impostoISS")
	private Imposto iss;
	
	public Imposto getISS() {
		return iss;
	}

	public void setISS(Imposto iss) {
		this.iss = iss;
	}

	@Autowired
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@Autowired
	private CalculadoraDeImpostoService calculadora;
	
	public CalculadoraDeImpostoService getCalculadora() {
		return calculadora;
	}
	
	public void setCalculadora(CalculadoraDeImpostoService calculadora) {
		this.calculadora = calculadora;
	}
	

	@Test
	public void testISS() {

		produto.setNome("TV Samsung");
		produto.setValor(2000);

		double valorISS = calculadora.executaCalculo(produto, iss);

		Assert.assertTrue(valorISS == 100);
	}

	@Test
	public void testICMS() {

		produto.setNome("TV Samsung");
		produto.setValor(2000);

		double valorICMS = calculadora.executaCalculo(produto, icms);

		Assert.assertTrue(valorICMS == 360);
	}

}
