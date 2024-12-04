package com.cadastroGem.gem.mapper;

import com.cadastroGem.gem.entities.Pessoa;
import com.cadastroGem.gem.requests.PessoaPostRequestBody;
import com.cadastroGem.gem.requests.PessoaPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PessoaMapper {
    public static final PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    public abstract Pessoa postToPessoa(PessoaPostRequestBody pessoaPostRequestBody);
    public abstract Pessoa putToPessoa(PessoaPutRequestBody pessoaPutRequestBody);
}
