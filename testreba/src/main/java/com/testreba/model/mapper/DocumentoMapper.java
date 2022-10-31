package com.testreba.model.mapper;

import com.testreba.model.Documento;
import com.testreba.model.dto.DocumentoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {
    @Mapping(source = "documento.idDocumento", target = "idDocumento")
    @Mapping(source = "documento.nroDocumento", target = "nroDocumento")
    @Mapping(source = "documento.tipoDocumento" ,target = "tipoDocumento")
    DocumentoDTO documentoToDocumentoDTO(Documento documento);

    @Mapping(source = "documentoDTO.idDocumento", target = "idDocumento")
    @Mapping(source = "documentoDTO.nroDocumento", target = "nroDocumento")
    @Mapping(source = "documentoDTO.tipoDocumento" ,target = "tipoDocumento")
    Documento documentoDTOtoDocumento(DocumentoDTO documentoDTO);
}
