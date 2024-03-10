package br.com.fiapfood.pagamento.application.interfaces;


import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;

public interface PagamentoService {
    public PagamentoResponse buscarPagamentoPorIdPedido(Long idPedido);
    public void processarPagamento(Long idPedido);
}
