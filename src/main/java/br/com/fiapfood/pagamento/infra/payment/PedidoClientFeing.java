package br.com.fiapfood.pagamento.infra.payment;

import br.com.fiapfood.pagamento.application.payload.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pedidoClient", url = "http://localhost:8081")
public interface PedidoClientFeing {

    @RequestMapping(method = RequestMethod.PUT, value = "/pedidos/status")
    void atualizarStatusPedido(@RequestBody PedidoDTO pedidoDTO);
}