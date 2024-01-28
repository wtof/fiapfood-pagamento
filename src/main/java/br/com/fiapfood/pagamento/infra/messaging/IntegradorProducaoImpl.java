package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.application.interfaces.IntegradorProducao;
import br.com.fiapfood.pagamento.infra.entities.MockMessage;
import org.springframework.stereotype.Service;

@Service
public class IntegradorProducaoImpl implements IntegradorProducao {

    final MockMessaging mockMessaging;

    public IntegradorProducaoImpl(MockMessaging mockMessaging) {
        this.mockMessaging = mockMessaging;
    }

    @Override
    public void enviarPedidoProducao(MockMessage mockMessage) {
        mockMessaging.salvarMockFila(mockMessage.getFila());
        mockMessaging.enviarMensagem(mockMessage);
    }
}
