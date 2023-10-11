package com.springboot.java.paciente;

public record PacientesListarDTO(Long id, String nome, String telefone, String cpf) {

    public PacientesListarDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getCpf());
    }
}
