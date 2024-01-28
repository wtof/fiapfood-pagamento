package br.com.fiapfood.pagamento.infra.repository;

import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PagamentoRepositoryMongo extends MongoRepository<PagamentoEntity,String > {

    PagamentoEntity findByIdPedido(Long idPedido);

    List<PagamentoEntity> findByStatus(String status);
}
