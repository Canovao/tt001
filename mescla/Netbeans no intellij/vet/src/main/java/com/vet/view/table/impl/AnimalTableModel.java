package com.vet.view.table.impl;

import com.vet.model.impl.Animal;
import com.vet.view.table.TableModel;

import java.util.List;

public class AnimalTableModel extends TableModel {

    public AnimalTableModel(List<Object> vDados) {
        super(vDados, new String[]{"Id", "Nome", "Idade", "Sexo", "Espécie", "Tutor"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal client = (Animal) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> client.getId();
            case 1 -> client.getNome();
            case 2 -> client.getIdade();
            case 3 -> client.getSexo();
            case 4 -> client.getIdEspecie(); // TODO refatorar para retornar nome da espécie
            case 5 -> client.getIdCliente(); // TODO refatorar para retornar o nome do Cliente
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Object obj) {

    }
}
