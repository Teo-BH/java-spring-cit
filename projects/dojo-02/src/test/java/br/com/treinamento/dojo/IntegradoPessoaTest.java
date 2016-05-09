package br.com.treinamento.dojo;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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
import br.com.treinamento.dojo.model.Pessoa;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
public class IntegradoPessoaTest {
	
	private WebTarget webTarget;
	
	@Before
	public void setUp(){
		Client client = ClientBuilder.newClient();
		webTarget = client.target("http://localhost:8080/dojo-02").path("v1").path("pessoa");
	}

	@Test
	public void testFaturaComCPFInvalidoNoHeader(){
		
		Response response = webTarget				
				.request()
				.header("cpf", Constants.CPF_COM_CARTAO)		
				.accept(MediaType.APPLICATION_JSON)
				.get();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		
		String json = response.readEntity(String.class);
		System.out.println(json);
		
		Gson gson = new Gson();		
		ResponseProtocol resposta = gson.fromJson(json, ResponseProtocol.class);
	
		// TODO: Ajustar pois não retornar um JSON válido em: resposta.getData().toString()
		System.out.println(resposta.getData().getClass()); // => class com.google.gson.internal.LinkedTreeMap
		Pessoa pessoa = gson.fromJson(resposta.getData().toString(), Pessoa.class);
		
		assertNotNull(pessoa);
		assertNotNull(pessoa.getEnderecos());
		assertTrue(pessoa.getEnderecos().size() != 0);
	}
}
