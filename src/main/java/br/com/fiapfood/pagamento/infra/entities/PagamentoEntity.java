package br.com.fiapfood.pagamento.infra.entities;


import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("Pagamento")
public class PagamentoEntity {

    @Id
    public String id;

    public Long idPedido;

    public StatusPagamento status;

    public String idPagamentoIntegrador;

    public LocalDateTime dataPagamento;
}
