package br.com.fiapfood.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableJpaRepositories
public class FiapfoodPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapfoodPagamentoApplication.class, args);
	}

}
