package br.com.fiapfood.pagamento.domain.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DominioExceptionTest {

    @Test
    void testEmptyConstructor() {
        DominioException exception = new DominioException();
        assertNull(exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String message = "Test message";
        DominioException exception = new DominioException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Test message";
        Throwable cause = new RuntimeException("Test cause");
        DominioException exception = new DominioException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Test cause");
        DominioException exception = new DominioException(cause);
        assertEquals(cause, exception.getCause());
    }
}