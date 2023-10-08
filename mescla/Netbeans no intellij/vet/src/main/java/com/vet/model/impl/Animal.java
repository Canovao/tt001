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
    private int idade;
    private String sexo;
    private int idEspecie;
    private int idCliente;

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", idEspecie=" + idEspecie +
                ", idCliente=" + idCliente +
                '}';
    }
}
