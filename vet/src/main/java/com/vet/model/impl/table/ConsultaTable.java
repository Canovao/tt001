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
    private int horario;
    private String relato;
    private String cliente;
    private String animal;
    private String veterinario;
    private int idTratamento;
    private String terminado;

    @Override
    public String toString() {
        return "ConsultaTable{" +
                "id=" + id +
                ", dataConsulta=" + dataConsulta +
                ", horario=" + horario +
                ", relato='" + relato + '\'' +
                ", cliente='" + cliente + '\'' +
                ", animal='" + animal + '\'' +
                ", veterinario='" + veterinario + '\'' +
                ", idTratamento=" + idTratamento +
                ", terminado='" + terminado + '\'' +
                '}';
    }
}
