package br.com.fiapfood.pagamento.application.interfaces;


import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.infra.entities.MockMessage;

public interface PagamentoService {

    public PagamentoResponse recebeNotificacaoEventoPagamento(EventoPagamentoDTO eventoPagamentoDTO);

    public PagamentoResponse buscarPagamentoPorIdPedido(Long idPedido);

    public void atualizarStatusPedido(PedidoDTO pedidoDTO);

    public void enviarPedidoProducao(MockMessage mockMessage);
}
