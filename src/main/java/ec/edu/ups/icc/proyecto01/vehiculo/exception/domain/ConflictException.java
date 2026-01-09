package ec.edu.ups.icc.proyecto01.vehiculo.exception.domain;

import org.springframework.http.HttpStatus;

import ec.edu.ups.icc.proyecto01.vehiculo.exception.base.ApplicationException;


public class ConflictException extends ApplicationException {

    public ConflictException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}