package br.com.fiapfood.pagamento.infra.exceptions;

public class InfraException extends RuntimeException {
    private static final long serialVersionUID = 4260483373395023237L;

    public InfraException() {
    }

    public InfraException(String message) {
        super(message);
    }

    public InfraException(String message, Throwable cause) {
        super(message, cause);
    }

    public InfraException(Throwable cause) {
        super(cause);
    }
}
