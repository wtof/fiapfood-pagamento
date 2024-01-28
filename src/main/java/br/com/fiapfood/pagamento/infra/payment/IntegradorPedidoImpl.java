package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.interfaces.IntegradorPedido;
import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import org.springframework.stereotype.Service;

@Service
public class IntegradorPedidoImpl implements IntegradorPedido
{
    private final PedidoClientFeing pedidoClientFeing;

    public IntegradorPedidoImpl(PedidoClientFeing pedidoClientFeing) {
        this.pedidoClientFeing = pedidoClientFeing;
    }

    @Override
    public void atualizarStatusPedido(PedidoDTO pedidoDTO) {
        pedidoClientFeing.atualizarStatusPedido(pedidoDTO);
    }
}
