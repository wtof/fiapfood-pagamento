package br.com.fiapfood.pagamento.application.services.payment;

import br.com.fiapfood.pagamento.application.exceptions.ApplicationException;
import br.com.fiapfood.pagamento.application.interfaces.IntegradorPagamento;
import br.com.fiapfood.pagamento.application.interfaces.IntegradorPedido;
import br.com.fiapfood.pagamento.application.interfaces.IntegradorProducao;
import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.MedataDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.usecases.PagamentoUseCaseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class PagamentoServiceImplTest {

    @Mock
    private IntegradorPagamento integradorPagamento;

    @Mock
    private PagamentoUseCaseImpl pagamentoUseCase;

    @Mock
    private IntegradorPedido integradorPedido;

    @Mock
    private IntegradorProducao integradorProducao;

    private PagamentoServiceImpl pagamentoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        pagamentoService = new PagamentoServiceImpl(integradorPagamento, pagamentoUseCase, integradorPedido, integradorProducao);
    }

    @Test
    void testRecebeNotificacaoEventoPagamento() {
        EventoPagamentoDTO eventoPagamentoDTO = new EventoPagamentoDTO();
        eventoPagamentoDTO.setAction("payment.created");
        Pagamento pagamento = new Pagamento();
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setStatus("approved");
        MedataDTO medataDTO = new MedataDTO();
        medataDTO.setIdPedido(1L);
        pagamentoDTO.setData(medataDTO);
        when(integradorPagamento.consultaPagamento(eventoPagamentoDTO)).thenReturn(pagamentoDTO);
        when(pagamentoUseCase.salvarPagamento(any())).thenReturn(pagamento);
        assertDoesNotThrow(() -> pagamentoService.recebeNotificacaoEventoPagamento(eventoPagamentoDTO));
    }

    @Test
    void testRecebeNotificacaoEventoPagamento_InvalidAction() {
        EventoPagamentoDTO eventoPagamentoDTO = new EventoPagamentoDTO();
        eventoPagamentoDTO.setAction("invalid.action");
        assertThrows(ApplicationException.class, () -> pagamentoService.recebeNotificacaoEventoPagamento(eventoPagamentoDTO));
    }

    @Test
    void testBuscarPagamentoPorIdPedido() {
        Long idPedido = 1L;
        Pagamento pagamento = new Pagamento();
        when(pagamentoUseCase.buscarPagamentoPorIdPedido(idPedido)).thenReturn(pagamento);
        assertDoesNotThrow(() -> pagamentoService.buscarPagamentoPorIdPedido(idPedido));
    }

    @Test
    void testAtualizarStatusPedido() {
        PedidoDTO pedidoDTO = new PedidoDTO();
        assertDoesNotThrow(() -> pagamentoService.atualizarStatusPedido(pedidoDTO));
        verify(integradorPedido, times(1)).atualizarStatusPedido(pedidoDTO);
    }
}