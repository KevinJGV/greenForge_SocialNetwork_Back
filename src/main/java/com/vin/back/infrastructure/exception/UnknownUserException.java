package com.vin.back.infrastructure.exception;

public class UnknownUserException extends RuntimeException  {
    public UnknownUserException(String msg) {
        super(msg);
    }

}
