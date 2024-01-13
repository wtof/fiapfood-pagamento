package br.com.fiapfood.pagamento.application.interfaces;

import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.dto.PagamentoDTO;

public interface IntegradorPagamento {

    PagamentoDTO consultaPagamento(EventoPagamentoDTO eventoPagamentoDTO);
}
