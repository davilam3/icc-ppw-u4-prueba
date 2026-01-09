package ec.edu.ups.icc.proyecto01.vehiculo.exception.domain;

import org.springframework.http.HttpStatus;

import ec.edu.ups.icc.proyecto01.vehiculo.exception.base.ApplicationException;


public class BadRequestException extends ApplicationException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}