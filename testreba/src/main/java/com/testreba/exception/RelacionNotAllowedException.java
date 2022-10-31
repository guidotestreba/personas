package com.testreba.exception;

public class RelacionNotAllowedException extends RuntimeException {
    private static final String ERROR_RELACION_NOT_ALLOWED = "La relación ingresada no es PADRE";

    public RelacionNotAllowedException() {
        super(ERROR_RELACION_NOT_ALLOWED);
    }
}
