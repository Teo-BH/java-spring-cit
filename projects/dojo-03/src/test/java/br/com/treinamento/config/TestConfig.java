package br.com.treinamento.config;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("br.com.treinamento")
public class TestConfig {
	
	@Bean
	public InsecureTruestManager insecureTrustManager() {		
		return new InsecureTruestManager();
	}

	@Bean
	public HostnameVerifier hostnameVerifier() {
		return new InsecureHostnameVerifier();
	}

}

class InsecureHostnameVerifier implements HostnameVerifier {
	@Override
	public boolean verify(String hostname, SSLSession session) {
		return true;
	}
}


