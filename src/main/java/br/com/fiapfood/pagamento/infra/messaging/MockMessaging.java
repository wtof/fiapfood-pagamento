package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.infra.entities.MockMessage;
import br.com.fiapfood.pagamento.infra.entities.MockQueue;
import br.com.fiapfood.pagamento.infra.entities.QueueName;

import java.util.List;

public interface MockMessaging {
	
	public MockMessage enviarMensagem(MockMessage message);
	
	public List<MockMessage> buscarTodasMensagensSimuladas();
	
	public MockQueue buscarFilaPorNome (QueueName nomeFila);
	
	public MockQueue salvarMockFila (MockQueue mockfila);
}
