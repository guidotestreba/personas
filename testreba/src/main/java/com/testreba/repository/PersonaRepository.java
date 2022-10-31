package com.testreba.repository;

import com.testreba.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    @Query(value = "select p.id_persona, p.id_pais, pa.pais, p.id_documento, d.nro_documento, d.id_tipo_documento, td.tipo_documento,\n" +
            "p.nombre,p.apellido, p.email, p.celular, p.fecha_nacimiento from personas p \n" +
            "inner join paises pa on pa.id_pais = p.id_pais \n" +
            "inner join documentos d on d.id_documento = p.id_documento\n" +
            "inner join tipos_documentos td on td.id_tipo_documento = d.id_tipo_documento", nativeQuery = true)
    List<Persona> obtenerPersonas();

    @Query(value = "select p.id_persona from personas p where p.id_pais = ?1 and p.id_documento = ?2", nativeQuery = true)
    Integer obtenerIdPersonaPorIdPaisIdDocumento(Integer idPais, Integer idDocumento);

    @Query(value = "select TIMESTAMPDIFF(YEAR,?1,CURDATE()) AS edad", nativeQuery = true)
    Integer obtenerEdad(LocalDate fechaNacimiento);

    @Query(value = "select p.id_persona, p.id_pais, pa.pais, p.id_documento, d.nro_documento, d.id_tipo_documento, td.tipo_documento,\n" +
            "p.nombre,p.apellido, p.email, p.celular, p.fecha_nacimiento from personas p \n" +
            "inner join paises pa on pa.id_pais = p.id_pais \n" +
            "inner join documentos d on d.id_documento = p.id_documento\n" +
            "inner join tipos_documentos td on td.id_tipo_documento = d.id_tipo_documento where p.id_persona = ?1", nativeQuery = true)
    Persona obtenerPersona(Integer id);

    @Modifying
    @Transactional
    @Query(value = "delete from personas where id_persona = ?1", nativeQuery = true)
    Integer borrarPersona(Integer idPersona);

}
