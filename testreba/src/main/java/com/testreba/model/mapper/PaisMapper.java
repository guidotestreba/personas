package com.testreba.model.mapper;

import com.testreba.model.Pais;
import com.testreba.model.dto.PaisDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaisMapper {
    @Mapping(source = "pais.idPais", target = "idPais")
    @Mapping(source = "pais.pais", target = "pais")
    PaisDTO paisToPaisDTO(Pais pais);

    @Mapping(source = "paisDTO.idPais", target = "idPais")
    @Mapping(source = "paisDTO.pais", target = "pais")
    Pais paisDTOtoPais(PaisDTO paisDTO);
}
