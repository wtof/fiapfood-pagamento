package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "pedidoClient", url = "http://localhost:8080")
public interface PedidoClientFeing {

    @PostMapping("/pedidos")
    void atualizarStatusPedido(PedidoDTO pedidoDTO);
}