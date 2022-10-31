package com.testreba.service;

import com.testreba.exception.PaisNotFoundException;
import com.testreba.model.Documento;
import com.testreba.model.dto.DocumentoDTO;
import com.testreba.model.mapper.DocumentoMapper;
import com.testreba.repository.DocumentoRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentoServiceImpl implements DocumentoService {
    private static final String DOCUMENTO_NOT_FOUND = "Documento no encontrado";

    @Autowired
    private DocumentoRepository repository;

    @Override
    public DocumentoDTO obtenerDocumento(Integer id) {
        Documento documento = repository.findById(id).orElseThrow(() -> new PaisNotFoundException(DOCUMENTO_NOT_FOUND));
        return Mappers.getMapper(DocumentoMapper.class).documentoToDocumentoDTO(documento);
    }
}
