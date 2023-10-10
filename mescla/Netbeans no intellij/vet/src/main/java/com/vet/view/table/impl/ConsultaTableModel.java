package com.vet.view.table.impl;

import com.vet.DAO.impl.VeterinarioDAO;
import com.vet.model.Model;
import com.vet.model.impl.Consulta;
import com.vet.model.impl.Veterinario;
import com.vet.model.impl.table.ConsultaTable;
import com.vet.view.table.TableModel;

import java.util.ArrayList;
import java.util.List;

public class ConsultaTableModel extends TableModel {

    public ConsultaTableModel(List<Model> vDados) {
        super(vDados, new String[]{"Id", "Data", "Relato", "Veterinário", "Tratamento"});
    }

    public ConsultaTableModel() {
        super(new ArrayList<>(), new String[]{"Id", "Data", "Relato", "Veterinário", "Tratamento"});
    }

    private String getVeterinarioNomeFromConsulta(Consulta consulta){
        return ((Veterinario) VeterinarioDAO.getInstance().get(consulta.getIdVeterinario())).getNome();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Consulta consulta = (Consulta) vDados.get(rowIndex);

        return switch (columnIndex) {
            case 0 -> consulta.getId();
            case 1 -> consulta.getDataConsulta();
            case 2 -> consulta.getRelato();
            case 3 -> getVeterinarioNomeFromConsulta(consulta);
            case 4 -> consulta.getIdTratamento();
            default -> throw new IndexOutOfBoundsException("columnIndex out of bounds");
        };
    }

    @Override
    public void addItem(Model model) {
        Consulta consulta = (Consulta) model;
        standardAddItem(new ConsultaTable(
                consulta.getId(),
                consulta.getDataConsulta(),
                consulta.getRelato(),
                getVeterinarioNomeFromConsulta(consulta),
                consulta.getIdTratamento()
        ));
    }
}
