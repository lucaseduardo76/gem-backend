package com.cadastroGem.gem.entities;

import com.cadastroGem.gem.enums.CategoriaInstrumento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_instrumento")
public class Instrumento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private CategoriaInstrumento categoriaInstrumento;

    @JsonIgnore
    @OneToMany(mappedBy = "instrumento")
    private List<Pessoa> pessoa = new ArrayList<>();


}
