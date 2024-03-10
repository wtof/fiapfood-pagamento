package br.com.fiapfood.pagamento.application.services.payment;

import br.com.fiapfood.pagamento.application.interfaces.MensagemProducerService;
import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.application.payload.adapter.PagamentoResponseAdapter;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import br.com.fiapfood.pagamento.domain.usecases.PagamentoUseCaseImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {
    private final PagamentoUseCaseImpl pagamentoUseCase;
    private final MensagemProducerService mensagemService;

    public PagamentoServiceImpl(PagamentoUseCaseImpl pagamentoUseCase, MensagemProducerService mensagemService) {
        this.pagamentoUseCase = pagamentoUseCase;
        this.mensagemService = mensagemService;
    }

    public PagamentoResponse buscarPagamentoPorIdPedido(Long idPedido) {
        return PagamentoResponseAdapter.build().adapt(pagamentoUseCase.buscarPagamentoPorIdPedido(idPedido));
    }

    @Override
    public void processarPagamento(Long idPedido) {
        Pagamento pagamento = pagamentoUseCase.confirmarPagamento(idPedido);
        pagamento = pagamentoUseCase.validarPagamentoConfirmado(pagamento);
        PagamentoResponse response = PagamentoResponseAdapter.build().adapt(pagamento);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String pagamentoJson = null;
        try {
            pagamentoJson = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            throw new DominioException("Erro ao converter pagamento response para json: " + e.getMessage());
        }
        mensagemService.enviarMensagemPagamentoConfirmado(pagamentoJson);
    }
}
