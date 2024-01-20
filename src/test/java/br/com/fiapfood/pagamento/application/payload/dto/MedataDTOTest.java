package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedataDTOTest {

    @Test
    void testBuilder() {
        Long idPedido = 1L;

        MedataDTO dto = MedataDTO.builder()
                .idPedido(idPedido)
                .build();

        assertNotNull(dto);
        assertEquals(idPedido, dto.getIdPedido());
    }

    @Test
    void testNoArgsConstructor() {
        MedataDTO dto = new MedataDTO();

        assertNotNull(dto);
        assertNull(dto.getIdPedido());
    }

    @Test
    void testAllArgsConstructor() {
        Long idPedido = 1L;

        MedataDTO dto = new MedataDTO(idPedido);

        assertNotNull(dto);
        assertEquals(idPedido, dto.getIdPedido());
    }
}