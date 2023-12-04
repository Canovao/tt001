package com.vet.view.table;

import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.AnimalTable;
import com.vet.model.impl.table.ConsultaTable;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


public abstract class TableModel extends AbstractTableModel {
    protected List<Model> vDados;
    protected String[] colunas;

    private static boolean orderByTerminado = false;

    public TableModel(List<Model> vDados, String[] colunas) {
        this.colunas = colunas;
        this.vDados = vDados;
    }

    public static void addConsultaOrderByTerminado() {
        orderByTerminado = true;
    }

    public static void removeConsultaOrderByTerminado() {
        orderByTerminado = false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return vDados.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    }

    public abstract void addItem(Model model);

    public void standardAddItem(Model obj) {
        vDados.add(obj);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }

    public void addListOfItems(List<Model> itens) {
        this.clear();

        if(!itens.isEmpty() && itens.get(0) instanceof ConsultaTable){
            List<Model> ordered = itens.stream()
                .sorted(Comparator.comparing(model -> ((ConsultaTable) model).getDataConsulta()).reversed())
                .toList();

            for (Model item : ordered){
                this.addItem(item);
            }
        } else if (!itens.isEmpty() && itens.get(0) instanceof Consulta) {
            List<Model> ordered = itens.stream()
                    .sorted(Comparator.comparing(model -> ((Consulta) model).getDataConsulta()).reversed())
                    .toList();
            if(orderByTerminado){
                ordered = ordered.stream()
                        .sorted(Comparator.comparing(model -> ((Consulta) model).getTerminado()).reversed())
                        .toList();
            } else {
                ordered = ordered.stream()
                        .sorted(Comparator.comparing(model -> ((Consulta) model).getTerminado()))
                        .toList();
            }

            for (Model item : ordered){
                this.addItem(item);
            }
        }else if (!itens.isEmpty() && itens.get(0) instanceof ConsultaTable) {
            List<Model> ordered = itens.stream()
                    .sorted(Comparator.comparing(model -> ((ConsultaTable) model).getDataConsulta()).reversed())
                    .toList();

            if(orderByTerminado){
                ordered = ordered.stream()
                        .sorted(Comparator.comparing(model -> ((ConsultaTable) model).getTerminado()).reversed())
                        .toList();
            } else {
                ordered = ordered.stream()
                        .sorted(Comparator.comparing(model -> ((ConsultaTable) model).getTerminado()))
                        .toList();
            }

            for (Model item : ordered){
                this.addItem(item);
            }
        } else if (!itens.isEmpty() && itens.get(0) instanceof Cliente) {
            List<Model> ordered = itens.stream()
                    .sorted(Comparator.comparing(model -> ((Cliente) model).getAtivo()).reversed())
                    .toList();

            for (Model item : ordered){
                this.addItem(item);
            }
        } else if (!itens.isEmpty() && itens.get(0) instanceof Veterinario) {
            List<Model> ordered = itens.stream()
                    .sorted(Comparator.comparing(model -> ((Veterinario) model).getAtivo()).reversed())
                    .toList();

            for (Model item : ordered){
                this.addItem(item);
            }
        } else if ((!itens.isEmpty() && itens.get(0) instanceof Animal) ||
                (!itens.isEmpty() && itens.get(0) instanceof AnimalTable)
        ) {
            List<Model> ordered = itens.stream()
                    .sorted(Comparator.comparing(model -> ((Animal) model).getAtivo()).reversed())
                    .toList();

            for (Model item : ordered){
                this.addItem(item);
            }
        } else {
            for (Model item : itens){
                this.addItem(item);
            }
        }
    }

    public void clear() {
        vDados.clear();
        fireTableDataChanged();
    }
}
