package br.com.fiapfood.pagamento.entities;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class PagamentoTest {

    @Test
    void testValidarDadosObrigatorios_IdPagamentoIntegradorNull() {
        Pagamento pagamento = Pagamento.builder()
                .idPedido(1L)
                .status(StatusPagamento.APROVADO)
                .dataPagamento(LocalDateTime.now())
                .build();

        Exception exception = Assertions.assertThrows(DominioException.class, pagamento::validarDados);
        Assertions.assertEquals("O numero identificador do integrador pagamento está nulo", exception.getMessage());
    }

    @Test
    void testValidarDadosObrigatorios_StatusNull() {
        Pagamento pagamento = Pagamento.builder()
                .idPagamentoIntegrador("123")
                .idPedido(1L)
                .dataPagamento(LocalDateTime.now())
                .build();

        Exception exception = Assertions.assertThrows(DominioException.class, pagamento::validarDados);
        Assertions.assertEquals("o status do pagamento está nulo", exception.getMessage());
    }

    @Test
    void testValidarDadosObrigatorios_IdPedidoNull() {
        Pagamento pagamento = Pagamento.builder()
                .idPagamentoIntegrador("123")
                .status(StatusPagamento.APROVADO)
                .dataPagamento(LocalDateTime.now())
                .build();

        Exception exception = Assertions.assertThrows(DominioException.class, pagamento::validarDados);
        Assertions.assertEquals("O pedido vinculado ao pagamento está nulo", exception.getMessage());
    }
}