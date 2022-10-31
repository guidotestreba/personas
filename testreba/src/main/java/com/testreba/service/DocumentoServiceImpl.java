package com.testreba.service;

import com.testreba.exception.DocumentoNotFoundException;
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

    @Autowired
    private DocumentoRepository repository;

    @Override
    public DocumentoDTO obtenerDocumento(Integer id) {
        Documento documento = repository.findById(id).orElseThrow(() -> new DocumentoNotFoundException());
        return Mappers.getMapper(DocumentoMapper.class).documentoToDocumentoDTO(documento);
    }
}
