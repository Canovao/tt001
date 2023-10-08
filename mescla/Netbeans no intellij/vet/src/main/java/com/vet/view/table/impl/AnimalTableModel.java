package com.vet.view.table.impl;

import com.vet.DAO.impl.ClienteDAO;
import com.vet.DAO.impl.EspecieDAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;
import com.vet.model.impl.Especie;
import com.vet.model.impl.table.AnimalTable;
import com.vet.view.table.TableModel;

import java.util.List;

public class AnimalTableModel extends TableModel {

    public AnimalTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Nome", "Idade", "Sexo", "Espécie", "Tutor"});
    }

    private String getEspecieNomeFromAnimal(Animal animal){
        return ((Especie) EspecieDAO.getInstance().get(animal.getIdEspecie())).getNome();
    }

    private String getClienteNomeFromAnimal(Animal animal){
        return ((Cliente) ClienteDAO.getInstance().get(animal.getIdCliente())).getNome();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Animal animal = (Animal) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> animal.getId();
            case 1 -> animal.getNome();
            case 2 -> animal.getIdade();
            case 3 -> animal.getSexo();
            case 4 -> getEspecieNomeFromAnimal(animal);
            case 5 -> getClienteNomeFromAnimal(animal);
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        Animal animal = (Animal) model;
        standardAddItem(new AnimalTable(
                animal.getId(),
                animal.getNome(),
                animal.getIdade(),
                animal.getSexo(),
                getEspecieNomeFromAnimal(animal),
                getClienteNomeFromAnimal(animal)
        ));
    }
}
