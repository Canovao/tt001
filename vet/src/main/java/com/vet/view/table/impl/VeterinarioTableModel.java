package com.vet.view.table.impl;

import com.vet.model.Model;
import com.vet.model.impl.Veterinario;
import com.vet.view.table.TableModel;

import java.util.ArrayList;
import java.util.List;

public class VeterinarioTableModel extends TableModel {

    public VeterinarioTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Nome", "Endereço", "CEP", "Email", "Telefone", "Ativo"});
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
            case 6 -> veterinario.getAtivo();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model obj) {
        Veterinario veterinario = (Veterinario) obj;
        veterinario.setAtivo((veterinario.getAtivo().equalsIgnoreCase("1")) ? "Sim": "Não");
        standardAddItem(obj);
    }
}
