package com.testreba.service;

import com.testreba.model.PaisEnum;
import com.testreba.model.dto.PersonaDTO;
import com.testreba.repository.PersonaRepository;

import java.util.List;
import java.util.Map;

public interface PersonaService {
    List<PersonaDTO> obtenerPersonas();

    PersonaDTO obtenerPersona(Integer id);

    Integer obtenerIdPersonaPorIdPaisIdDocumento(Integer idPais, Integer idDocumento);
    PersonaDTO guardarPersona(PersonaDTO personaDTO);

    PersonaDTO actualizarPersona(Integer idPersona, PersonaDTO personaDTO);

    void borrarPersona(Integer idPersona);

    List<PersonaRepository.Stat> obtenerStat();

}
