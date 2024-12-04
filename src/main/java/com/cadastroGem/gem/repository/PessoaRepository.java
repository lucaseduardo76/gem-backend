package com.cadastroGem.gem.repository;


import com.cadastroGem.gem.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
