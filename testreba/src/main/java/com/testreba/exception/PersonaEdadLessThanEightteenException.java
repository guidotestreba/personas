package com.testreba.exception;

public class PersonaEdadLessThanEightteenException extends RuntimeException {
    private static final String ERROR_MENOR_DE_EDAD = "La persona que está intentando ingresar es menor de edad";


    public PersonaEdadLessThanEightteenException (){
        super(ERROR_MENOR_DE_EDAD);
    }
}
