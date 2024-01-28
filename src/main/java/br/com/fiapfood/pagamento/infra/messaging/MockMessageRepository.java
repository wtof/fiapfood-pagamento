package br.com.fiapfood.pagamento.infra.messaging;


import br.com.fiapfood.pagamento.infra.entities.MockMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MockMessageRepository extends JpaRepository<MockMessage, Long> {

}