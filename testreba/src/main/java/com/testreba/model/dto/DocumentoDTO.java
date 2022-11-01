package com.testreba.model.dto;

public class DocumentoDTO {
    private Integer idDocumento;
    private String nroDocumento;
    private TipoDocumentoDTO tipoDocumento;

    public DocumentoDTO(){

    }

    public DocumentoDTO(Integer idDocumento, String nroDocumento, TipoDocumentoDTO tipoDocumento) {
        this.idDocumento = idDocumento;
        this.nroDocumento = nroDocumento;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}