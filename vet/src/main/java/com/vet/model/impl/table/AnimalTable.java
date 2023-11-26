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
    private int anoNascimento;
    private String sexo;
    private String especie;
    private String cliente;
    private String ativo;

    @Override
    public String toString() {
        return "AnimalTable{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", sexo='" + sexo + '\'' +
                ", especie='" + especie + '\'' +
                ", cliente='" + cliente + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
