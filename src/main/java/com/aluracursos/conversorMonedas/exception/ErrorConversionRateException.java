package com.aluracursos.conversorMonedas.exception;

public class ErrorConversionRateException extends RuntimeException {

    private String message;

    public ErrorConversionRateException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
