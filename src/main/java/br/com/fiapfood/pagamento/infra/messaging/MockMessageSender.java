package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.infra.entities.MockMessage;
import br.com.fiapfood.pagamento.infra.entities.MockQueue;
import br.com.fiapfood.pagamento.infra.entities.QueueName;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockMessageSender implements MockMessaging {

	private final MockMessageRepository mockMessageRepository;
	private final MockQueueRepository mockQueueRepository;

	public MockMessageSender(MockMessageRepository mockMessageRepository, MockQueueRepository mockQueueRepository) {
		this.mockMessageRepository = mockMessageRepository;
		this.mockQueueRepository = mockQueueRepository;
	}

	@Override
	public MockMessage enviarMensagem(MockMessage message) {
		return mockMessageRepository.save(message);
	}

	@Override
	public List<MockMessage> buscarTodasMensagensSimuladas() {
		return mockMessageRepository.findAll();
	}

	public MockQueue buscarFilaPorNome(QueueName mockQueue) {
		return mockQueueRepository.findByNome(mockQueue.name());
	}

	public MockQueue salvarMockFila(MockQueue mockQueue) {
		List<MockQueue> queues = mockQueueRepository.findAll();
		if(queues.isEmpty()) {
			return mockQueueRepository.save(mockQueue);
		} else {
			return queues.get(0);
		}
	}
}
