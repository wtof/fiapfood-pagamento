package br.com.fiapfood.pagamento.domain.enuns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusPagamentoTest {
    @Test
    void testContainsAprovado() {
        assertNotNull(StatusPagamento.valueOf("APROVADO"));
    }

    @Test
    void testContainsRecusado() {
        assertNotNull(StatusPagamento.valueOf("RECUSADO"));
    }
}