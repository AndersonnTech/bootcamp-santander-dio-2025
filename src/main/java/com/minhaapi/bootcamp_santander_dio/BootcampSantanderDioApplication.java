package com.minhaapi.bootcamp_santander_dio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Para resolver problemas com CORS ao acessar api instanciada na nuvem
@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class BootcampSantanderDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampSantanderDioApplication.class, args);
	}

}
