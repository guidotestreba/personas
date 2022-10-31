package com.testreba.service;

import com.testreba.exception.RelacionNotAllowedException;
import com.testreba.model.Relacion;
import com.testreba.model.RelacionEnum;
import com.testreba.model.dto.PersonaDTO;
import com.testreba.model.dto.RelacionDTO;
import com.testreba.model.mapper.PersonaMapper;
import com.testreba.model.mapper.RelacionMapper;
import com.testreba.repository.RelacionRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelacionServiceImpl implements RelacionService {

    @Autowired
    private RelacionRepository repository;

    @Autowired
    private PersonaService personaService;

    @Override
    public RelacionDTO guardarPadre(Integer idPersona, Integer idPersonaRelacion, RelacionDTO relacionDTO) {
        if (!relacionDTO.getRelacion().equals(RelacionEnum.PADRE))
            throw new RelacionNotAllowedException();

        PersonaDTO personaDTO = personaService.obtenerPersona(idPersona);
        PersonaDTO personaRelacionDTO = personaService.obtenerPersona(idPersonaRelacion);

        Relacion relacionPadre = new Relacion(null, Mappers.getMapper(PersonaMapper.class).personaDTOtoPersona(personaDTO), relacionDTO.getRelacion(), Mappers.getMapper(PersonaMapper.class).personaDTOtoPersona(personaRelacionDTO));
        relacionPadre = repository.save(relacionPadre);
        Relacion relacionHijo = new Relacion(null, Mappers.getMapper(PersonaMapper.class).personaDTOtoPersona(personaRelacionDTO), RelacionEnum.HIJO, Mappers.getMapper(PersonaMapper.class).personaDTOtoPersona(personaDTO));
        repository.save(relacionHijo);
        return Mappers.getMapper(RelacionMapper.class).relacionToRelacionDTO(relacionPadre);
    }

    @Override
    public RelacionEnum obtenerRelacion(Integer idPersonaUno, Integer idPersonaDos) {
        personaService.obtenerPersona(idPersonaUno);
        personaService.obtenerPersona(idPersonaDos);

        return repository.getRelacion(idPersonaUno, idPersonaDos);
    }
}
