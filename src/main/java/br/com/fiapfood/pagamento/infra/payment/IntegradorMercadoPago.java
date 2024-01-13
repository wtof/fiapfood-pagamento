package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.interfaces.IntegradorPagamento;
import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.MedataDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IntegradorMercadoPago implements IntegradorPagamento {


    @Autowired
    private final RestTemplate restTemplate;

    public IntegradorMercadoPago(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public PagamentoDTO consultaPagamento(EventoPagamentoDTO eventoPagamentoDTO) {
//        HttpHeaders headers = new HttpHeaders();
//        String ACCESS_TOKEN = "";
//        headers.setBearerAuth(ACCESS_TOKEN);
//
//        HttpEntity<String> entity = new HttpEntity<>(headers);
//
//        String API_BASE_URL = "https://api.mercadopago.com/v1/payments/";
//        String url = API_BASE_URL + idPagamento;
//
//        ResponseEntity<PagamentoDTO> response = restTemplate.exchange(
//                url,
//                HttpMethod.GET,
//                entity,
//                PagamentoDTO.class
//        );

        //DADOS MOCKADOS PARA SIMULAR CONSULTA DO PAGAMENTO USANDO A API DO MERCADO PAGO
        return PagamentoDTO.builder()
                .id(eventoPagamentoDTO.getData().getId())
                .status("approved")
                .dateCreated(eventoPagamentoDTO.getDateCreated())
                .data(MedataDTO.builder()
                        .idPedido(eventoPagamentoDTO.getData().getPedido())
                        .build())
                .build();
    }
}
