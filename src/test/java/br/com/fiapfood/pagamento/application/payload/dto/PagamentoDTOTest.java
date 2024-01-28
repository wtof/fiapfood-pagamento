package br.com.fiapfood.pagamento.application.payload.dto;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class PagamentoDTOTest {

    @Test
    void testBuilder() {
        String id = "12345";
        LocalDateTime dateCreated = LocalDateTime.now();
        String dateApproved = "2022-01-01";
        String dateLastUpdated = "2022-01-02";
        String moneyReleaseDate = "2022-01-03";
        String paymentMethodId = "method1";
        String paymentTypeId = "type1";
        String status = "status";
        String statusDetail = "detail";
        String currencyId = "currency1";
        String description = "description";
        Long collectorId = 1L;
        MedataDTO data = new MedataDTO();

        PagamentoDTO dto = PagamentoDTO.builder()
                .id(id)
                .dateCreated(dateCreated)
                .dateApproved(dateApproved)
                .dateLastUpdated(dateLastUpdated)
                .moneyReleaseDate(moneyReleaseDate)
                .paymentMethodId(paymentMethodId)
                .paymentTypeId(paymentTypeId)
                .status(status)
                .statusDetail(statusDetail)
                .currencyId(currencyId)
                .description(description)
                .collectorId(collectorId)
                .data(data)
                .build();

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(dateCreated, dto.getDateCreated());
        assertEquals(dateApproved, dto.getDateApproved());
        assertEquals(dateLastUpdated, dto.getDateLastUpdated());
        assertEquals(moneyReleaseDate, dto.getMoneyReleaseDate());
        assertEquals(paymentMethodId, dto.getPaymentMethodId());
        assertEquals(paymentTypeId, dto.getPaymentTypeId());
        assertEquals(status, dto.getStatus());
        assertEquals(statusDetail, dto.getStatusDetail());
        assertEquals(currencyId, dto.getCurrencyId());
        assertEquals(description, dto.getDescription());
        assertEquals(collectorId, dto.getCollectorId());
        assertEquals(data, dto.getData());
    }

    @Test
    void testNoArgsConstructor() {
        PagamentoDTO dto = new PagamentoDTO();

        assertNotNull(dto);
        assertNull(dto.getId());
        assertNull(dto.getDateCreated());
        assertNull(dto.getDateApproved());
        assertNull(dto.getDateLastUpdated());
        assertNull(dto.getMoneyReleaseDate());
        assertNull(dto.getPaymentMethodId());
        assertNull(dto.getPaymentTypeId());
        assertNull(dto.getStatus());
        assertNull(dto.getStatusDetail());
        assertNull(dto.getCurrencyId());
        assertNull(dto.getDescription());
        assertNull(dto.getCollectorId());
        assertNull(dto.getData());
    }

    @Test
    void testAllArgsConstructor() {
        String id = "12345";
        LocalDateTime dateCreated = LocalDateTime.now();
        String dateApproved = "2022-01-01";
        String dateLastUpdated = "2022-01-02";
        String moneyReleaseDate = "2022-01-03";
        String paymentMethodId = "method1";
        String paymentTypeId = "type1";
        String status = "status";
        String statusDetail = "detail";
        String currencyId = "currency1";
        String description = "description";
        Long collectorId = 1L;
        MedataDTO data = new MedataDTO();

        PagamentoDTO dto = new PagamentoDTO(id, dateCreated, dateApproved, dateLastUpdated, moneyReleaseDate, paymentMethodId, paymentTypeId, status, statusDetail, currencyId, description, collectorId, data);

        assertNotNull(dto);
        assertEquals(id, dto.getId());
        assertEquals(dateCreated, dto.getDateCreated());
        assertEquals(dateApproved, dto.getDateApproved());
        assertEquals(dateLastUpdated, dto.getDateLastUpdated());
        assertEquals(moneyReleaseDate, dto.getMoneyReleaseDate());
        assertEquals(paymentMethodId, dto.getPaymentMethodId());
        assertEquals(paymentTypeId, dto.getPaymentTypeId());
        assertEquals(status, dto.getStatus());
        assertEquals(statusDetail, dto.getStatusDetail());
        assertEquals(currencyId, dto.getCurrencyId());
        assertEquals(description, dto.getDescription());
        assertEquals(collectorId, dto.getCollectorId());
        assertEquals(data, dto.getData());
    }

}