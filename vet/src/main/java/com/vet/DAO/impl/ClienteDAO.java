package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteDAO extends DAO<Cliente> {
    private static ClienteDAO instance = null;

    public static ClienteDAO getInstance(){
        if(instance == null){
            instance = new ClienteDAO();
        }
        return instance;
    }

    public static Model insert(String nome, String end, String cep, String email, String telefone) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO cliente (nome, endereco, cep, email, telefone, ativo) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, end);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.setInt(6, 1);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("cliente", lastId("cliente","id"));
    }

    public static List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM cliente WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "cliente");
    }

    public static void update(Cliente model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE cliente SET nome=?, endereco=?, cep=?, email=?, telefone=?, ativo=? WHERE id=?");
            stmt.setString(1, model.getNome());
            stmt.setString(2, model.getEndereco());
            stmt.setString(3, model.getCep());
            stmt.setString(4, model.getEmail());
            stmt.setString(5, model.getTelefone());
            stmt.setInt(6, Integer.parseInt(model.getAtivo()));
            stmt.setInt(7, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Cliente get(int id) {
        return (Cliente) DAO.retrieveById("cliente", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"), String.valueOf(rs.getInt("ativo")));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Cliente> all = retrieve("SELECT * FROM cliente WHERE ativo = 1", "cliente").stream().map(Cliente.class::cast).toList();

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Cliente> clientes) {
        String[] list = new String[clientes.size()];

        for(int i=0; i < list.length; i++){
            list[i] = clientes.get(i).getId() + "|" + clientes.get(i).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("cliente");
    }
}
