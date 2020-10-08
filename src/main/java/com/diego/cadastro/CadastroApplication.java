package com.diego.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroApplication.class, args);
		System.out.println("\n <<<<< APLICAÇÃO ESTÁ EM EXECUÇÃO >>>>>\n" +
				"\n" +
				"Link de acesso ao Swagger http://localhost:8080/swagger-ui.html\n" +
				"\n" +
				"Link de acesso a interface Angular http://localhost:8080/#/\n" +
				"\n"+
				"\n" +
				"Link de teste http://api-diegorangel.ddns.net:8080/#/\n" +
				"\n");
	}

}
