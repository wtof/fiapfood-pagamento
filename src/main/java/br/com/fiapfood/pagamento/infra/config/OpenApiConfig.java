package br.com.fiapfood.pagamento.infra.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    public OpenApiConfig() {
    }

    @Bean
    public OpenAPI fiapFoodOpenAPI() {
        return (new OpenAPI()).info((new Info())
                .title("Tech Challenger - Pós graduação Fiap Arquitetura de Software")
                .description("Api responsável por fornecer serviço para interfaces de aplicações de auto atendimento de lanchonetes. " +
                        "A API fornece serviços para gerenciamento de pagamentos dos pedidos gerados )")
                .version("1.0")
                .contact((new Contact())
                        .name("Walter de Oliveira Flôrencio")
                        .email("walteroliveiraflorencio@gmail.com")));
    }
}
