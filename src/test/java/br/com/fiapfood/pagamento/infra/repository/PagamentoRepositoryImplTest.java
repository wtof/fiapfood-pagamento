package br.com.fiapfood.pagamento.infra.repository;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoRepositoryImplTest {

    @Test
    void testSalvarPagamento() {
        Pagamento pagamento = new Pagamento();
        pagamento.setStatus(StatusPagamento.APROVADO);
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setStatus(StatusPagamento.APROVADO);

        PagamentoRepositoryMongo repository = Mockito.mock(PagamentoRepositoryMongo.class);
        Mockito.when(repository.save(Mockito.any())).thenReturn(pagamentoEntity);

        PagamentoRepositoryImpl pagamentoRepository = new PagamentoRepositoryImpl(repository);
        Pagamento result = pagamentoRepository.salvarPagamento(pagamento);

        assertNotNull(result);
    }

    @Test
    void testBuscarPagamentoPorId() {
        String id = "1";
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setStatus(StatusPagamento.APROVADO);

        PagamentoRepositoryMongo repository = Mockito.mock(PagamentoRepositoryMongo.class);
        Mockito.when(repository.findById(id)).thenReturn(Optional.of(pagamentoEntity));

        PagamentoRepositoryImpl pagamentoRepository = new PagamentoRepositoryImpl(repository);
        Pagamento result = pagamentoRepository.buscarPagamentoPorId(id);

        assertNotNull(result);
    }

    @Test
    void testBuscarPedidoPorStatus() {
        StatusPagamento status = StatusPagamento.APROVADO;
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setStatus(status);

        PagamentoRepositoryMongo repository = Mockito.mock(PagamentoRepositoryMongo.class);
        Mockito.when(repository.findByStatus(status.name())).thenReturn(Collections.singletonList(pagamentoEntity));

        PagamentoRepositoryImpl pagamentoRepository = new PagamentoRepositoryImpl(repository);
        var result = pagamentoRepository.buscarPedidoPorStatus(status);

        assertFalse(result.isEmpty());
    }

    @Test
    void testBuscarPagamentoPorIdPedido() {
        Long idPedido = 1L;
        PagamentoEntity pagamentoEntity = new PagamentoEntity();
        pagamentoEntity.setStatus(StatusPagamento.APROVADO);

        PagamentoRepositoryMongo repository = Mockito.mock(PagamentoRepositoryMongo.class);
        Mockito.when(repository.findByIdPedido(idPedido)).thenReturn(pagamentoEntity);

        PagamentoRepositoryImpl pagamentoRepository = new PagamentoRepositoryImpl(repository);
        Pagamento result = pagamentoRepository.buscarPagamentoPorIdPedido(idPedido);

        assertNotNull(result);
    }
}