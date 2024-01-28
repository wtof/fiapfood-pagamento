package br.com.fiapfood.pagamento.infra.repository;

import br.com.fiapfood.pagamento.application.payload.adapter.PagamentoDomainAdapter;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.repository.PagamentoRepository;
import br.com.fiapfood.pagamento.infra.adapter.PagamentoEntityAdapter;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PagamentoRepositoryImpl implements PagamentoRepository {

    private final PagamentoRepositoryMongo repository;

    public PagamentoRepositoryImpl(PagamentoRepositoryMongo pagamentoRepositoryMongo) {
        this.repository = pagamentoRepositoryMongo;
    }

    @Override
    public Pagamento salvarPagamento(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = PagamentoEntityAdapter.build().adapt(pagamento);
        repository.save(pagamentoEntity);
        return  PagamentoDomainAdapter.build().adapt(pagamentoEntity);
    }

    @Override
    public Pagamento buscarPagamentoPorId(String id) {
        Optional<PagamentoEntity> optinal = repository.findById(id);
        return optinal.map(pagamentoEntity -> PagamentoDomainAdapter.build()
                .adapt(pagamentoEntity))
                .orElse(null);
    }

    @Override
    public List<Pagamento> buscarPedidoPorStatus(StatusPagamento status) {
        List<PagamentoEntity> pagamentosEntity = repository.findByStatus(status.name());
        return PagamentoDomainAdapter.build().adapt(pagamentosEntity);
    }

    @Override
    public Pagamento buscarPagamentoPorIdPedido(Long idPedido) {
        PagamentoEntity pagamentoEntity = repository.findByIdPedido(idPedido);
        return PagamentoDomainAdapter.build().adapt(pagamentoEntity);
    }
}
