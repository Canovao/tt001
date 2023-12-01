package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.ConsultaTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;

import com.vet.DAO.impl.ConsultaDAO;

public class ConsultaTableModel extends TableModel {

    public ConsultaTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Data", "Horário", "Relato", "Cliente", "Animal", "Veterinário", "Tratamento", "Terminado"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ConsultaTable consulta = (ConsultaTable) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> consulta.getId();
            case 1 -> consulta.getDataConsulta();
            case 2 -> consulta.getHorario();
            case 3 -> consulta.getRelato();
            case 4 -> consulta.getCliente();
            case 5 -> consulta.getAnimal();
            case 6 -> consulta.getVeterinario();
            case 7 -> consulta.getIdTratamento();
            case 8 -> consulta.getTerminado();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        standardAddItem(ConsultaDAO.buildConsultaTableFromConsulta((Consulta) model));
    }
}
