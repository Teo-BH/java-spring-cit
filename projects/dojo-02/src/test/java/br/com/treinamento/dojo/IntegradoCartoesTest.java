package br.com.treinamento.dojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;

import br.com.treinamento.dojo.config.TestConfig;
import br.com.treinamento.dojo.dto.ResponseProtocol;
import br.com.treinamento.dojo.model.Cartao;
import br.com.treinamento.dojo.model.Fatura;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
public class IntegradoCartoesTest {
	
	private WebTarget webTarget;
	
	@Before
	public void setUp(){
		Client client = ClientBuilder.newClient();
		webTarget = client.target("http://localhost:8080/dojo-02").path("v1").path("cartoes");
	}

	@Test
	public void testCPFValido() {

		Response response = webTarget
				.queryParam("cpf", Constants.CPF_COM_CARTAO)
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(HttpStatus.OK, response.getStatus());
		
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		Gson gson = new Gson();		
		ResponseProtocol resposta = gson.fromJson(json, ResponseProtocol.class);
	
		Cartao[] cartoes = gson.fromJson(resposta.getData().toString(), Cartao[].class);
		
		assertEquals(Constants.CARTAO_VALIDO, cartoes[0].getNro());
	}
	
	@Test
	public void testCPFInvalido(){
		Response response = webTarget
				.queryParam("cpf", Constants.CPF_INVALIDO)
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(HttpStatus.NOT_FOUND, response.getStatus());
	}
	
	@Test
	public void testFaturaComCPFNoHeader(){
		
		Response response = webTarget
				.path(Constants.CARTAO_VALIDO)
				.path("faturas")
				.request()
				.header("cpf", Constants.CPF_COM_CARTAO)		
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(HttpStatus.OK, response.getStatus());
		
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		Gson gson = new Gson();		
		ResponseProtocol resposta = gson.fromJson(json, ResponseProtocol.class);
		assertTrue(! resposta.getData().toString().isEmpty());
		
		Fatura[] faturas = gson.fromJson(resposta.getData().toString(), Fatura[].class);
		
		assertTrue(faturas.length != 0);		
	}
	
	@Test
	public void testFaturaComCPFInvalidoNoHeader(){
		
		Response response = webTarget
				.path(Constants.CARTAO_VALIDO)
				.path("faturas")
				.request()
				.header("cpf", Constants.CPF_INVALIDO)		
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(HttpStatus.FORBIDDEN, response.getStatus());		
	}
	
	@Test
	public void testCriaCartao(){
		
		Cartao cartao = new Cartao();
		cartao.setLimite(1000);
		cartao.setNro("4444");
		cartao.setValidade("10/2019");
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(cartao));
		
		Response response = webTarget
				.request()
				.header("cpf", Constants.CPF_COM_CARTAO)		
				.accept(MediaType.APPLICATION_JSON)
				.post(Entity.entity(cartao, MediaType.APPLICATION_JSON));
		
		assertEquals(HttpStatus.OK, response.getStatus());
		
		String json = response.readEntity(String.class);
		System.out.println(json);	
			
		ResponseProtocol resposta = gson.fromJson(json, ResponseProtocol.class);
		
		assertTrue(Constants.MSG_CARTAO_CRIADO_SUCESSO.equals(resposta.getMensagem()));	
	}

}
