package com.testreba.service;

import com.testreba.exception.PersonaContactException;
import com.testreba.exception.PersonaDuplicateException;
import com.testreba.exception.PersonaEdadLessThanEightteenException;
import com.testreba.exception.PersonaNotFoundException;
import com.testreba.model.CamposPersonaEnum;
import com.testreba.model.Documento;
import com.testreba.model.Pais;
import com.testreba.model.Persona;
import com.testreba.model.dto.DocumentoDTO;
import com.testreba.model.dto.PaisDTO;
import com.testreba.model.dto.PersonaDTO;
import com.testreba.model.mapper.DocumentoMapper;
import com.testreba.model.mapper.PaisMapper;
import com.testreba.model.mapper.PersonaMapper;
import com.testreba.repository.PersonaRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements PersonaService {


    @Autowired
    private PersonaRepository repository;

    @Autowired
    private PaisService paisService;

    @Autowired
    private DocumentoService documentoService;

    @Override
    public List<PersonaDTO> obtenerPersonas() {
        return Mappers.getMapper(PersonaMapper.class).personasToPersonasDTOs(repository.obtenerPersonas());
    }

    @Override
    public PersonaDTO obtenerPersona(Integer id) {
        Persona persona = repository.obtenerPersona(id);
        if (persona == null)
            throw new PersonaNotFoundException();
        return Mappers.getMapper(PersonaMapper.class).personaToPersonaDTO(persona);
    }

    @Override
    public Integer obtenerIdPersonaPorIdPaisIdDocumento(Integer idPais, Integer idDocumento) {
        return repository.obtenerIdPersonaPorIdPaisIdDocumento(idPais, idDocumento);
    }

    @Override
    public PersonaDTO guardarPersona(PersonaDTO personaDTO) {
        Integer idPersona = repository.obtenerIdPersonaPorIdPaisIdDocumento(personaDTO.getPais().getIdPais(), personaDTO.getDocumento().getIdDocumento());
        if (idPersona != null)
            throw new PersonaDuplicateException();

        Integer edadPersona = repository.obtenerEdad(personaDTO.getFechaNacimiento());

        if (edadPersona < 18)
            throw new PersonaEdadLessThanEightteenException();

        if (personaDTO.getEmail() == null && personaDTO.getCelular() == null)
            throw new PersonaContactException();

        PaisDTO paisDTO = paisService.obtenerPais(personaDTO.getPais().getIdPais());
        DocumentoDTO documentoDTO = documentoService.obtenerDocumento(personaDTO.getDocumento().getIdDocumento());
        personaDTO.setPais(paisDTO);
        personaDTO.setDocumento(documentoDTO);
        Persona persona = repository.save(Mappers.getMapper(PersonaMapper.class).personaDTOtoPersona(personaDTO));
        personaDTO.setIdPersona(persona.getIdPersona());
        return personaDTO;
    }

    @Override
    public PersonaDTO actualizarPersona(Integer idPersona, PersonaDTO personaDTO) {
        Persona persona = repository.obtenerPersona(idPersona);

        if (persona == null)
            throw new PersonaNotFoundException();

        CamposPersonaEnum[] camposPersona = CamposPersonaEnum.values();
        for (CamposPersonaEnum campoPersona : camposPersona) {
            switch (campoPersona) {
                case NOMBRE:
                    if (personaDTO.getNombre() != null)
                        persona.setNombre(personaDTO.getNombre());
                    break;
                case APELLIDO:
                    if (personaDTO.getApellido() != null)
                        persona.setApellido(personaDTO.getApellido());
                    break;
                case EMAIL:
                    if (personaDTO.getEmail() != null)
                        persona.setEmail(personaDTO.getEmail());
                    break;
                case CELULAR:
                    if (personaDTO.getCelular() != null)
                        persona.setCelular(personaDTO.getCelular());
                    break;
                case DOCUMENTO:
                    if (personaDTO.getDocumento() != null) {
                        DocumentoDTO documentoDTO = documentoService.obtenerDocumento(personaDTO.getDocumento().getIdDocumento());
                        Documento documento = Mappers.getMapper(DocumentoMapper.class).documentoDTOtoDocumento(documentoDTO);
                        persona.setDocumento(documento);
                    }
                    break;
                case PAIS:
                    if (personaDTO.getPais() != null) {
                        PaisDTO paisDTO = paisService.obtenerPais(personaDTO.getPais().getIdPais());
                        Pais pais = Mappers.getMapper(PaisMapper.class).paisDTOtoPais(paisDTO);
                        persona.setPais(pais);
                    }
                    break;
                case FECHA_NACIMIENTO:
                    if (personaDTO.getFechaNacimiento() != null)
                        persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
                    break;
            }
        }

        return Mappers.getMapper(PersonaMapper.class).personaToPersonaDTO(repository.save(persona));

    }

    @Override
    public void borrarPersona(Integer idPersona) {
        Persona persona = repository.obtenerPersona(idPersona);

        if (persona == null)
            throw new PersonaNotFoundException();

        repository.borrarPersona(idPersona);
    }
}
