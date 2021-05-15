package net.lomibao.exception;

import io.micronaut.http.HttpStatus;

public class NotFoundException extends HttpException{
    public NotFoundException(){
        this(HttpStatus.NOT_FOUND.name());
    }
    public NotFoundException(String message, Object... params) {
        super(HttpStatus.NOT_FOUND, message, params);
    }
}
