package com.vet.view.table;

import com.vet.model.Model;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;


public abstract class TableModel extends AbstractTableModel {
    protected List<Model> vDados;
    protected String[] colunas;

    public TableModel(List<Model> vDados, String[] colunas) {
        this.colunas = colunas;
        this.vDados = vDados;
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
        for (Model item : itens){
            this.addItem(item);
        }
    }

    public void clear() {
        vDados.clear();
        fireTableDataChanged();
    }
}
