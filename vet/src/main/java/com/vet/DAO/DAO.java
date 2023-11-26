package com.vet.DAO;


import com.vet.DAO.impl.*;
import com.vet.model.Model;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<MODEL> {
    public static final String DBURL = "jdbc:h2:./vet.db";
    private static Connection con = getConnection();

    protected abstract Model build(ResultSet rs) throws SQLException;

    public abstract MODEL get(int id);

    public abstract String[] getAllToComboBox();

    public abstract List<Model> retrieveAll();

    protected static List<Model> retrieveAll(String table){
        return retrieve(MessageFormat.format("SELECT * FROM {0}", table), table);
    }

    public static Model buildObject(ResultSet rs, String table){
        Model model = null;
        try {
            switch (table) {
                case "cliente" -> model = ClienteDAO.getInstance().build(rs);
                case "animal" -> model = AnimalDAO.getInstance().build(rs);
                case "consulta" -> model = ConsultaDAO.getInstance().build(rs);
                case "especie" -> model = EspecieDAO.getInstance().build(rs);
                case "exame" -> model = ExameDAO.getInstance().build(rs);
                case "tratamento" -> model = TratamentoDAO.getInstance().build(rs);
                case "veterinario" -> model = VeterinarioDAO.getInstance().build(rs);
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return model;
    }

    public static void deleteById(Model model, String table) {
        PreparedStatement stmt;
        try {
            stmt = DAO.getConnection().prepareStatement(MessageFormat.format("DELETE FROM {0} WHERE id = {1}", table, model.getId()));
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    protected static Model retrieveById(String table, int id) {
        List<Model> dataList = retrieve(MessageFormat.format("SELECT * FROM {0} WHERE id = {1}", table, id), table);
        return (dataList.isEmpty() ? null : dataList.get(0));
    }

    protected static List<Model> retrieve(String query, String table) {
        List<Model> dataList = new ArrayList<>();
        ResultSet rs = getResultSet(query);
        try {
            while (rs.next()) {
                dataList.add(buildObject(rs, table));
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return dataList;
    }

    public static Connection getConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL);
            } catch (SQLException e) {
                System.err.println("Exception: " + e.getMessage());
            }
            createTable();
        }
        return con;
    }

    public static ResultSet getResultSet(String query) {
        Statement s;
        ResultSet rs = null;
        try {
            s = con.createStatement();
            rs = s.executeQuery(query);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return rs;
    }

    public static void executeUpdate(PreparedStatement queryStatement) throws SQLException {
        queryStatement.executeUpdate();
    }

    public static int lastId(String tableName, String primaryKey) {
        Statement s;
        int lastId = -1;
        try {
            s = con.createStatement();
            ResultSet rs = s.executeQuery(MessageFormat.format("SELECT MAX({0}) AS id FROM {1}", primaryKey, tableName));
            if (rs.next()) {
                lastId = rs.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
        return lastId;
    }

    public static void closeConnection() {
        try {
            (DAO.getConnection()).close();
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static void createTable() {
        try {
            PreparedStatement stmt;
            // Table cliente:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS cliente( id INTEGER PRIMARY KEY AUTO_INCREMENT, nome VARCHAR, endereco VARCHAR, cep VARCHAR, email VARCHAR, telefone VARCHAR, ativo INTEGER);");
            executeUpdate(stmt);
            // Table animal:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS animal( id INTEGER PRIMARY KEY AUTO_INCREMENT, nome VARCHAR, ano_nascimento INTEGER, sexo VARCHAR, id_especie INTEGER, id_cliente INTEGER, ativo INTEGER);");
            executeUpdate(stmt);
            // Table especie:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS especie( id INTEGER PRIMARY KEY AUTO_INCREMENT, nome VARCHAR, ativo INTEGER);");
            executeUpdate(stmt);
            // Table veterinario:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS veterinario( id INTEGER PRIMARY KEY AUTO_INCREMENT, nome VARCHAR, endereco VARCHAR, cep VARCHAR, email VARCHAR, telefone VARCHAR, ativo INTEGER); ");
            executeUpdate(stmt);        
            // Table consulta:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS consulta( id INTEGER PRIMARY KEY AUTO_INCREMENT, data_consulta DATE, horario INTEGER, relato VARCHAR, id_veterinario INTEGER, id_tratamento INTEGER, terminado INTEGER);");
            executeUpdate(stmt);            
             // Table exame:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS exame( id INTEGER PRIMARY KEY AUTO_INCREMENT, descricao VARCHAR, id_consulta INTEGER);");
            executeUpdate(stmt);
            // Table tratamento:
            stmt = DAO.getConnection().prepareStatement("CREATE TABLE IF NOT EXISTS tratamento( id INTEGER PRIMARY KEY AUTO_INCREMENT, data_inicio DATE, data_fim DATE, id_animal INTEGER);");
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
