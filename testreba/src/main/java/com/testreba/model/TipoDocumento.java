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
    private String tipoDocumento;

}
