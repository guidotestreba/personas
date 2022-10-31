package com.testreba.exception;

public class PersonaDuplicateException extends RuntimeException {

    private static final String ERROR_PERSONA_EXISTE = "Ya existe una persona guardada con el mismo documento y país";

    public PersonaDuplicateException(){
        super(ERROR_PERSONA_EXISTE);
    }
}
