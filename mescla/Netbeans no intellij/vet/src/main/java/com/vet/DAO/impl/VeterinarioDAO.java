package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Veterinario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VeterinarioDAO extends DAO<Veterinario> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new VeterinarioDAO();
        }
        return instance;
    }

    public Model insert(String nome, String end, String cep, String email, String telefone) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO veterinario (nome, endereco, cep, email, telefone) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, end);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("veterinario", lastId("veterinario","id"));
    }

    public List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM veterinario WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "veterinario");
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Veterinario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"));
    }

    @Override
    public void update(Veterinario model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinario SET nome=?, endereco=?, cep=?, email=?, telefone=? WHERE id=?");
            stmt.setString(1, model.getNome());
            stmt.setString(2, model.getEndereco());
            stmt.setString(3, model.getCep());
            stmt.setString(4, model.getEmail());
            stmt.setString(5, model.getTelefone());
            stmt.setInt(6, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Veterinario get(int id) {
        return (Veterinario) DAO.retrieveById("veterinario", id);
    }
}
