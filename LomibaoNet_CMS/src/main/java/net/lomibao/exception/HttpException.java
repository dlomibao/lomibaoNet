package net.lomibao.exception;

import io.micronaut.http.HttpStatus;
import lombok.Data;
import lombok.Getter;

public class HttpException extends RuntimeException{
    @Getter
    private HttpStatus status;
    public HttpException(HttpStatus status,String message,Object... params){
        super(String.format(message,params));
        this.status=status;
    }
}
