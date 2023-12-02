package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Especie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EspecieDAO extends DAO<Especie> {
    private static EspecieDAO instance = null;

    public static EspecieDAO getInstance(){
        if(instance == null){
            instance = new EspecieDAO();
        }
        return instance;
    }

    public static Model insert(String nome) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO especie (nome) VALUES (?)");
            stmt.setString(1, nome);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("especie", lastId("especie","id"));
    }

    public static void update(Especie model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE especie SET nome=? WHERE id=?");
            stmt.setString(1, model.getNome());
            stmt.setInt(2, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Especie get(int id) {
        return (Especie) DAO.retrieveById("especie", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Especie(rs.getInt("id"), rs.getString("nome"));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Especie> all = retrieve("SELECT * FROM especie", "especie").stream().map(Especie.class::cast).toList();

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Especie> especies) {
        String[] list = new String[especies.size()];

        for(int i=0; i < list.length; i++){
            list[i] = especies.get(i).getId() + "|" + especies.get(i).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("especie");
    }
}
