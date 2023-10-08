package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Tratamento;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TratamentoDAO extends DAO {
    private static DAO instance = null;

    public static DAO getInstance(){
        if(instance == null){
            instance = new TratamentoDAO();
        }
        return instance;
    }

    public Model insert(Date dataInicio, Date dataFim, int idAnimal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (dataInicio, dataFim, idAnimal) VALUES (?,?,?)");
            stmt.setDate(1, dataInicio);
            stmt.setDate(2, dataFim);
            stmt.setInt(3, idAnimal);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(TratamentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("tratamento", lastId("tratamento","id"));
    }

    @Override
    public void update(Model model) {
        Tratamento tratamento = (Tratamento) model;
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET dataFim=?, dataInicio=?, idAnimal=? WHERE id=?");
            stmt.setDate(1, tratamento.getDataFim());
            stmt.setDate(2, tratamento.getDataInicio());
            stmt.setInt(3, tratamento.getIdAnimal());
            stmt.setInt(4, tratamento.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Tratamento(rs.getInt("id"), rs.getDate("dataFim"), rs.getDate("dataInicio"), rs.getInt("idAnimal"));
    }
}
