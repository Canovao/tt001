package com.vet.model.impl.table;

import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class TratamentoTable extends Model {
    private int id;
    private Date dataInicio;
    private Date dataFim;
    private String animal;
    private String cliente;

    @Override
    public String toString() {
        return "TratamentoTable{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", animal='" + animal + '\'' +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}
