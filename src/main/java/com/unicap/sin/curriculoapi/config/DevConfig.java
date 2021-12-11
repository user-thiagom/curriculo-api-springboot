package com.unicap.sin.curriculoapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unicap.sin.curriculoapi.service.DBService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String startegy;
	
	@Bean
	public boolean instanciaBaseDeDados() {
		if (startegy.equals("create")) {
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
}
