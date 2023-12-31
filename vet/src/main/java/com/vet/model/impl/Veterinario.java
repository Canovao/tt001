package com.vet.model.impl;


import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Veterinario extends Model {
    private int id;
    private String nome;
    private String endereco;
    private String cep;
    private String email;
    private String telefone;

    @Override
    public String toString() {
        return "Veterinario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
