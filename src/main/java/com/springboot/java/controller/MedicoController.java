package com.springboot.java.controller;

import com.springboot.java.medico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody @Valid MedicosDTO dados) {
        repository.save(new Medico(dados));
    }

    @Transactional
    @PutMapping
    public void atualizar(@RequestBody @Valid MedicosAtualizarDTO dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    }

    //Listagem normal que mostra todos os registros
    
//    @GetMapping
//    public List<Medico> listarTudo(){
//        return repository.findAll();
//    }


    //Lista medicos e apresenta apenas dados solicitados com um construtor MedicosListarDTO
//    @GetMapping
//    public List<MedicosListarDTO> listar() {
//        return repository.findAll().stream().map(MedicosListarDTO::new).toList();
//    }

    //Lista com paginacao
    @GetMapping
    public Page<MedicosListarDTO> listar(@PageableDefault(size=10, sort = {"nome"}) Pageable pageable) {
        //return repository.findAll(pageable).map(MedicosListarDTO::new);
        return repository.findAllByAtivoTrue(pageable).map(MedicosListarDTO::new);
    }

    //DELETA o registro do Banco
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        //repository.deleteById(id); //deleta registro
        var medico = repository.getReferenceById(id); //inativa o medico em vez de excluir
        medico.excluir();
    }

}
