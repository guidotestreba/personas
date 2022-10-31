package com.testreba.exception;

public class PersonaContactException extends RuntimeException {
    private static final String ERROR_FALTA_CONTACTO = "Debe ingresar al menos un dato de contacto";


    public PersonaContactException() {
        super(ERROR_FALTA_CONTACTO);
    }
}
