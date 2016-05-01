package br.com.treinamento.dojo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.treinamento.dojo.config.TesteConfig;
import br.com.treinamento.dojo.model.Carrinho;
import br.com.treinamento.dojo.model.Produto;
import br.com.treinamento.dojo.service.CalculadoraDeDescontos;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TesteConfig.class)
public class CalculadorDeDescontosTeste {

	private CalculadoraDeDescontos calculadorDescontos;

	@Test
	public void testMaiorQueMil() {
		Produto tv = new Produto();
		tv.setNome("TV Samsung");
		tv.setValor(1500);

		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(tv);

		Carrinho carrinho = new Carrinho(1500, listaProdutos);

		double desconto = calculadorDescontos.calcula(carrinho);

		System.out.println(desconto);
		assertTrue(desconto == 150);
	}

	@Test
	public void testTresProdutos() {
		Produto caneta1 = new Produto();
		caneta1.setNome("Caneta Preta");
		caneta1.setValor(3);

		Produto caneta2 = new Produto();
		caneta2.setNome("Caneta Vermelha");
		caneta2.setValor(4);

		Produto caneta3 = new Produto();
		caneta3.setNome("Caneta azul");
		caneta3.setValor(3);

		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(caneta1);
		listaProdutos.add(caneta2);
		listaProdutos.add(caneta3);

		Carrinho carrinho = new Carrinho(10, listaProdutos);

		double desconto = calculadorDescontos.calcula(carrinho);

		System.out.println(desconto);
		assertTrue(desconto == 0.50);
	}

	@Test
	public void testZero() {
		Produto tv = new Produto();
		tv.setNome("TV Samsung");
		tv.setValor(999);

		List<Produto> listaProdutos = new ArrayList<Produto>();
		listaProdutos.add(tv);

		Carrinho carrinho = new Carrinho(999, listaProdutos);

		double desconto = calculadorDescontos.calcula(carrinho);

		System.out.println(desconto);
		assertTrue(desconto == 0);
	}

}
