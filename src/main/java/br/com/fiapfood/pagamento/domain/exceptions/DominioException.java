package br.com.fiapfood.pagamento.domain.exceptions;

public class DominioException extends RuntimeException {
    private static final long serialVersionUID = 4260483373395023237L;

    public DominioException() {
    }

    public DominioException(String message) {
        super(message);
    }

    public DominioException(String message, Throwable cause) {
        super(message, cause);
    }

    public DominioException(Throwable cause) {
        super(cause);
    }
}
