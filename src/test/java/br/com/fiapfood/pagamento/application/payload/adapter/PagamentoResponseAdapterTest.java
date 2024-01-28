package br.com.fiapfood.pagamento.application.payload.adapter;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoResponseAdapterTest {

    @Test
    void testAdaptSingleEntity() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId("1");
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento.setIdPagamentoIntegrador("12345");
        pagamento.setIdPedido(1L);
        pagamento.setDataPagamento(LocalDateTime.now());

        PagamentoResponseAdapter adapter = PagamentoResponseAdapter.build();
        PagamentoResponse response = adapter.adapt(pagamento);

        assertNotNull(response);
        assertEquals(pagamento.getId(), response.getIdPagamento());
        assertEquals(pagamento.getStatus(), response.getStatus());
        assertEquals(pagamento.getIdPagamentoIntegrador(), response.getIdPagamentoIntegrador());
        assertEquals(pagamento.getIdPedido(), response.getIdPedido());
        assertEquals(pagamento.getDataPagamento(), response.getDataPagamento());
    }

    @Test
    void testAdaptEntityList() {
        Pagamento pagamento1 = new Pagamento();
        pagamento1.setId("1");
        pagamento1.setStatus(StatusPagamento.APROVADO);
        pagamento1.setIdPagamentoIntegrador("12345");
        pagamento1.setIdPedido(1L);
        pagamento1.setDataPagamento(LocalDateTime.now());

        Pagamento pagamento2 = new Pagamento();
        pagamento2.setId("2");
        pagamento2.setStatus(StatusPagamento.RECUSADO);
        pagamento2.setIdPagamentoIntegrador("67890");
        pagamento2.setIdPedido(2L);
        pagamento2.setDataPagamento(LocalDateTime.now());

        List<Pagamento> pagamentos = Arrays.asList(pagamento1, pagamento2);

        PagamentoResponseAdapter adapter = PagamentoResponseAdapter.build();
        List<PagamentoResponse> responses = adapter.adapt(pagamentos);

        assertNotNull(responses);
        assertEquals(2, responses.size());
        assertEquals(pagamento1.getId(), responses.get(0).getIdPagamento());
        assertEquals(pagamento2.getId(), responses.get(1).getIdPagamento());
    }
}