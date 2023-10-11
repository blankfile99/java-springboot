package com.springboot.java.medico;

public record MedicosListarDTO(Long id, String nome, String telefone, String email, String crm, Especialidade especialidade){
    public MedicosListarDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getTelefone(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
