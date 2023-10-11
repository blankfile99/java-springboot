package com.springboot.java.paciente;

import com.springboot.java.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;


public record PacienteAtualizarDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
