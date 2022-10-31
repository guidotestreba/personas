package com.testreba.repository;

import com.testreba.model.Relacion;
import com.testreba.model.RelacionEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RelacionRepository extends JpaRepository<Relacion, Integer> {

    @Query(value = "select r.relacion from relaciones r where r.id_persona = ?1 and r.id_persona_relacion = ?2", nativeQuery = true)
    RelacionEnum getRelacion(Integer idPersonaUno, Integer idPersonaDos);
}
