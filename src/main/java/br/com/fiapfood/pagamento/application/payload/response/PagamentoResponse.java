package br.com.fiapfood.pagamento.application.payload.response;

import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PagamentoResponse {

    private String idPagamento;

    private Long idPedido;

    private StatusPagamento status;

    private String idPagamentoIntegrador;

    private LocalDateTime dataPagamento;
}
