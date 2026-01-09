package ec.edu.ups.icc.proyecto01.vehiculo.exception.domain;

import org.springframework.http.HttpStatus;

import ec.edu.ups.icc.proyecto01.vehiculo.exception.base.ApplicationException;

public class NotFoundException extends ApplicationException {

    public NotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
