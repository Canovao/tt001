package com.vet.view.table.impl;

import java.util.ArrayList;
import java.util.List;

import com.vet.model.Model;
import com.vet.model.impl.Cliente;
import com.vet.view.table.TableModel;

public class ClienteTableModel extends TableModel {

    public ClienteTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Telefone", "Ativo"});
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
            case 6 -> cliente.getAtivo();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        Cliente cliente = (Cliente) obj;
        cliente.setAtivo((cliente.getAtivo().equalsIgnoreCase("1")) ? "Sim": "Não");
        standardAddItem(obj);
    }
}
