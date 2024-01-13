package br.com.fiapfood.pagamento.application.payload.adapter;

import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.domain.entities.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class PagamentoResponseAdapter {


    private PagamentoResponseAdapter() {
        super();
    }

    public static PagamentoResponseAdapter build() {
        return new PagamentoResponseAdapter();
    }

    public PagamentoResponse adapt(Pagamento pagamento) {
        if (pagamento == null) {
            return  null;
        }
        return PagamentoResponse.builder()
                .idPagamento(pagamento.getId())
                .status(pagamento.getStatus())
                .idPagamentoIntegrador(pagamento.getIdPagamentoIntegrador())
                .idPedido(pagamento.getPedido().getId())
                .dataPagamento(pagamento.getDataPagamento())
                .build();
    }

    public List<PagamentoResponse> adapt(List<Pagamento> pagamentos) {
        List<PagamentoResponse> pagamentoResponses = new ArrayList<>();

        if (pagamentos == null || pagamentos.isEmpty()) {
            return pagamentoResponses;
        }

        pagamentos.forEach(pagamento -> {
            pagamentoResponses.add(adapt(pagamento));
        });
        return pagamentoResponses;
    }
}