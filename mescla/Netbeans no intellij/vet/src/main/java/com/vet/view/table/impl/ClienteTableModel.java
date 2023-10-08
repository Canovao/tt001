package com.vet.view.table.impl;

import java.util.List;

import com.vet.DAO.impl.ClienteDAO;
import com.vet.model.impl.Cliente;
import com.vet.view.table.TableModel;

public class ClienteTableModel extends TableModel {

    public ClienteTableModel(List<Object> vDados) {
        super(vDados, new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Celular"});
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0, 1, 2, 3, 4, 5 -> String.class;
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente client = (Cliente) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> client.getId();
            case 1 -> client.getNome();
            case 2 -> client.getEndereco();
            case 3 -> client.getCep();
            case 4 -> client.getEmail();
            case 5 -> client.getTelefone();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }    

    // Substitua todas as telas de atualizar para que atualize usando esse método editando direto na tabela
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cliente client = (Cliente) vDados.get(rowIndex);

        switch (columnIndex) {
            case 1 -> client.setNome((String) aValue);
            case 2 -> client.setEndereco((String) aValue);
            case 3 -> client.setCep((String) aValue);
            case 4 -> client.setEmail((String) aValue);
            case 5 -> client.setTelefone((String) aValue);
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }

        ClienteDAO.getInstance().update(client);
    }
}
