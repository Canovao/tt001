package com.vet.model.impl.table;

import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExameTable extends Model {
    private int id;
    private String descricao;
    private String cliente;
    private String animal;
    private String veterinario;
    private String relatoConsulta;

    @Override
    public String toString() {
        return "ExameTable{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", cliente='" + cliente + '\'' +
                ", animal='" + animal + '\'' +
                ", veterinario='" + veterinario + '\'' +
                ", relatoConsulta='" + relatoConsulta + '\'' +
                '}';
    }
}
