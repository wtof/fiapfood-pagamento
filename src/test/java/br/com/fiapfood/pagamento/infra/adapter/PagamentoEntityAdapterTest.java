package br.com.fiapfood.pagamento.infra.adapter;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoEntityAdapterTest {

    @Test
    void testAdaptSingleEntity() {
        Pagamento pagamento = new Pagamento();
        pagamento.setId("1");
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento.setIdPagamentoIntegrador("123");
        pagamento.setDataPagamento(null);
        pagamento.setIdPedido(1L);

        PagamentoEntityAdapter adapter = PagamentoEntityAdapter.build();
        PagamentoEntity entity = adapter.adapt(pagamento);

        assertNotNull(entity);
        assertEquals(pagamento.getId(), entity.getId());
        assertEquals(pagamento.getStatus().name(), entity.getStatus().name());
        assertEquals(pagamento.getIdPagamentoIntegrador(), entity.getIdPagamentoIntegrador());
        assertEquals(pagamento.getDataPagamento(), entity.getDataPagamento());
        assertEquals(pagamento.getIdPedido(), entity.getIdPedido());
    }

    @Test
    void testAdaptMultipleEntities() {
        Pagamento pagamento1 = new Pagamento();
        pagamento1.setId("1");
        pagamento1.setStatus(StatusPagamento.APROVADO);
        pagamento1.setIdPagamentoIntegrador("123");
        pagamento1.setDataPagamento(null);
        pagamento1.setIdPedido(1L);

        Pagamento pagamento2 = new Pagamento();
        pagamento2.setId("2");
        pagamento2.setStatus(StatusPagamento.RECUSADO);
        pagamento2.setIdPagamentoIntegrador("456");
        pagamento2.setDataPagamento(null);
        pagamento2.setIdPedido(2L);

        List<Pagamento> pagamentos = Arrays.asList(pagamento1, pagamento2);

        PagamentoEntityAdapter adapter = PagamentoEntityAdapter.build();
        List<PagamentoEntity> entities = adapter.adapt(pagamentos);

        assertNotNull(entities);
        assertEquals(2, entities.size());
        assertEquals(pagamento1.getId(), entities.get(0).getId());
        assertEquals(pagamento2.getId(), entities.get(1).getId());
    }
}