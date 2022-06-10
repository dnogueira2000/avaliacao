package com.pamcary.avaliacao.controller;

import com.pamcary.avaliacao.dto.PessoaForm;
import com.pamcary.avaliacao.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    public ResponseEntity<String> salvarPessoa(@Valid @RequestBody PessoaForm pessoaForm,
                                          HttpServletRequest request) throws Exception {

        pessoaService.cadastrar(pessoaForm);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa criada com sucesso");
    }

}
