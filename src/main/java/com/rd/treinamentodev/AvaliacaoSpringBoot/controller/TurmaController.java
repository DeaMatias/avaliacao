package com.rd.treinamentodev.AvaliacaoSpringBoot.controller;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class TurmaController {

    @Autowired
    private TurmaService service;

    @GetMapping("/turmas")
    public ResponseEntity listar(){
        return ResponseEntity.ok().body(service.listar());
    }
    @GetMapping("/turmas")
    public ResponseEntity listar(@PathParam("id") Long id){
        List<TurmaDTO> listDTO = service.listar();
        return ResponseEntity.status(HttpStatus.OK).body(listDTO);
    }
}
