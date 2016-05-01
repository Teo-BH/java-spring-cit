package br.com.treinamento.dojo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.treinamento.dojo.config.TesteConfig;
import br.com.treinamento.dojo.model.Produto;
import br.com.treinamento.dojo.service.CalculadoraDeImpostoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TesteConfig.class)
public class CalculadoraDeImpostosTeste {

	private ICMS icms;
	private ISS iss;
	private Produto produto;
	private CalculadoraDeImpostoService calculadora;

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
