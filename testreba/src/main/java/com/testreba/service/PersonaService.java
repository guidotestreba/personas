package com.testreba.service;

import com.testreba.model.Persona;
import com.testreba.model.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    List<PersonaDTO> obtenerPersonas();

    PersonaDTO obtenerPersona(Integer id);

    Integer obtenerIdPersonaPorIdPaisIdDocumento(Integer idPais, Integer idDocumento);
    PersonaDTO guardarPersona(PersonaDTO personaDTO);

    PersonaDTO actualizarPersona(Integer idPersona, PersonaDTO personaDTO);

    void borrarPersona(Integer idPersona);
}
