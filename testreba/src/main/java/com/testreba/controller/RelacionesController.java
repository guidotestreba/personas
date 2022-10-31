package com.testreba.controller;

import com.testreba.exception.PersonaNotFoundException;
import com.testreba.service.RelacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RelacionesController {

    @Autowired
    private RelacionService relacionService;

    @GetMapping("/relaciones/{id1}/{id2}")
    public ResponseEntity obtenerRelacion(@PathVariable("id1") Integer idPersonaUno, @PathVariable("id2") Integer idPersonaDos) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(relacionService.obtenerRelacion(idPersonaUno, idPersonaDos));
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
