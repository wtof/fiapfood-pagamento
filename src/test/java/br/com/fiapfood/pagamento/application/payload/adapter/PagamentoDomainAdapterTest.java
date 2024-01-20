package br.com.fiapfood.pagamento.application.payload.adapter;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoDomainAdapterTest {

    @Test
    void testAdaptSingleEntity() {
        PagamentoEntity entity = new PagamentoEntity();
        entity.setId("1");
        entity.setStatus(StatusPagamento.APROVADO);
        entity.setIdPagamentoIntegrador("12345");
        entity.setIdPedido(1L);
        entity.setDataPagamento(LocalDateTime.now());

        PagamentoDomainAdapter adapter = PagamentoDomainAdapter.build();
        Pagamento pagamento = adapter.adapt(entity);

        assertNotNull(pagamento);
        assertEquals(entity.getId(), pagamento.getId());
        assertEquals(entity.getStatus().name(), pagamento.getStatus().name());
        assertEquals(entity.getIdPagamentoIntegrador(), pagamento.getIdPagamentoIntegrador());
        assertEquals(entity.getIdPedido(), pagamento.getIdPedido());
        assertEquals(entity.getDataPagamento(), pagamento.getDataPagamento());
    }

    @Test
    void testAdaptEntityList() {
        PagamentoEntity entity1 = new PagamentoEntity();
        entity1.setId("1");
        entity1.setStatus(StatusPagamento.APROVADO);
        entity1.setIdPagamentoIntegrador("12345");
        entity1.setIdPedido(1L);
        entity1.setDataPagamento(LocalDateTime.now());

        PagamentoEntity entity2 = new PagamentoEntity();
        entity2.setId("2");
        entity2.setStatus(StatusPagamento.RECUSADO);
        entity2.setIdPagamentoIntegrador("67890");
        entity2.setIdPedido(2L);
        entity2.setDataPagamento(LocalDateTime.now());

        List<PagamentoEntity> entities = Arrays.asList(entity1, entity2);

        PagamentoDomainAdapter adapter = PagamentoDomainAdapter.build();
        List<Pagamento> pagamentos = adapter.adapt(entities);

        assertNotNull(pagamentos);
        assertEquals(2, pagamentos.size());
        assertEquals(entity1.getId(), pagamentos.get(0).getId());
        assertEquals(entity2.getId(), pagamentos.get(1).getId());
    }
}