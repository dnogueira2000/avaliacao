package com.pamcary.avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pamcary.avaliacao.model.Pessoa;
import com.pamcary.avaliacao.repository.PessoaRepository;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class PessoaForm {

    @NotNull
    @Size(min = 2, max = 60, message = "Campo deve conter no minimo 2 caracteres e no máximo 60 caracteres")
    private String nome;

    @NotNull
    @Size(min = 11, max = 11, message = "Campo deve conter 11 caracteres")
    private String cpf;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull
    private LocalDate dataNascimento;


    public Pessoa atualizar(Long id, PessoaRepository pessoaRepository) {
        Pessoa pessoa = pessoaRepository.getOne(id);

        //atualiza com o que veio do form
        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setDataNascimento(this.dataNascimento);

        return pessoa;
    }
}
