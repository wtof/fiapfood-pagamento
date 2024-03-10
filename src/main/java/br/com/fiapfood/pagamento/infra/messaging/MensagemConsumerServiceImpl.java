package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.application.interfaces.MensagemConsumerService;
import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.infra.exceptions.InfraException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MensagemConsumerServiceImpl implements MensagemConsumerService {
    private final PagamentoService pagamentoService;
    private static final String  PAGAMENTO_PENDENTE = "PAGAMENTO_PENDENTE";
    private static final Logger logger = LoggerFactory.getLogger(MensagemConsumerServiceImpl.class);
    public MensagemConsumerServiceImpl(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @Override
    @KafkaListener(topics = PAGAMENTO_PENDENTE, groupId = "pagamento_group_id")
    public void consumirMensagemPagamentoPendente(String mensagem) {
        logger.info("Consumindo mensagem de pagamento pendente: {}", mensagem);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(mensagem);
        } catch (JsonProcessingException e) {
            throw new InfraException("Erro ao converter mensagem para json: " + e.getMessage());
        }

        Long id = jsonNode.get("id").asLong();
        pagamentoService.processarPagamento(id);
    }
}
