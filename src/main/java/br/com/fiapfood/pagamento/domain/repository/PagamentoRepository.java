package br.com.fiapfood.pagamento.domain.repository;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;

import java.util.List;

public interface PagamentoRepository {

    public Pagamento salvarPagamento(Pagamento pagamento);

    public Pagamento buscarPagamentoPorId(Long id);

    public List<Pagamento> buscarPedidoPorStatus(StatusPagamento status);

    public Pagamento buscarPagamentoPorIdPedido(Long idPedido);
}
