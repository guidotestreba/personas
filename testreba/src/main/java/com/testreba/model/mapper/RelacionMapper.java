package com.testreba.model.mapper;

import com.testreba.model.Relacion;
import com.testreba.model.dto.RelacionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RelacionMapper {
    @Mapping(source = "relacion.idRelacion", target = "idRelacion")
    @Mapping(source = "relacion.persona", target = "persona")
    @Mapping(source = "relacion.relacion", target = "relacion")
    @Mapping(source = "relacion.personaRelacion", target = "personaRelacion")
    RelacionDTO relacionToRelacionDTO(Relacion relacion);

}
