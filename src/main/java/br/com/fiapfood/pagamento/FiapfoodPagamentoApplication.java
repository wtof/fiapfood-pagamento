package br.com.fiapfood.pagamento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FiapfoodPagamentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiapfoodPagamentoApplication.class, args);
	}

}
