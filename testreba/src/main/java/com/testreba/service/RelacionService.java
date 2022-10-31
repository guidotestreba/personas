package com.testreba.service;

import com.testreba.model.RelacionEnum;
import com.testreba.model.dto.RelacionDTO;

public interface RelacionService {
    RelacionDTO guardarPadre(Integer idPersona, Integer idPersonaRelacion, RelacionDTO relacionDTO);

    RelacionEnum obtenerRelacion(Integer idPersonaUno, Integer idPersonaDos);
}
