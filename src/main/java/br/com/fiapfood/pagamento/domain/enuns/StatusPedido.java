package br.com.fiapfood.pagamento.domain.enuns;

public enum StatusPedido {
    INICIADO,
    PENDENTE_PAGAMENTO,
    PAGO,
    RECEBIDO,
    EM_PREPARACAO,
    PRONTO,
    FINALIZADO;

    private StatusPedido() {
    }
}
