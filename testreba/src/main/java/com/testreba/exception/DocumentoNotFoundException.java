package com.testreba.exception;

public class DocumentoNotFoundException extends RuntimeException {
    public DocumentoNotFoundException(String message){
        super(message);
    }

}
