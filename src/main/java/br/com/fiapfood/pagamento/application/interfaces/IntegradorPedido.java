package br.com.fiapfood.pagamento.application.interfaces;

import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;

public interface IntegradorPedido {
    void atualizarStatusPedido(PedidoDTO pedidoDTO);
}
