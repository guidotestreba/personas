package com.testreba.model;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_persona")
    private Integer idPersona;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "id_documento")
    private Documento documento;

    private String nombre;

    private String apellido;

    private String email;

    private String celular;
}
