package com.vet.view.table.impl;

import com.vet.DAO.impl.ConsultaDAO;
import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.ExameTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;

import com.vet.DAO.impl.ExameDAO;

public class ExameTableModel extends TableModel {

    public ExameTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Descrição", "Cliente", "Animal", "Veterinario", "Relato Consulta"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ExameTable exame = (ExameTable) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> exame.getId();
            case 1 -> exame.getDescricao();
            case 2 -> exame.getCliente();
            case 3 -> exame.getAnimal();
            case 4 -> exame.getVeterinario();
            case 5 -> exame.getRelatoConsulta();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        try{
            standardAddItem(ExameDAO.buildExameTableFromExame((Exame) model));
        } catch (ClassCastException e){
            standardAddItem(model);
        }
    }
}
