package com.testreba.model;

import javax.persistence.*;

@Entity
@Table(name = "relaciones")
public class Relacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_relacion")
    private Integer idRelacion;

    @ManyToOne
    @JoinColumn(name = "id_persona")
    private Persona persona;

    @Column(name = "relacion")
    @Enumerated(EnumType.STRING)
    private RelacionEnum relacion;

    @ManyToOne
    @JoinColumn(name = "id_persona_relacion")
    private Persona personaRelacion;

    public Relacion(){

    }

    public Relacion(Integer idRelacion, Persona persona, RelacionEnum relacion, Persona personaRelacion) {
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public RelacionEnum getRelacion() {
        return relacion;
    }

    public void setRelacion(RelacionEnum relacion) {
        this.relacion = relacion;
    }

    public Persona getPersonaRelacion() {
        return personaRelacion;
    }

    public void setPersonaRelacion(Persona personaRelacion) {
        this.personaRelacion = personaRelacion;
    }
}
