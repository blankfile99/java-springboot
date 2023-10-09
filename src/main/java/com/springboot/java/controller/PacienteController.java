package com.springboot.java.controller;

import com.springboot.java.paciente.Paciente;
import com.springboot.java.paciente.PacienteRepository;
import com.springboot.java.paciente.PacientesDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

