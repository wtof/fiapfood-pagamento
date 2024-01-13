package br.com.fiapfood.pagamento.infra.entities;


import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public Long idPedido;

    public StatusPagamento status;

    public String idPagamentoIntegrador;

    public LocalDateTime dataPagamento;
}
