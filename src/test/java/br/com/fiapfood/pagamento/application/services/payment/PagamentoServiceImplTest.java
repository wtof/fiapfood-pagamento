package br.com.fiapfood.pagamento.application.services.payment;

import br.com.fiapfood.pagamento.application.interfaces.MensagemProducerService;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.usecases.PagamentoUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

class PagamentoServiceImplTest {
    @Mock
    private PagamentoUseCaseImpl pagamentoUseCase;
    @Mock
    private MensagemProducerService mensagemService;

    private PagamentoServiceImpl pagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pagamentoService = new PagamentoServiceImpl(pagamentoUseCase, mensagemService);
    }

    @Test
    void testBuscarPagamentoPorIdPedido() {
        Long idPedido = 1L;
        Pagamento pagamento = new Pagamento();
        when(pagamentoUseCase.buscarPagamentoPorIdPedido(idPedido)).thenReturn(pagamento);
        assertDoesNotThrow(() -> pagamentoService.buscarPagamentoPorIdPedido(idPedido));
    }
}