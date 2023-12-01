package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.Tratamento;
import com.vet.model.impl.table.TratamentoTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;

import com.vet.DAO.impl.TratamentoDAO;

public class TratamentoTableModel extends TableModel {

    public TratamentoTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Data início", "Data fim", "Animal", "Cliente"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TratamentoTable tratamento = (TratamentoTable) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> tratamento.getId();
            case 1 -> tratamento.getDataInicio();
            case 2 -> tratamento.getDataFim();
            case 3 -> tratamento.getAnimal();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        standardAddItem(TratamentoDAO.buildTratamentoTableFromTratamento((Tratamento) model));
    }
}
