package com.testreba.service;

import com.testreba.exception.PaisNotFoundException;
import com.testreba.model.Pais;
import com.testreba.model.dto.PaisDTO;
import com.testreba.model.mapper.PaisMapper;
import com.testreba.repository.PaisRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {


    @Autowired
    private PaisRepository repository;


    @Override
    public PaisDTO obtenerPais(Integer id) {
        Pais pais = repository.findById(id).orElseThrow(() -> new PaisNotFoundException());
        return Mappers.getMapper(PaisMapper.class).paisToPaisDTO(pais);
    }
}
