package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping("/aluno")
    public ResponseEntity gravar(@RequestBody AlunoDTO alunoDTO){

        List<AlunoEntity> alunos = alunoRepository.findByCpf(alunoDTO.getCpf());
        if(alunoDTO.getCpf().equals(alunos))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado");

         return alunoService.gravar(alunoDTO);
    }
}
