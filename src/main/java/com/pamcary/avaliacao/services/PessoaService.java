package com.pamcary.avaliacao.services;

import com.pamcary.avaliacao.dto.PessoaDTO;
import com.pamcary.avaliacao.dto.PessoaForm;
import com.pamcary.avaliacao.model.Pessoa;
import com.pamcary.avaliacao.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public void cadastrar(PessoaForm pessoaForm) {
       Pessoa pessoa = new Pessoa(pessoaForm.getNome(), pessoaForm.getCpf(), pessoaForm.getDataNascimento());
       pessoaRepository.save(pessoa);
    }

    @Transactional
    public boolean excluir(Long id) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);

        if(optional.isPresent()){
            pessoaRepository.deleteById(id);

            return true;
        }

        return false;
    }

    @Transactional
    public Page<PessoaDTO> listar(@RequestParam(required = false) String cpf,
                               @PageableDefault(sort = "codigo", direction = Sort.Direction.DESC)
                               Pageable paginacao) {

        Page<Pessoa> pessoas;
        if(Objects.isNull(cpf)) {
            pessoas = pessoaRepository.findAll(paginacao);
        } else {
            pessoas = pessoaRepository.findByCpf(cpf, paginacao);
        }

        Page<PessoaDTO> pessoaDTOS = pessoas.map((Pessoa pessoa) -> new PessoaDTO(
                pessoa.getCodigo(),
                pessoa.getNome(),
                pessoa.getCpf(),
                pessoa.getDataNascimento()
        ));

        return pessoaDTOS;

    }

    public PessoaDTO listarPorId(Long id) {

        Optional<Pessoa> optional = pessoaRepository.findById(id);

        if(optional.isPresent()) {
            PessoaDTO pessoaDTO = new PessoaDTO(
                    optional.get().getCodigo(),
                    optional.get().getNome(),
                    optional.get().getCpf(),
                    optional.get().getDataNascimento());
            return pessoaDTO;
        }

        return null;
    }

}
