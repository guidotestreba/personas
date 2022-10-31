package com.testreba.model.dto;

import java.sql.Date;
import java.time.LocalDate;

public class PersonaDTO {
    private Integer idPersona;

    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private PaisDTO pais;
    private DocumentoDTO documento;

    private LocalDate fechaNacimiento;

    public PersonaDTO(Integer idPersona, PaisDTO pais, DocumentoDTO documento, String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento) {
        this.idPersona = idPersona;
        this.pais = pais;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.celular = celular;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public PaisDTO getPais() {
        return pais;
    }

    public void setPais(PaisDTO pais) {
        this.pais = pais;
    }

    public DocumentoDTO getDocumento() {
        return documento;
    }

    public void setDocumento(DocumentoDTO documento) {
        this.documento = documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
