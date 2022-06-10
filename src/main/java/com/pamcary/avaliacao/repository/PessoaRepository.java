package com.pamcary.avaliacao.repository;

import com.pamcary.avaliacao.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
}
