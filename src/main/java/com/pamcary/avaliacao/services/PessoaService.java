package com.pamcary.avaliacao.services;

import com.pamcary.avaliacao.dto.PessoaForm;
import com.pamcary.avaliacao.model.Pessoa;
import com.pamcary.avaliacao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public void cadastrar(PessoaForm pessoaForm) {
       Pessoa pessoa = new Pessoa(pessoaForm.getCpf(), pessoaForm.getNome(), pessoaForm.getDataNascimento());
       pessoaRepository.save(pessoa);
    }
    
}
