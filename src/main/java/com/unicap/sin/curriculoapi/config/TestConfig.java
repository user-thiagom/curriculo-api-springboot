package com.unicap.sin.curriculoapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.unicap.sin.curriculoapi.service.DBService;



@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	
	@Bean
	public void instanciarBaseDeDados() {
		this.dbService.instanciaBaseDeDados();
	}
}
