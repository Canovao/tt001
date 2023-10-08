package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.Veterinario;
import com.vet.view.table.TableModel;

import java.util.List;

public class VeterinarioTableModel extends TableModel {

    public VeterinarioTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Telefone"});
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veterinario veterinario = (Veterinario) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> veterinario.getId();
            case 1 -> veterinario.getNome();
            case 2 -> veterinario.getEndereco();
            case 3 -> veterinario.getCep();
            case 4 -> veterinario.getEmail();
            case 5 -> veterinario.getTelefone();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        standardAddItem(obj);
    }
}
