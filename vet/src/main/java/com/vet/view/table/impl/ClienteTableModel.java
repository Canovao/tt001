package com.vet.view.table.impl;

import java.util.ArrayList;
import java.util.List;

import com.vet.model.Model;
import com.vet.model.impl.Cliente;
import com.vet.view.table.TableModel;

public class ClienteTableModel extends TableModel {

    public ClienteTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Telefone"});
    }

    public ClienteTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Telefone"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = (Cliente) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> cliente.getId();
            case 1 -> cliente.getNome();
            case 2 -> cliente.getEndereco();
            case 3 -> cliente.getCep();
            case 4 -> cliente.getEmail();
            case 5 -> cliente.getTelefone();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        standardAddItem(obj);
    }
}
