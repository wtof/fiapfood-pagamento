package br.com.fiapfood.pagamento.infra.adapter;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;

import java.util.ArrayList;
import java.util.List;

public class PagamentoEntityAdapter {


    private PagamentoEntityAdapter() {
        super();
    }

    public static PagamentoEntityAdapter build() {
        return new PagamentoEntityAdapter();
    }

    public PagamentoEntity adapt(Pagamento pagamento) {
        if (pagamento == null) {
            return null;
        }
        return PagamentoEntity.builder()
                .id(pagamento.getId())
                .status(StatusPagamento.valueOf(pagamento.getStatus().name()))
                .idPagamentoIntegrador(pagamento.getIdPagamentoIntegrador())
                .dataPagamento(pagamento.getDataPagamento())
                .idPedido(pagamento.getId())
                .build();
    }

    public List<PagamentoEntity> adapt(List<Pagamento> pagamentos) {
        if (pagamentos == null || pagamentos.isEmpty()) {
            return null;
        }
        List<PagamentoEntity> entities = new ArrayList<>();
        pagamentos.forEach(pagamento -> {
            entities.add(adapt(pagamento));
        });
        return entities;
    }
}
