package com.springboot.java.controller;

import com.springboot.java.paciente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid PacientesDTO dados) {
        repository.save(new Paciente(dados));
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid PacienteAtualizarDTO dados){
        var paciente = repository.getReferenceById(dados.id());

        paciente.atualizarInformacoes(dados);
    }

    //Listagem Simples
//    @GetMapping
//    public List<Paciente> listarTudo(){
//        return repository.findAll();
//    }

    //Listagem com DTO customizado que possibilita a listagem apenas dos dados requisitados
//    @GetMapping
//    public List<PacientesListarDTO> listar(){
//        return repository.findAll().stream().map(PacientesListarDTO::new).toList();
//    }

    //Listagem com paginação
    @GetMapping
    public Page<PacientesListarDTO> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(PacientesListarDTO::new);
    }


}

