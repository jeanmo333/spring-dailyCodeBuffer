package com.francodev.springboottutorialmio.exception;

public class GlobalNotFoundException extends Exception{

    public GlobalNotFoundException() {
        super();
    }

    public GlobalNotFoundException(String message) {
        super(message);
    }

    public GlobalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public GlobalNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GlobalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}