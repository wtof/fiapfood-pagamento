package br.com.fiapfood.pagamento.infra.config;

import br.com.fiapfood.pagamento.application.exceptions.ApplicationException;
import br.com.fiapfood.pagamento.application.payload.response.ErrorResponse;
import br.com.fiapfood.pagamento.domain.exceptions.DominioException;
import br.com.fiapfood.pagamento.infra.exceptions.InfraException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public GlobalExceptionHandler() {
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("Erro interno do servidor").build();
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ApplicationException.class})
    public ResponseEntity<ErrorResponse> handleApplicationException(ApplicationException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage()).build();
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DominioException.class})
    public ResponseEntity<ErrorResponse> handleDominioException(DominioException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.BAD_REQUEST.value()).message(ex.getMessage()).build();
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({InfraException.class})
    public ResponseEntity<ErrorResponse> handleInfraExceptionException(InfraException ex) {
        ErrorResponse errorResponse = ErrorResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(ex.getMessage()).build();
        return new ResponseEntity(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
