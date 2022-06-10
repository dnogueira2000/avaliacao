package com.pamcary.avaliacao.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
}
