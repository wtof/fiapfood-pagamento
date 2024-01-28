package br.com.fiapfood.pagamento.infra.messaging;

import br.com.fiapfood.pagamento.infra.entities.MockQueue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockQueueRepository extends JpaRepository<MockQueue, Long> {
    MockQueue findByNome(String name);
}