package br.com.fiapfood.pagamento.domain.usecases;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import br.com.fiapfood.pagamento.domain.repository.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PagamentoUseCaseImplTest {

    @Mock
    private PagamentoRepository pagamentoRepository;

    private PagamentoUseCaseImpl pagamentoUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        pagamentoUseCase = new PagamentoUseCaseImpl(pagamentoRepository);
    }

    @Test
    void testSalvarPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setIdPagamentoIntegrador("12345");
        pagamento.setStatus(StatusPagamento.APROVADO);
        pagamento.setIdPedido(1L);

        when(pagamentoRepository.buscarPagamentoPorIdPedido(anyLong())).thenReturn(null);
        when(pagamentoRepository.salvarPagamento(any(Pagamento.class))).thenReturn(pagamento);

        assertDoesNotThrow(() -> pagamentoUseCase.salvarPagamento(pagamento));
    }

    @Test
    void testSalvarPagamentoExistente() {
        Pagamento pagamento = new Pagamento();
        when(pagamentoRepository.buscarPagamentoPorIdPedido(anyLong())).thenReturn(pagamento);

        assertThrows(DominioException.class, () -> pagamentoUseCase.salvarPagamento(pagamento));
    }

    @Test
    void testBuscarPagamentoPorIdPedido() {
        Pagamento pagamento = new Pagamento();
        when(pagamentoRepository.buscarPagamentoPorIdPedido(anyLong())).thenReturn(pagamento);

        assertDoesNotThrow(() -> pagamentoUseCase.buscarPagamentoPorIdPedido(1L));
    }

    @Test
    void testBuscarPagamentoPorIdPedidoInexistente() {
        when(pagamentoRepository.buscarPagamentoPorIdPedido(anyLong())).thenReturn(null);

        assertThrows(DominioException.class, () -> pagamentoUseCase.buscarPagamentoPorIdPedido(1L));
    }
}