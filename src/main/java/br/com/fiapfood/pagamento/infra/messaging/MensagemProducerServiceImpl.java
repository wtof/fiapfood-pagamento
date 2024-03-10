package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.application.interfaces.MensagemProducerService;
import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.infra.exceptions.InfraException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MensagemProducerServiceImpl implements MensagemProducerService {
    private static final String  PAGAMENTO_CONFIRMADO = "PAGAMENTO_CONFIRMADO";
    private static final Logger logger = LoggerFactory.getLogger(MensagemProducerServiceImpl.class);
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MensagemProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
	public void enviarMensagemPagamentoConfirmado(String mensagem) {
        logger.info("Enviando mensagem de pagamento confirmado: {}", mensagem);
        kafkaTemplate.send(PAGAMENTO_CONFIRMADO, mensagem);
	}
}
