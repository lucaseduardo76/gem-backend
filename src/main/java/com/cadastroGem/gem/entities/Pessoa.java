package com.cadastroGem.gem.entities;

import com.cadastroGem.gem.enums.CategoriaInstrumento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Objects;


@Entity
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@Table(name = "tb_pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Instrumento instrumento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
