package br.com.treinamento.dojo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.treinamento.dojo.config.TesteConfig;
import br.com.treinamento.dojo.model.ImpostoICMS;
import br.com.treinamento.dojo.model.ImpostoISS;
import br.com.treinamento.dojo.model.Produto;
import br.com.treinamento.dojo.service.CalculadoraDeImpostoImplService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TesteConfig.class)
public class CalculadoraDeImpostosTeste {

	@Autowired
	private ImpostoICMS icms;

	public ImpostoICMS getICMS() {
		return icms;
	}

	public void setICMS(ImpostoICMS icms) {
		this.icms = icms;
	}

	@Autowired
	private ImpostoISS iss;
	
	public ImpostoISS getISS() {
		return iss;
	}

	public void setISS(ImpostoISS iss) {
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
	private CalculadoraDeImpostoImplService calculadora;
	
	public CalculadoraDeImpostoImplService getCalculadora() {
		return calculadora;
	}
	
	public void setCalculadora(CalculadoraDeImpostoImplService calculadora) {
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
