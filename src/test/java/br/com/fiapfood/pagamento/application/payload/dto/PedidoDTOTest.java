package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoDTOTest {

    @Test
    void testBuilder() {
        Long id = 1L;

        PedidoDTO dto = PedidoDTO.builder()
                .id(id)
                .status(StatusPedidoDTO.PENDENTE_PAGAMENTO)
                .build();

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(StatusPedidoDTO.PENDENTE_PAGAMENTO, dto.getStatus());
    }

    @Test
    void testNoArgsConstructor() {
        PedidoDTO dto = new PedidoDTO();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getStatus());
    }

    @Test
    void testAllArgsConstructor() {
        Long id = 1L;
        PedidoDTO dto = new PedidoDTO(id, StatusPedidoDTO.PENDENTE_PAGAMENTO);
        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(StatusPedidoDTO.PENDENTE_PAGAMENTO, dto.getStatus());
    }
}