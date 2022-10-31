package com.testreba.model.dto;

import com.testreba.model.TipoDocumentoEnum;

public class TipoDocumentoDTO {
    private Integer idTipoDocumento;
    private TipoDocumentoEnum tipoDocumento;

    public TipoDocumentoDTO(Integer idTipoDocumento, TipoDocumentoEnum tipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public TipoDocumentoEnum getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoEnum tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}
