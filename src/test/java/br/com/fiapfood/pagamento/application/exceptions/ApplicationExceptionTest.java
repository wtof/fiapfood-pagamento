package br.com.fiapfood.pagamento.application.exceptions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationExceptionTest {

    @Test
    void testEmptyConstructor() {
        ApplicationException exception = new ApplicationException();
        assertNull(exception.getMessage());
    }

    @Test
    void testConstructorWithMessage() {
        String message = "Test message";
        ApplicationException exception = new ApplicationException(message);
        assertEquals(message, exception.getMessage());
    }

    @Test
    void testConstructorWithMessageAndCause() {
        String message = "Test message";
        Throwable cause = new RuntimeException("Test cause");
        ApplicationException exception = new ApplicationException(message, cause);
        assertEquals(message, exception.getMessage());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void testConstructorWithCause() {
        Throwable cause = new RuntimeException("Test cause");
        ApplicationException exception = new ApplicationException(cause);
        assertEquals(cause, exception.getCause());
    }
}