package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.interfaces.IntegradorPedido;
import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class IntegradorPedidoImplTest {

    @Test
    void testAtualizarStatusPedido() {
        PedidoDTO pedidoDTO = new PedidoDTO();

        PedidoClientFeing client = Mockito.mock(PedidoClientFeing.class);
        Mockito.doNothing().when(client).atualizarStatusPedido(pedidoDTO);

        IntegradorPedido integrador = new IntegradorPedidoImpl(client);
        integrador.atualizarStatusPedido(pedidoDTO);

        Mockito.verify(client, Mockito.times(1)).atualizarStatusPedido(pedidoDTO);
    }
}