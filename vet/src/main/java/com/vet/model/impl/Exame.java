package com.vet.model.impl;


import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Exame extends Model {
    private int id;
    private String descricao;
    private int idConsulta;

    @Override
    public String toString() {
        return "Exame{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", idConsulta=" + idConsulta +
                '}';
    }
}
