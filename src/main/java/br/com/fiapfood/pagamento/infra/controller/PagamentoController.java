package br.com.fiapfood.pagamento.infra.controller;

import br.com.fiapfood.pagamento.application.interfaces.PagamentoService;
import br.com.fiapfood.pagamento.application.payload.response.PagamentoResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PagamentoController {
    private final PagamentoService pagamentoService;
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/pagamento/pedido/{idPedido}")
    @Operation(summary = "Operação responsável por buscar um pagamento por id do pedido")
    public ResponseEntity<PagamentoResponse> buscarPagamentoPorIdPedido(@PathVariable Long idPedido) {
        return ResponseEntity.ok(pagamentoService.buscarPagamentoPorIdPedido(idPedido));
    }
}
