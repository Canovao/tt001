package com.vet.view.table.impl;

import com.vet.model.impl.Consulta;
import com.vet.view.table.TableModel;

import java.util.List;

public class ConsultaTableModel extends TableModel {

    public ConsultaTableModel(List<Object> vDados) {
        super(vDados, new String[]{"Id", "Data", "Relato", "Veterinário", "Tratamento"});
    } // para veterinário fazer busca na tabela e retornar nome (Veterinário) ao invés do id, no tratamento pode ser o id mesmo

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> consulta.getId();
            case 1 -> consulta.getDataConsulta();
            case 2 -> consulta.getRelato();
            case 3 -> consulta.getIdVeterinario(); // TODO refatorar para voltar o nome do veterinario
            case 4 -> consulta.getIdTratamento();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }
}
