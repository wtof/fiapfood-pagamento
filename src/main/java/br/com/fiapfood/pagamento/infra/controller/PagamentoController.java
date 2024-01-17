package br.com.fiapfood.pagamento.infra.controller;

import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.application.payload.dto.EventoPagamentoDTO;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import br.com.fiapfood.pagamento.application.services.payment.PagamentoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoServiceImpl pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping("/pagamento")
    @Operation(summary = "Operação responsável por simular o recebimento de uma  notificação de pagamento do webhook do Mercado Pago. Action (payment.created)")
    public ResponseEntity<PagamentoResponse> recebeNotificacaoPagamento(@RequestBody EventoPagamentoDTO eventoPagamentoRequest) {
        return ResponseEntity.ok(pagamentoService.recebeNotificacaoEventoPagamento(eventoPagamentoRequest));
    }

    @GetMapping("/pagamento/pedido/{idPedido}")
    @Operation(summary = "Operação responsável por buscar um pagamento por id do pedido")
    public ResponseEntity<PagamentoResponse> buscarPagamentoPorIdPedido(@PathVariable Long idPedido) {
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorIdPedido(idPedido));
    }
}
