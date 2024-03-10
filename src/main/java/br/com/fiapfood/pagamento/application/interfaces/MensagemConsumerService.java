package br.com.fiapfood.pagamento.application.interfaces;

public interface MensagemConsumerService {

    void consumirMensagemPagamentoPendente(String mensagem);
}
