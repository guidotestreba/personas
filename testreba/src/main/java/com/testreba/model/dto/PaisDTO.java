package com.testreba.model.dto;

import com.testreba.model.PaisEnum;

public class PaisDTO {
    private Integer idPais;
    private PaisEnum pais;

    public PaisDTO(Integer idPais, PaisEnum pais) {
        this.idPais = idPais;
        this.pais = pais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public PaisEnum getPais() {
        return pais;
    }

    public void setPais(PaisEnum pais) {
        this.pais = pais;
    }
}
