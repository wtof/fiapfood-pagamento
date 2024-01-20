package br.com.fiapfood.pagamento.infra.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfraExceptionTest {

    @Test
    void testNoArgsConstructor() {
        InfraException exception = new InfraException();

        assertNotNull(exception);
        assertNull(exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMessageConstructor() {
        String message = "Test message";
        InfraException exception = new InfraException(message);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
        assertNull(exception.getCause());
    }

    @Test
    void testMessageAndCauseConstructor() {
        String message = "Test message";
        Throwable cause = new Throwable();
        InfraException exception = new InfraException(message, cause);

        assertNotNull(exception);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testCauseConstructor() {
        Throwable cause = new Throwable();
        InfraException exception = new InfraException(cause);

        assertNotNull(exception);
        assertEquals(cause, exception.getCause());
    }
}