package com.springboot.java.medico;

import com.springboot.java.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record MedicosAtualizarDTO(
        @NotNull
        Long id,
        String telefone,
        DadosEndereco endereco
) {
}
