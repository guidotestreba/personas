package com.testreba.model.mapper;

import com.testreba.model.Persona;
import com.testreba.model.dto.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    List<PersonaDTO> personasToPersonasDTOs(List<Persona> personas);

    @Mapping(source = "personaDTO.idPersona", target = "idPersona")
    @Mapping(source = "personaDTO.nombre", target = "nombre")
    @Mapping(source = "personaDTO.apellido", target = "apellido")
    @Mapping(source = "personaDTO.email", target = "email")
    @Mapping(source = "personaDTO.celular", target = "celular")
    @Mapping(source = "personaDTO.pais", target = "pais")
    @Mapping(source = "personaDTO.documento", target = "documento")
    @Mapping(source = "personaDTO.fechaNacimiento", target = "fechaNacimiento")
    Persona personaDTOtoPersona(PersonaDTO personaDTO);

    @Mapping(source = "persona.idPersona", target = "idPersona")
    @Mapping(source = "persona.nombre", target = "nombre")
    @Mapping(source = "persona.apellido", target = "apellido")
    @Mapping(source = "persona.email", target = "email")
    @Mapping(source = "persona.celular", target = "celular")
    @Mapping(source = "persona.pais", target = "pais")
    @Mapping(source = "persona.documento", target = "documento")
    @Mapping(source = "persona.fechaNacimiento", target = "fechaNacimiento")
    PersonaDTO personaToPersonaDTO(Persona persona);

}
