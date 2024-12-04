package com.cadastroGem.gem.service;


import com.cadastroGem.gem.entities.Instrumento;
import com.cadastroGem.gem.repository.InstrumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InstrumentoService {

    private InstrumentoRepository instrumentoRepository;

    public Instrumento FindByIdOrElseThrowBadRequest(Long id) {
        return instrumentoRepository.findById(id).orElseThrow();
    }

    public Instrumento save(Instrumento instrumento) {
        return instrumentoRepository.save(instrumento);
    }

}
