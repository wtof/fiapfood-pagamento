package br.com.fiapfood.pagamento.application.payload.adapter;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.infra.entities.PagamentoEntity;

import java.util.ArrayList;
import java.util.List;

public class PagamentoDomainAdapter {

    private PagamentoDomainAdapter() {
        super();
    }

    public static PagamentoDomainAdapter build() {
        return new PagamentoDomainAdapter();
    }

    public Pagamento adapt(PagamentoEntity entity) {
        if (entity == null) {
            return null;
        }
        return Pagamento.builder()
                .id(entity.getId())
                .status(StatusPagamento.valueOf(entity.getStatus().name()))
                .idPagamentoIntegrador(entity.getIdPagamentoIntegrador())
                .dataPagamento(entity.getDataPagamento())
                .build();
    }

    public List<Pagamento> adapt(List<PagamentoEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return null;
        }
        List<Pagamento> pagamentos = new ArrayList<>();
        entities.forEach(entity -> {
            pagamentos.add(adapt(entity));
        });
        return pagamentos;
    }
}
