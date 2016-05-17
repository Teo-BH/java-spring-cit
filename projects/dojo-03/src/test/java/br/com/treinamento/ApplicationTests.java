package br.com.treinamento;

import java.nio.file.Path;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.treinamento.config.InsecureTruestManager;
import br.com.treinamento.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(TestConfig.class)
public class ApplicationTests {

	private Logger log = LoggerFactory.getLogger("br.com.treinamento");

	private WebTarget webTarget;

	@Autowired
	private InsecureTruestManager insecureTruestManager;

	@Autowired
	private HostnameVerifier hostnameVerifier;

	@Before
	public void setUp() throws NoSuchAlgorithmException, KeyManagementException {
		SSLContext ssl = SSLContext.getInstance("SSL");
		ssl.init(null, insecureTruestManager.certs, null);

		Client client = ClientBuilder.newBuilder().hostnameVerifier(hostnameVerifier).sslContext(ssl).build();
		webTarget = client.target("https://repositoriofabrica.xxxx/apixxxmock");
	}

	@Test
	public void test() {
		Response response = webTarget
				.path("a___d_____os")
				.path("f__e_c____o")
				.queryParam("c__", "93846500216")
				.request().get();
				
		String json = response.readEntity(String.class);

		log.debug("#####################");
		log.debug("STATUS: " + response.getStatus());
		log.debug(json);
		log.debug("#####################");

	}
	
	@Test
	public void getCartoesTest() {
		Response response = webTarget
				.path("c__t__s")
				.queryParam("c__", "50556627601")
				.queryParam("f___l___e", "alertas")
				.queryParam("c____t__c________a", "N")
				.request()
				.get();		
				
		String json = response.readEntity(String.class);

		log.debug("#####################");
		log.debug("STATUS: " + response.getStatus());
		log.debug(json);
		log.debug("#####################");
	}
	
	@Test
	public void postValidaSenhaTest() {
		Response response = webTarget
				.path("v____d____s")
				.path("c__t__s")
				.path("s____a")
				.request()
				.post(Entity.json("{ \"n_____c__t__\": \"4901720003522005\", \"c__\": \"37775677872\", \"s____a\": \"1122\" }"));
		
		String json = response.readEntity(String.class);

		log.debug("#####################");
		log.debug("STATUS: " + response.getStatus());
		log.debug(json);
		log.debug("#####################");
	}
	
	public InsecureTruestManager getInsecureTrustManager() {
		return insecureTruestManager;
	}

	public void setInsecureTrustManager(InsecureTruestManager insecureTruestManager) {
		this.insecureTruestManager = insecureTruestManager;
	}

	public HostnameVerifier getHostnameVerifier() {
		return hostnameVerifier;
	}

	public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
		this.hostnameVerifier = hostnameVerifier;
	}

}
