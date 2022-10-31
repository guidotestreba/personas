package com.testreba.model.dto;

import com.testreba.model.Persona;
import com.testreba.model.RelacionEnum;

import javax.persistence.*;

public class RelacionDTO {

    private Integer idRelacion;
    private PersonaDTO persona;
    private RelacionEnum relacion;
    private PersonaDTO personaRelacion;

    public RelacionDTO() {

    }

    public RelacionDTO(Integer idRelacion, PersonaDTO persona, RelacionEnum relacion, PersonaDTO personaRelacion) {
        this.idRelacion = idRelacion;
        this.persona = persona;
        this.relacion = relacion;
        this.personaRelacion = personaRelacion;
    }

    public Integer getIdRelacion() {
        return idRelacion;
    }

    public void setIdRelacion(Integer idRelacion) {
        this.idRelacion = idRelacion;
    }

    public PersonaDTO getPersona() {
        return persona;
    }

    public void setPersona(PersonaDTO persona) {
        this.persona = persona;
    }

    public RelacionEnum getRelacion() {
        return relacion;
    }

    public void setRelacion(RelacionEnum relacion) {
        this.relacion = relacion;
    }

    public PersonaDTO getPersonaRelacion() {
        return personaRelacion;
    }

    public void setPersonaRelacion(PersonaDTO personaRelacion) {
        this.personaRelacion = personaRelacion;
    }
}
