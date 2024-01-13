package br.com.fiapfood.pagamento.application.payload.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO {

    private Long id;

    private String nome;

    private Float preco;

    private Integer quantidadeEstoque;

    private StatusDTO status;

    private Categoria categoria;
}
