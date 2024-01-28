package br.com.fiapfood.pagamento.application.payload.response;

import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagamentoResponse {

    private String idPagamento;

    private Long idPedido;

    private StatusPagamento status;

    private String idPagamentoIntegrador;

    private LocalDateTime dataPagamento;
}
