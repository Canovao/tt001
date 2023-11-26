package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExameDAO extends DAO<Exame> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new ExameDAO();
        }
        return instance;
    }

    public static Model insert(String descricao, int idConsulta) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO exame (descricao, id_consulta) VALUES (?,?)");
            stmt.setString(1, descricao);
            stmt.setInt(2, idConsulta);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ExameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("exame", lastId("exame","id"));
    }

    public static void update(Exame model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE exame SET descricao=?, id_consulta=? WHERE id=?");
            stmt.setString(1, model.getDescricao());
            stmt.setInt(2, model.getIdConsulta());
            stmt.setInt(3, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Exame get(int id) {
        return (Exame) DAO.retrieveById("exame", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Exame(rs.getInt("id"), rs.getString("descricao"), rs.getInt("id_consulta"));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Exame> all = retrieve("SELECT * FROM exame", "exame").stream().map(Exame.class::cast).toList();

        String[] list = new String[all.size()];

        for(int i=0; i < list.length; i++){
            list[i] = String.valueOf(all.get(i).getId()) + '|' + all.get(i).getDescricao();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("exame");
    }

    public static String getConsultaRelatoFromExame(Exame exame){
        return exame.getIdConsulta() + " | " + ((Consulta) ConsultaDAO.getInstance().get(exame.getIdConsulta())).getRelato();
    }

    public static String getClienteNomeFromExame(Exame exame){
        int idTratamento = ((Consulta) ConsultaDAO.getInstance().get(exame.getIdConsulta())).getIdTratamento();
        int idAnimal = ((Tratamento) TratamentoDAO.getInstance().get(idTratamento)).getIdAnimal();
        int idCliente = ((Animal) AnimalDAO.getInstance().get(idAnimal)).getIdCliente();
        return ((Cliente) ClienteDAO.getInstance().get(idCliente)).getNome();
    }

    public static String getAnimalNomeFromExame(Exame exame){
        int idTratamento = ((Consulta) ConsultaDAO.getInstance().get(exame.getIdConsulta())).getIdTratamento();
        int idAnimal = ((Tratamento) TratamentoDAO.getInstance().get(idTratamento)).getIdAnimal();
        return ((Animal) AnimalDAO.getInstance().get(idAnimal)).getNome();
    }

    public static String getVeterinarioNomeFromExame(Exame exame){
        int idVeterinario = ((Consulta) ConsultaDAO.getInstance().get(exame.getIdConsulta())).getIdVeterinario();
        return ((Veterinario) VeterinarioDAO.getInstance().get(idVeterinario)).getNome();
    }
}
