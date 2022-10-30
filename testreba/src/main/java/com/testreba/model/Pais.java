package com.testreba.model;

import javax.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "pais")
    private String pais;
}
