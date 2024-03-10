package br.com.fiapfood.pagamento.infra.controller;

import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.application.services.payment.PagamentoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoControllerTest {

    @Test
    void testBuscarPagamentoPorIdPedido() {
        Long idPedido = 1L;
        PagamentoResponse pagamentoResponse = new PagamentoResponse();

        PagamentoService pagamentoService = Mockito.mock(PagamentoServiceImpl.class);
        Mockito.when(pagamentoService.buscarPagamentoPorIdPedido(idPedido)).thenReturn(pagamentoResponse);

        PagamentoController controller = new PagamentoController(pagamentoService);
        ResponseEntity<PagamentoResponse> response = controller.buscarPagamentoPorIdPedido(idPedido);

        assertNotNull(response);
        assertEquals(pagamentoResponse, response.getBody());
    }
}