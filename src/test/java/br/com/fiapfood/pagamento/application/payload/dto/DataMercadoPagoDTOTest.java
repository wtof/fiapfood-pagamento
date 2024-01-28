package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataMercadoPagoDTOTest {

    @Test
    void testBuilder() {
        String id = "12345";
        Long pedido = 1L;

        DataMercadoPagoDTO dto = DataMercadoPagoDTO.builder()
                .id(id)
                .pedido(pedido)
                .build();

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(pedido, dto.getPedido());
    }

    @Test
    void testNoArgsConstructor() {
        DataMercadoPagoDTO dto = new DataMercadoPagoDTO();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getPedido());
    }

    @Test
    void testAllArgsConstructor() {
        String id = "12345";
        Long pedido = 1L;

        DataMercadoPagoDTO dto = new DataMercadoPagoDTO(id, pedido);

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(pedido, dto.getPedido());
    }
}