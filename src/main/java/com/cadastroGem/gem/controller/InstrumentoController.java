package com.cadastroGem.gem.controller;

import com.cadastroGem.gem.entities.Instrumento;
import com.cadastroGem.gem.service.InstrumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/inst")
@RequiredArgsConstructor
public class InstrumentoController {

    private final InstrumentoService instrumentoService;


    @GetMapping
    public ResponseEntity<List<Instrumento>> getAll() {
        List<Instrumento> instrumentos = instrumentoService.findAll();
        return ResponseEntity.ok().body(instrumentos);
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<Instrumento> findById(@RequestParam Long id) {
        return ResponseEntity.ok().body(instrumentoService.FindByIdOrElseThrowBadRequest(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Instrumento> add(@RequestBody Instrumento instrumento) {
        instrumentoService.save(instrumento);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(instrumento.getId()).toUri();
        return ResponseEntity.created(uri).body(instrumento);
    }

}
