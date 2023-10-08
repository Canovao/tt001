package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Especie;
import com.vet.model.impl.Tratamento;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EspecieDAO extends DAO {
    private static DAO instance = null;

    public static DAO getInstance(){
        if(instance == null){
            instance = new EspecieDAO();
        }
        return instance;
    }

    public Model insert(String nome) {
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

    public List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM especie WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "especie");
    }

    @Override
    public void update(Model model) {
        Especie especie = (Especie) model;
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE especie SET nome=? WHERE id=?");
            stmt.setString(1, especie.getNome());
            stmt.setInt(2, especie.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Especie(rs.getInt("id"), rs.getString("nome"));
    }
}
