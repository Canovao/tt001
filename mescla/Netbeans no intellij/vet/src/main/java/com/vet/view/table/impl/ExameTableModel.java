package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.Exame;
import com.vet.view.table.TableModel;

import java.util.List;

public class ExameTableModel extends TableModel {

    public ExameTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Descrição", "Consulta"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> exame.getId();
            case 1 -> exame.getDescricao();
            case 2 -> exame.getIdConsulta();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        standardAddItem(obj);
    }
}
