package com.springboot.exceptions;

public class GenericExceptions extends RuntimeException {

    private final String responseMessage;
    public GenericExceptions (String responseMessage) {
        super(responseMessage);
        this.responseMessage = responseMessage;
    }

    public GenericExceptions(String responseMessage, Throwable cause) {
        super(responseMessage, cause);
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }
}
