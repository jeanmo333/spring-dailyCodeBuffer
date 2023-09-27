package com.francodev.springboottutorialmio.exception;

public class GlobalBadRequestException extends Exception{

    public GlobalBadRequestException() {
        super();
    }

    public GlobalBadRequestException(String message) {
        super(message);
    }

    public GlobalBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalBadRequestException(Throwable cause) {
        super(cause);
    }

    protected GlobalBadRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}