package com.vet.model.impl;


import com.vet.model.Model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
public class Consulta extends Model {
    private int id;
    private Date dataConsulta;
    private String relato;
    private int idVeterinario;
    private int idTratamento;

    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", data=" + dataConsulta +
                ", relato='" + relato + '\'' +
                ", idVeterinario=" + idVeterinario +
                ", idTratamento=" + idTratamento +
                '}';
    }
}
