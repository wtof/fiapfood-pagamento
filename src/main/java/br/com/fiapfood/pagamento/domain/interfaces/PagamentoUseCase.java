package br.com.fiapfood.pagamento.domain.interfaces;


import br.com.fiapfood.pagamento.domain.entities.Pagamento;

public interface PagamentoUseCase {
    public Pagamento confirmarPagamento(Long  idPedido);
    public Pagamento buscarPagamentoPorIdPedido(Long idPedido);
    public Pagamento validarPagamentoConfirmado(Pagamento pagamento);
}
