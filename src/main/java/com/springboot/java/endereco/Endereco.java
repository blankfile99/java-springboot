package com.springboot.java.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco dados) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizarDados(DadosEndereco dados) {
        if(dados.logradouro()!= null){
            this.logradouro = dados.logradouro();
        }
        if(dados.numero()!= null){
            this.numero = dados.numero();
        }
        if(dados.bairro()!= null){
            this.bairro = dados.bairro();
        }
        if(dados.cep()!= null){
            this.cep = dados.cep();
        }
        if(dados.cidade()!= null){
            this.cidade = dados.cidade();
        }
        if(dados.uf()!= null){
            this.uf = dados.uf();
        }

    }
}
