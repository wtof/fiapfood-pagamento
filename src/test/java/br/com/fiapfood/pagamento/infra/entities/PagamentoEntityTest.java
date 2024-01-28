package br.com.fiapfood.pagamento.infra.entities;

import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoEntityTest {

    @Test
    void testBuilder() {
        String id = "1";
        Long idPedido = 1L;
        StatusPagamento status = StatusPagamento.APROVADO;
        String idPagamentoIntegrador = "1";
        LocalDateTime dataPagamento = LocalDateTime.now();

        PagamentoEntity entity = PagamentoEntity.builder()
                .id(id)
                .idPedido(idPedido)
                .status(status)
                .idPagamentoIntegrador(idPagamentoIntegrador)
                .dataPagamento(dataPagamento)
                .build();

        assertNotNull(entity);
        assertEquals(id, entity.getId());
        assertEquals(idPedido, entity.getIdPedido());
        assertEquals(status, entity.getStatus());
        assertEquals(idPagamentoIntegrador, entity.getIdPagamentoIntegrador());
        assertEquals(dataPagamento, entity.getDataPagamento());
    }

    @Test
    void testNoArgsConstructor() {
        PagamentoEntity entity = new PagamentoEntity();

        assertNotNull(entity);
        assertNull(entity.getId());
        assertNull(entity.getIdPedido());
        assertNull(entity.getStatus());
        assertNull(entity.getIdPagamentoIntegrador());
        assertNull(entity.getDataPagamento());
    }

    @Test
    void testAllArgsConstructor() {
        String id = "1";
        Long idPedido = 1L;
        StatusPagamento status = StatusPagamento.APROVADO;
        String idPagamentoIntegrador = "1";
        LocalDateTime dataPagamento = LocalDateTime.now();

        PagamentoEntity entity = new PagamentoEntity(id, idPedido, status, idPagamentoIntegrador, dataPagamento);

        assertNotNull(entity);
        assertEquals(id, entity.getId());
        assertEquals(idPedido, entity.getIdPedido());
        assertEquals(status, entity.getStatus());
        assertEquals(idPagamentoIntegrador, entity.getIdPagamentoIntegrador());
        assertEquals(dataPagamento, entity.getDataPagamento());
    }
}