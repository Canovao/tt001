package com.vet.view.table.impl;

import com.vet.DAO.impl.ConsultaDAO;
import com.vet.DAO.impl.EspecieDAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Consulta;
import com.vet.model.impl.Especie;
import com.vet.model.impl.Exame;
import com.vet.view.table.TableModel;

import java.util.ArrayList;
import java.util.List;

public class ExameTableModel extends TableModel {

    public ExameTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Descrição", "Relato Consulta"});
    }

    public ExameTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Descrição", "Relato Consulta"});
    }

    private String getConsultaRelatoFromExame(Exame exame){
        return ((Consulta) ConsultaDAO.getInstance().get(exame.getIdConsulta())).getRelato();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Exame exame = (Exame) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> exame.getId();
            case 1 -> exame.getDescricao();
            case 2 -> getConsultaRelatoFromExame(exame);
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        standardAddItem(obj);
    }
}
