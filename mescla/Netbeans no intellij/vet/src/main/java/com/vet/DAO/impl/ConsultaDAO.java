package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Consulta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaDAO extends DAO<Consulta> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new ConsultaDAO();
        }
        return instance;
    }

    public Model insert(String relato, Date dataConsulta, int idTratamento, int idVeterinario) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (relato, dataConsulta, idTratamento, idVeterinario) VALUES (?,?,?,?)");
            stmt.setString(1, relato);
            stmt.setDate(2, dataConsulta);
            stmt.setInt(3, idTratamento);
            stmt.setInt(4, idVeterinario);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("consulta", lastId("consulta","id"));
    }

    @Override
    public void update(Consulta model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET relato=?, dataConsulta=?, idTratamento=?, idVeterinario=? WHERE id=?");
            stmt.setString(1, model.getRelato());
            stmt.setDate(2, model.getDataConsulta());
            stmt.setInt(3, model.getIdTratamento());
            stmt.setInt(4, model.getIdVeterinario());
            stmt.setInt(5, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Consulta get(int id) {
        return (Consulta) DAO.retrieveById("consulta", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Consulta(rs.getInt("id"), rs.getDate("dataConsulta"), rs.getString("relato"), rs.getInt("idVeterinario"), rs.getInt("idTratamento"));
    }
}
