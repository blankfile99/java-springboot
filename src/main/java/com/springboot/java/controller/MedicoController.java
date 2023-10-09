package com.springboot.java.controller;

import com.springboot.java.medico.Medico;
import com.springboot.java.medico.MedicoRepository;
import com.springboot.java.medico.MedicosDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;
    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicosDTO dados){
        repository.save(new Medico(dados));
    }
}
