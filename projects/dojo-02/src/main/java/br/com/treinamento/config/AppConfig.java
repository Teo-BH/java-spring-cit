package br.com.treinamento.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("br.com.treinamento.dojo")
public class AppConfig {

	@Bean
	@Scope(value = "singleton")
	public Map<String, Object> getDb() {
		return new HashMap<String, Object>();
	}

}
