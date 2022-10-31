package com.testreba.exception;

public class DocumentoNotFoundException extends RuntimeException {
    private static final String DOCUMENTO_NOT_FOUND = "Documento no encontrado";

    public DocumentoNotFoundException() {
        super(DOCUMENTO_NOT_FOUND);
    }

}
