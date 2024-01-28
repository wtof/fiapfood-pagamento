package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.interfaces.IntegradorPagamento;
import br.com.fiapfood.pagamento.application.payload.dto.DataMercadoPagoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PagamentoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class IntegradorMercadoPagoTest {

    @Test
    void testConsultaPagamento() {
        RestTemplate restTemplate = new RestTemplate();
        IntegradorPagamento integrador = new IntegradorMercadoPago(restTemplate);

        DataMercadoPagoDTO dataMercadoPagoDTO = new DataMercadoPagoDTO();
        dataMercadoPagoDTO.setId("1");
        dataMercadoPagoDTO.setPedido(1L);

        EventoPagamentoDTO eventoPagamentoDTO = new EventoPagamentoDTO();
        eventoPagamentoDTO.setData(dataMercadoPagoDTO);
        eventoPagamentoDTO.getData().setId("1");
        eventoPagamentoDTO.getData().setPedido(1L);
        eventoPagamentoDTO.setDateCreated(LocalDateTime.now());

        PagamentoDTO pagamentoDTO = integrador.consultaPagamento(eventoPagamentoDTO);

        assertNotNull(pagamentoDTO);
        assertEquals(eventoPagamentoDTO.getData().getId(), pagamentoDTO.getId());
        assertEquals("approved", pagamentoDTO.getStatus());
        assertEquals(eventoPagamentoDTO.getDateCreated(), pagamentoDTO.getDateCreated());
        assertNotNull(pagamentoDTO.getData());
        assertEquals(eventoPagamentoDTO.getData().getPedido(), pagamentoDTO.getData().getIdPedido());
    }
}