package com.cadastroGem.gem.service;


import com.cadastroGem.gem.entities.Instrumento;
import com.cadastroGem.gem.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstrumentoService {

    private final InstrumentoRepository instrumentoRepository;


    public List<Instrumento> findAll() {
        return instrumentoRepository.findAll();
    }

    public Instrumento FindByIdOrElseThrowBadRequest(Long id) {
        return instrumentoRepository.findById(id).orElseThrow();
    }

    public Instrumento save(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

}
