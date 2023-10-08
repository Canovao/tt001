package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO extends DAO {
    private static DAO instance = null;

    public static DAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }

    public Model insert(String nome, String end, String cep, String email, String telefone) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO cliente (nome, endereco, cep, email, telefone) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, end);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("cliente", lastId("cliente","id"));
    }

    public List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM cliente WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "cliente");
    }    
        
    public void update(Cliente cliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE cliente SET nome=?, endereco=?, cep=?, email=?, telefone=? WHERE id=?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getEmail());
            stmt.setString(5, cliente.getTelefone());
            stmt.setInt(6, cliente.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"));
    }
}
