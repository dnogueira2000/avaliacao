package com.pamcary.avaliacao.controller;

import com.pamcary.avaliacao.dto.PessoaForm;
import com.pamcary.avaliacao.model.Pessoa;
import com.pamcary.avaliacao.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping()
    public ResponseEntity<String> salvarPessoa(@RequestBody PessoaForm pessoaForm,
                                          HttpServletRequest request) throws Exception {

        pessoaService.cadastrar(pessoaForm);

        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa criada com sucesso");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarPessoa(@PathVariable("id") Long id) {
        boolean exclui = pessoaService.excluir(id);

        if(exclui) {
            return ResponseEntity.ok().build();
        }

        return new ResponseEntity("ID nao encontrado", HttpStatus.NOT_ACCEPTABLE);
    }

    @GetMapping
    public Page<Pessoa> listarPessoas(@RequestParam(required = false) String cpf,
                                      @PageableDefault(sort = "codigo", direction = Sort.Direction.DESC)
                                      Pageable paginacao) {

        return pessoaService.listar(cpf, paginacao);

    }


}
