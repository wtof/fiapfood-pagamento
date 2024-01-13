package br.com.fiapfood.pagamento.domain.entities;

import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pagamento {

    private Long id;

    private Long idPedido;

    private StatusPagamento status;

    private String idPagamentoIntegrador;

    private LocalDateTime dataPagamento;

    public void validarDados() {
        validarDadosObrigatorios();
    }

    private void validarDadosObrigatorios() {
        if (this.idPagamentoIntegrador == null) {
            throw new DominioException("O numero identificador do integrador pagamento está nulo");
        }

        if (this.status == null) {
            throw new DominioException("o status do pagamento está nulo");
        }

        if (this.getIdPedido() == null) {
            throw new DominioException("O id do pedido vinculado ao pagamento está nulo");
        }
    }
}
