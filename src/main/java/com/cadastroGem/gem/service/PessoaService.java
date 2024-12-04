package com.cadastroGem.gem.service;

import com.cadastroGem.gem.entities.Pessoa;
import com.cadastroGem.gem.mapper.PessoaMapper;
import com.cadastroGem.gem.repository.PessoaRepository;
import com.cadastroGem.gem.requests.PessoaPostRequestBody;
import com.cadastroGem.gem.requests.PessoaPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {

    @Autowired
    private final PessoaRepository pessoaRepository;

    private final InstrumentoService instrumentoService;

    public List<Pessoa> findALl(){
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Long id){
        return pessoaRepository
                .findById(id)
                .orElseThrow();
    }

    public void delete(Long id){
        pessoaRepository.delete(findById(id));
    }

    public Pessoa replace(Long id, PessoaPutRequestBody pessoaPutRequestBody){
        Pessoa savedPessoa = findById(id);
        Pessoa pessoa = PessoaMapper.INSTANCE.putToPessoa(pessoaPutRequestBody);
        pessoa.setId(savedPessoa.getId());
        return pessoaRepository.save(pessoa);
    }

    public Pessoa post(PessoaPostRequestBody pessoaPostRequestBody){

        return pessoaRepository.save(PessoaMapper.INSTANCE.postToPessoa(pessoaPostRequestBody));
    }


}
