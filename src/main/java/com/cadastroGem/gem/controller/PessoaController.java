package com.cadastroGem.gem.controller;


import com.cadastroGem.gem.entities.Pessoa;
import com.cadastroGem.gem.requests.PessoaPostRequestBody;
import com.cadastroGem.gem.requests.PessoaPutRequestBody;
import com.cadastroGem.gem.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/pessoa")
@RequiredArgsConstructor
public class PessoaController {


    private final PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll() {
        return ResponseEntity.ok().body(pessoaService.findALl());
    }

    @GetMapping(value = "/findById")
    public ResponseEntity<Pessoa> findById(@RequestParam Long id) {
        return ResponseEntity.ok().body(pessoaService.findById(id));
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Pessoa> add(@RequestBody PessoaPostRequestBody pessoaPostRequestBody) {
        Pessoa pessoa = pessoaService.post(pessoaPostRequestBody);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pessoa.getId())
                .toUri();

        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping(value = "/edit")
    public ResponseEntity<Pessoa> edit(@RequestParam Long id, @RequestBody PessoaPutRequestBody pessoaPutRequestBody) {
        Pessoa pessoa = pessoaService.replace(id, pessoaPutRequestBody);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "delete")
    public ResponseEntity<Pessoa> delete(@RequestParam Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
