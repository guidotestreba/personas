package com.testreba.controller;

import com.testreba.exception.*;
import com.testreba.model.dto.PersonaDTO;
import com.testreba.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/personas")
    public ResponseEntity obtenerPersonas() {
        try {
            List<PersonaDTO> personas = personaService.obtenerPersonas();
            return ResponseEntity.status(HttpStatus.OK).body(personas);
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @GetMapping("/personas/{id}")
    public ResponseEntity obtenerPersonaPorId(@PathVariable("id") Integer id) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.obtenerPersona(id));
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PostMapping("/personas")
    public ResponseEntity guardarPersona(@RequestBody PersonaDTO personaDTO) {
        try {
            PersonaDTO persona = personaService
                    .guardarPersona(personaDTO);
            return new ResponseEntity<>(persona, HttpStatus.CREATED);
        } catch (PersonaDuplicateException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (PersonaEdadLessThanEightteenException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (PersonaContactException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @PatchMapping("/personas/{id}")
    public ResponseEntity actualizarPersona(@PathVariable("id") Integer id, @RequestBody PersonaDTO persona) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.actualizarPersona(id, persona));
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }

    @DeleteMapping("/personas/{id}")
    public ResponseEntity borrarPersona(@PathVariable("id") Integer id) {
        try {
            personaService.borrarPersona(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
        } catch (PersonaNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
        }
    }
}
