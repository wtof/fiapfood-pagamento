package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pedidoClient", url = "${feign.client.pedido.url}")
public interface PedidoClientFeing {

    @PutMapping(value = "/pedidos/status")
    void atualizarStatusPedido(@RequestBody PedidoDTO pedidoDTO);
}
