package com.vet.model.impl;


import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class Tratamento extends Model {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private int idAnimal;

    @Override
    public String toString() {
        return "Tratamento{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", idAnimal=" + idAnimal +
                '}';
    }
}
