package com.vet.view.table.impl;

import com.vet.model.impl.Consulta;
import com.vet.model.impl.Tratamento;
import com.vet.view.table.TableModel;

import java.util.List;

public class TratamentoTableModel extends TableModel {

    public TratamentoTableModel(List<Object> vDados) {
        super(vDados, new String[]{"Id", "Data início", "Data fim", "Animal"});
    } // para animal fazer busca na tabela e retornar nome (Animal) ao invés do id

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratamento tratamento = (Tratamento) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> tratamento.getId();
            case 1 -> tratamento.getDataInicio();
            case 2 -> tratamento.getDataFim();
            case 3 -> tratamento.getIdAnimal(); // TODO refatorar para voltar o nome do animal
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }
}
