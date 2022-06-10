package com.pamcary.avaliacao.repository;

import com.pamcary.avaliacao.model.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Page<Pessoa> findByCpf(@Param("cpf") String cpf, Pageable paginacao);

}
