package br.com.fiapfood.pagamento.domain.enuns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusPedidoTest {
    @Test
    void testContainsIniciado() {
        assertNotNull(StatusPedido.valueOf("INICIADO"));
    }

    @Test
    void testContainsPendentePagamento() {
        assertNotNull(StatusPedido.valueOf("PENDENTE_PAGAMENTO"));
    }

    @Test
    void testContainsPago() {
        assertNotNull(StatusPedido.valueOf("PAGO"));
    }

    @Test
    void testContainsRecebido() {
        assertNotNull(StatusPedido.valueOf("RECEBIDO"));
    }

    @Test
    void testContainsEmPreparacao() {
        assertNotNull(StatusPedido.valueOf("EM_PREPARACAO"));
    }

    @Test
    void testContainsPronto() {
        assertNotNull(StatusPedido.valueOf("PRONTO"));
    }

    @Test
    void testContainsFinalizado() {
        assertNotNull(StatusPedido.valueOf("FINALIZADO"));
    }
}