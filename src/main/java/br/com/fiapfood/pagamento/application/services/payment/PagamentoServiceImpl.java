package br.com.fiapfood.pagamento.application.services.payment;

import br.com.fiapfood.pagamento.application.exceptions.ApplicationException;
import br.com.fiapfood.pagamento.application.interfaces.IntegradorPagamento;
import br.com.fiapfood.pagamento.application.interfaces.IntegradorPedido;
import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.application.payload.adapter.PagamentoResponseAdapter;
import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.StatusPedidoDTO;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.usecases.PagamentoUseCaseImpl;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    private final IntegradorPagamento integradorPagamento;
    private final PagamentoUseCaseImpl pagamentoUseCase;
    private final IntegradorPedido integradorPedido;

    public PagamentoServiceImpl(IntegradorPagamento integradorPagamento, PagamentoUseCaseImpl pagamentoUseCase, IntegradorPedido integradorPedido) {
        this.integradorPagamento = integradorPagamento;
        this.pagamentoUseCase = pagamentoUseCase;
        this.integradorPedido = integradorPedido;
    }

    public PagamentoResponse recebeNotificacaoEventoPagamento(EventoPagamentoDTO eventoPagamentoDTO) {

        Pagamento pagamento = null;

        if (eventoPagamentoDTO.getAction().equals("payment.created")) {
            pagamento = salvarPagamento(eventoPagamentoDTO);
        } else {
            throw new ApplicationException("Evento de pagamento nao esperado action: " + eventoPagamentoDTO.getAction());
        }

        return PagamentoResponseAdapter.build().adapt(pagamento);
    }

    private Pagamento salvarPagamento(EventoPagamentoDTO eventoPagamentoDTO) {
        Pagamento pagamento = Pagamento.builder().build();
        PagamentoDTO pagamentoDTO = null;
        pagamentoDTO = consultaPagamento(eventoPagamentoDTO);

        switch (pagamentoDTO.getStatus()) {
            case "approved" -> pagamento.setStatus(StatusPagamento.APROVADO);
            case "rejected" -> pagamento.setStatus(StatusPagamento.RECUSADO);
            default -> throw new ApplicationException("Status do pagamento nao esperado: " + pagamentoDTO.getStatus());
        }

        pagamento.setIdPagamentoIntegrador(pagamentoDTO.getId());
        pagamento.setDataPagamento(pagamentoDTO.getDateCreated());
        pagamento.setIdPedido(pagamentoDTO.getData().getIdPedido());
        pagamento = pagamentoUseCase.salvarPagamento(pagamento);

        PedidoDTO pedidoDTO = PedidoDTO.builder()
                .id(pagamento.getIdPedido())
                .status(pagamento.getStatus() == StatusPagamento.APROVADO ? StatusPedidoDTO.PAGO : StatusPedidoDTO.PENDENTE_PAGAMENTO)
                .build();

        atualizarStatusPedido(pedidoDTO);

        return  pagamento;
    }

    private PagamentoDTO consultaPagamento(EventoPagamentoDTO eventoPagamentoDTO) {
        PagamentoDTO pagamentoDTO;

        pagamentoDTO = integradorPagamento.consultaPagamento(eventoPagamentoDTO);

        return pagamentoDTO;
    }

    public PagamentoResponse buscarPagamentoPorIdPedido(Long idPedido) {
        return PagamentoResponseAdapter.build().adapt(pagamentoUseCase.buscarPagamentoPorIdPedido(idPedido));
    }

    @Override
    public void atualizarStatusPedido(PedidoDTO pedidoDTO) {
        integradorPedido.atualizarStatusPedido(pedidoDTO);
    }

}
