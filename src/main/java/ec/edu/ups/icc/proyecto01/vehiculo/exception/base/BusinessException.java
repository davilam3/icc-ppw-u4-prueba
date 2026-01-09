package ec.edu.ups.icc.proyecto01.vehiculo.exception.base;

import org.springframework.http.HttpStatus;

public class BusinessException extends ApplicationException {

    public BusinessException(String message) {
        super(HttpStatus.UNPROCESSABLE_ENTITY, message);
    }

    protected BusinessException(HttpStatus status, String message) {
        super(status, message);
    }
}
