package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.table.AnimalTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;

import com.vet.DAO.impl.AnimalDAO;

public class AnimalTableModel extends TableModel {

    public AnimalTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Nome", "Ano de nascimento", "Sexo", "Espécie", "Tutor", "Ativo"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AnimalTable animal = (AnimalTable) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> animal.getId();
            case 1 -> animal.getNome();
            case 2 -> animal.getAnoNascimento();
            case 3 -> animal.getSexo();
            case 4 -> animal.getEspecie();
            case 5 -> animal.getCliente();
            case 6 -> animal.getAtivo();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        standardAddItem(AnimalDAO.buildAnimalTableFromAnimal((Animal) model));
    }
}
