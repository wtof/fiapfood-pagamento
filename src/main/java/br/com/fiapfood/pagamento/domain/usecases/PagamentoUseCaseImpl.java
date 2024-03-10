package br.com.fiapfood.pagamento.domain.usecases;

import br.com.fiapfood.pagamento.domain.entities.Pagamento;
import br.com.fiapfood.pagamento.domain.enuns.StatusPagamento;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import br.com.fiapfood.pagamento.domain.interfaces.PagamentoUseCase;
import br.com.fiapfood.pagamento.domain.repository.PagamentoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PagamentoUseCaseImpl implements PagamentoUseCase {

    private final PagamentoRepository pagamentoRepository;


    public PagamentoUseCaseImpl(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Pagamento confirmarPagamento(Long idPedido) {

        if (pagamentoRepository.buscarPagamentoPorIdPedido(idPedido) != null) {
            throw new DominioException("Já existe pagamento para o id do pedido informado : " + idPedido);
        }

        Pagamento pagamento = Pagamento.builder()
                .dataPagamento(LocalDateTime.now())
                .idPagamentoIntegrador("MOCK")
                .status(StatusPagamento.APROVADO)
                .idPedido(idPedido)
                .build();
        pagamento.validarDados();
        pagamento = pagamentoRepository.salvarPagamento(pagamento);

        return pagamento;
    }

    public Pagamento buscarPagamentoPorIdPedido(Long idPedido) {

        Pagamento pagamento = pagamentoRepository.buscarPagamentoPorIdPedido(idPedido);

        if(pagamento == null) {
            throw new DominioException("Não foi possível encontrar o pagamento com o id do pedido informado: " + idPedido);
        }

        return pagamentoRepository.buscarPagamentoPorIdPedido(idPedido);
    }

    @Override
    public Pagamento validarPagamentoConfirmado(Pagamento pagamento) {
        if(pagamento.getStatus() != StatusPagamento.APROVADO) {
            throw new DominioException("Não é possível confirmar um pagamento que nao foi aprovado.");
        }
        return pagamento;
    }
}
