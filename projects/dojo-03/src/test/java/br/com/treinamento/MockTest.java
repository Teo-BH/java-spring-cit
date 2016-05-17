package br.com.treinamento;

import static org.mockito.Mockito.*;

import org.junit.Test;
public class MockTest {

	@Test
	public void test() {
		
		Produto produto = new Produto();
//		produto.setNome("Apple");
		
		DAO dao = new DAO();
//		dao.atualizar(produto);		
		
		DAO mockDAO = mock(DAO.class);
		Produto mockProduto = mock(Produto.class);
		
		when(mockProduto.getNome()).thenReturn("Samsung");
		dao.atualizar(mockProduto);
		
//		mockDAO.atualizar(mockProduto);
//		verify(mockDAO).verifica();
		
		
		
	}
	
}

class DAO{
	
	public String atualizar(Produto produto){
		System.out.println("chamou atualiza");
		System.out.println("Produto.nome: "+produto.getNome());
		
		verifica();
		
		return "atualizado";
	}
	
	public void verifica(){}
}

class Produto{
	public String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
