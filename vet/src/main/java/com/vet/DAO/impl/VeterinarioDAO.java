package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Veterinario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VeterinarioDAO extends DAO<Veterinario> {
    private static VeterinarioDAO instance = null;

    public static VeterinarioDAO getInstance(){
        if(instance == null){
            instance = new VeterinarioDAO();
        }
        return instance;
    }

    public static Model insert(String nome, String end, String cep, String email, String telefone) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO veterinario (nome, endereco, cep, email, telefone, ativo) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, end);
            stmt.setString(3, cep);
            stmt.setString(4, email);
            stmt.setString(5, telefone);
            stmt.setInt(6, 1);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(VeterinarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("veterinario", lastId("veterinario","id"));
    }

    public static List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM veterinario WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "veterinario");
    }

    public static List<Veterinario> getAllInactive() {
        return retrieve("SELECT * FROM veterinario where ativo = 0", "veterinario").stream().map(Veterinario.class::cast).toList();
    }

    public static void desativarVeterinario(Integer id) {
        Veterinario veterinario = getInstance().get(id);
        veterinario.setAtivo("0");
        update(veterinario);
    }

    public static void ativarVeterinario(Integer id) {
        Veterinario veterinario = getInstance().get(id);
        veterinario.setAtivo("1");
        update(veterinario);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Veterinario(rs.getInt("id"), rs.getString("nome"), rs.getString("endereco"), rs.getString("cep"), rs.getString("email"), rs.getString("telefone"), String.valueOf(rs.getInt("ativo")));
    }

    public static void update(Veterinario model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE veterinario SET nome=?, endereco=?, cep=?, email=?, telefone=?, ativo=? WHERE id=?");
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
    public Veterinario get(int id) {
        return (Veterinario) DAO.retrieveById("veterinario", id);
    }

    @Override
    public String[] getAllToComboBox() {
        List<Veterinario> all = retrieve("SELECT * FROM veterinario WHERE ativo = 1", "veterinario").stream().map(Veterinario.class::cast).toList();

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Veterinario> veterinarios) {
        String[] list = new String[veterinarios.size()];

        for(int i=0; i < list.length; i++){
            list[i] = veterinarios.get(i).getId() + "|" + veterinarios.get(i).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("veterinario");
    }
}
