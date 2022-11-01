CREATE SCHEMA IF NOT EXISTS testrebadb;

CREATE TABLE IF NOT EXISTS testrebadb.tipos_documentos (
  id_tipo_documento INT NOT NULL,
  tipo_documento VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_tipo_documento),
  UNIQUE INDEX tipo_documento_UNIQUE (tipo_documento ASC));

CREATE TABLE IF NOT EXISTS testrebadb.documentos (
  id_documento INT NOT NULL,
  nro_documento VARCHAR(45) NULL,
  id_tipo_documento INT NOT NULL,
  PRIMARY KEY (id_documento),
  INDEX fk_id_tipo_documento_idx (id_tipo_documento ASC),
  CONSTRAINT fk_id_tipo_documento
    FOREIGN KEY (id_tipo_documento)
    REFERENCES testrebadb.tipos_documentos (id_tipo_documento));

CREATE TABLE IF NOT EXISTS testrebadb.paises (
  id_pais INT NOT NULL,
  pais VARCHAR(100) NOT NULL,
  PRIMARY KEY (id_pais),
  UNIQUE INDEX pais_UNIQUE (pais ASC));

CREATE TABLE IF NOT EXISTS testrebadb.personas (
  id_persona INT NOT NULL,
  id_pais INT NOT NULL,
  id_documento INT NOT NULL,
  nombre VARCHAR(45) NOT NULL,
  apellido VARCHAR(45) NOT NULL,
  email VARCHAR(45) NULL,
  celular VARCHAR(45) NULL,
  fecha_nacimiento DATE NOT NULL,
  PRIMARY KEY (id_persona),
  INDEX fk_pais_id_idx (id_pais ASC),
  INDEX fk_documento_id_idx (id_documento ASC),
  CONSTRAINT fk_pais_id
    FOREIGN KEY (id_pais)
    REFERENCES testrebadb.paises (id_pais),
  CONSTRAINT fk_documento_id
    FOREIGN KEY (id_documento)
    REFERENCES testrebadb.documentos (id_documento));

INSERT INTO testrebadb.tipos_documentos (id_tipo_documento, tipo_documento) VALUES (1, 'DNI');

INSERT INTO testrebadb.paises (id_pais, pais) VALUES (1, 'ARGENTINA');
INSERT INTO testrebadb.paises (id_pais, pais) VALUES (2, 'ESPAÑA');

INSERT INTO testrebadb.documentos (id_documento, nro_documento, id_tipo_documento) VALUES (1, '36658879', 1);
INSERT INTO testrebadb.documentos (id_documento, nro_documento, id_tipo_documento) VALUES (2, '35152485', 1);
INSERT INTO testrebadb.documentos (id_documento, nro_documento, id_tipo_documento) VALUES (3, '14803498', 1);
INSERT INTO testrebadb.documentos (id_documento, nro_documento, id_tipo_documento) VALUES (4, '13449034', 1);