package com.vet.model.impl.table;

import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class ConsultaTable extends Model {
    private int id;
    private Date dataConsulta;
    private String relato;
    private String veterinario;
    private int idTratamento;

    @Override
    public String toString() {
        return "ConsultaTable{" +
                "id=" + id +
                ", dataConsulta=" + dataConsulta +
                ", relato='" + relato + '\'' +
                ", veterinario='" + veterinario + '\'' +
                ", idTratamento=" + idTratamento +
                '}';
    }
}
