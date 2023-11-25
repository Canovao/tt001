package com.vet.view.table.impl;

import com.vet.DAO.impl.AnimalDAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Tratamento;
import com.vet.model.impl.table.TratamentoTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;
import java.util.List;

public class TratamentoTableModel extends TableModel {

    public TratamentoTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Data início", "Data fim", "Animal"});
    }

    public TratamentoTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Data início", "Data fim", "Animal"});
    }

    private String getAnimalNomeFromTratamento(Tratamento tratamento){
        return ((Animal) AnimalDAO.getInstance().get(tratamento.getIdAnimal())).getNome();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> tratamento.getId();
            case 1 -> tratamento.getDataInicio();
            case 2 -> tratamento.getDataFim();
            case 3 -> getAnimalNomeFromTratamento(tratamento);
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        Tratamento tratamento = (Tratamento) model;
        standardAddItem(new TratamentoTable(
                tratamento.getId(),
                tratamento.getDataInicio(),
                tratamento.getDataFim(),
                getAnimalNomeFromTratamento(tratamento)
        ));
    }
}
