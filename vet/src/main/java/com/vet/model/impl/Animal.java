package com.vet.model.impl;


import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Animal extends Model {
    private int id;
    private String nome;
    private int anoNascimento;
    private String sexo;
    private int idEspecie;
    private int idCliente;
    private String ativo;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", sexo='" + sexo + '\'' +
                ", idEspecie=" + idEspecie +
                ", idCliente=" + idCliente +
                ", ativo=" + ativo +
                '}';
    }
}
