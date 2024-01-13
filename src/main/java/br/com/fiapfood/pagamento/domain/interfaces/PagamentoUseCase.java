package br.com.fiapfood.pagamento.domain.interfaces;


import br.com.fiapfood.pagamento.domain.entities.Pagamento;

public interface PagamentoUseCase {
    public Pagamento salvarPagamento(Pagamento pagamento);
    public Pagamento buscarPagamentoPorIdPedido(Long idPedido);
}
