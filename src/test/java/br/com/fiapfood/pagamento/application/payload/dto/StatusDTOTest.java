package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusDTOTest {

    @Test
    void testEnumValues() {
        StatusDTO disponivel = StatusDTO.DISPONIVEL;
        StatusDTO indisponivel = StatusDTO.INDISPONIVEL;

        assertNotNull(disponivel);
        assertNotNull(indisponivel);
        assertNotEquals(disponivel, indisponivel);
    }
}