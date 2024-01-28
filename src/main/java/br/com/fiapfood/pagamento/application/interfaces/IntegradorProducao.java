package br.com.fiapfood.pagamento.application.interfaces;

import br.com.fiapfood.pagamento.infra.entities.MockMessage;

public interface IntegradorProducao {
    void enviarPedidoProducao(MockMessage mockMessage);
}
