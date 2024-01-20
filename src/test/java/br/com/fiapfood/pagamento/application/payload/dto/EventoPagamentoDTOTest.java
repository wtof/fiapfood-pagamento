package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventoPagamentoDTOTest {

    @Test
    void testBuilder() {
        String action = "action";
        String apiVersion = "1.0";
        String applicationId = "12345";
        LocalDateTime dateCreated = LocalDateTime.now();
        String id = "12345";
        boolean liveMode = true;
        String type = "type";
        String userId = "12345";
        DataMercadoPagoDTO data = new DataMercadoPagoDTO();

        EventoPagamentoDTO dto = EventoPagamentoDTO.builder()
                .action(action)
                .apiVersion(apiVersion)
                .applicationId(applicationId)
                .dateCreated(dateCreated)
                .id(id)
                .liveMode(liveMode)
                .type(type)
                .userId(userId)
                .data(data)
                .build();

        assertNotNull(dto);
        assertEquals(action, dto.getAction());
        assertEquals(apiVersion, dto.getApiVersion());
        assertEquals(applicationId, dto.getApplicationId());
        assertEquals(dateCreated, dto.getDateCreated());
        assertEquals(id, dto.getId());
        assertEquals(liveMode, dto.isLiveMode());
        assertEquals(type, dto.getType());
        assertEquals(userId, dto.getUserId());
        assertEquals(data, dto.getData());
    }

    @Test
    void testNoArgsConstructor() {
        EventoPagamentoDTO dto = new EventoPagamentoDTO();

        assertNotNull(dto);
        assertNull(dto.getAction());
        assertNull(dto.getApiVersion());
        assertNull(dto.getApplicationId());
        assertNull(dto.getDateCreated());
        assertNull(dto.getId());
        assertFalse(dto.isLiveMode());
        assertNull(dto.getType());
        assertNull(dto.getUserId());
        assertNull(dto.getData());
    }

    @Test
    void testAllArgsConstructor() {
        String action = "action";
        String apiVersion = "1.0";
        String applicationId = "12345";
        LocalDateTime dateCreated = LocalDateTime.now();
        String id = "12345";
        boolean liveMode = true;
        String type = "type";
        String userId = "12345";
        DataMercadoPagoDTO data = new DataMercadoPagoDTO();

        EventoPagamentoDTO dto = new EventoPagamentoDTO(action, apiVersion, applicationId, dateCreated, id, liveMode, type, userId, data);

        assertNotNull(dto);
        assertEquals(action, dto.getAction());
        assertEquals(apiVersion, dto.getApiVersion());
        assertEquals(applicationId, dto.getApplicationId());
        assertEquals(dateCreated, dto.getDateCreated());
        assertEquals(id, dto.getId());
        assertEquals(liveMode, dto.isLiveMode());
        assertEquals(type, dto.getType());
        assertEquals(userId, dto.getUserId());
        assertEquals(data, dto.getData());
    }
}