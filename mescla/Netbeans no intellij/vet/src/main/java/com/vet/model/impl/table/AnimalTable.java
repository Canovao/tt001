package com.vet.model.impl.table;

import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AnimalTable extends Model {
    private int id;
    private String nome;
    private int idade;
    private String sexo;
    private String especie;
    private String cliente;

    @Override
    public String toString() {
        return "AnimalTable{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", sexo='" + sexo + '\'' +
                ", especie='" + especie + '\'' +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}
