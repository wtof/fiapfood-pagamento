package br.com.fiapfood.pagamento.application.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataMercadoPagoDTO {

    private String id;

    private Long pedido;
}
