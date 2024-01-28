package br.com.fiapfood.pagamento.application.payload.response;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void testBuilder() {
        int status = 404;
        String message = "Not Found";

        ErrorResponse response = ErrorResponse.builder()
                .status(status)
                .message(message)
                .build();

        assertNotNull(response);
        assertEquals(status, response.getStatus());
        assertEquals(message, response.getMessage());
    }

    @Test
    void testNoArgsConstructor() {
        ErrorResponse response = new ErrorResponse();

        assertNotNull(response);
        assertEquals(0, response.getStatus());
        assertNull(response.getMessage());
    }

    @Test
    void testAllArgsConstructor() {
        int status = 404;
        String message = "Not Found";

        ErrorResponse response = new ErrorResponse(status, message);

        assertNotNull(response);
        assertEquals(status, response.getStatus());
        assertEquals(message, response.getMessage());
    }
}