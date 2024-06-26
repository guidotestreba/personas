package com.testreba.model;

import javax.persistence.*;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_documento")
    private Integer idTipoDocumento;

    @Column(name = "tipo_documento")
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

    public TipoDocumento(){

    }

    public TipoDocumento(Integer idTipoDocumento, TipoDocumentoEnum tipoDocumento) {
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
