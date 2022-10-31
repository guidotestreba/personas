package com.testreba.exception;

public class PaisNotFoundException extends RuntimeException {
    private static final String PAIS_NOT_FOUND = "País no encontrado";

    public PaisNotFoundException() {
        super(PAIS_NOT_FOUND);
    }
}
