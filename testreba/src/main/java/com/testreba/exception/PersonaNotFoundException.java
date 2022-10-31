package com.testreba.exception;

public class PersonaNotFoundException extends RuntimeException {
    private static final String ERROR_PERSONA_NOT_FOUND = "La persona solicitada no existe";

    public PersonaNotFoundException() {
        super(ERROR_PERSONA_NOT_FOUND);
    }
}
