package com.cadastroGem.gem.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PessoaPostRequestBody {
    private String nome;
    private Long instrumentoId;
}
