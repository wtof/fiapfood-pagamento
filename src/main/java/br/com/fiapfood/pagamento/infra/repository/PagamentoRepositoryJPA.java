package br.com.fiapfood.pagamento.infra.repository;

import br.com.fiapfood.pagamento.application.payload.adapter.PagamentoDomainAdapter;
import br.com.fiapfood.pagamento.infra.adapter.PagamentoEntityAdapter;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.repository.PagamentoRepository;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PagamentoRepositoryJPA implements PagamentoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Pagamento salvarPagamento(Pagamento pagamento) {
        PagamentoEntity pagamentoEntity = PagamentoEntityAdapter.build().adapt(pagamento);
        entityManager.persist(pagamentoEntity);
        return PagamentoDomainAdapter.build().adapt(pagamentoEntity);
    }

    @Override
    public Pagamento buscarPagamentoPorId(Long id) {
        try {
            return PagamentoDomainAdapter.build().adapt(entityManager.find(PagamentoEntity.class, id));
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Pagamento> buscarPedidoPorStatus(StatusPagamento status) {
        try {
            String jpql = "SELECT p FROM PagamentoEntity p WHERE p.status = :status";
            TypedQuery<PagamentoEntity> query = entityManager.createQuery(jpql, PagamentoEntity.class);
            query.setParameter("status", status);
            return PagamentoDomainAdapter.build().adapt(query.getResultList());
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public Pagamento buscarPagamentoPorIdPedido(Long idPedido) {
        try {
            String jpql = "SELECT p FROM PagamentoEntity p WHERE p.pedido.id = :pedidoId";
            TypedQuery<PagamentoEntity> query = entityManager.createQuery(jpql, PagamentoEntity.class);
            query.setParameter("pedidoId", idPedido);
            return PagamentoDomainAdapter.build().adapt(query.getSingleResult());
        } catch (NoResultException e) {
            return null;
        }
    }
}
