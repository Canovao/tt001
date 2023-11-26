package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;
import com.vet.model.impl.Tratamento;
import com.vet.model.impl.Veterinario;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TratamentoDAO extends DAO<Tratamento> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new TratamentoDAO();
        }
        return instance;
    }

    public static Model insert(Date dataInicio, Date dataFim, int idAnimal) {
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

    public static void update(Tratamento model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE tratamento SET data_fim=?, data_inicio=?, id_animal=? WHERE id=?");
            stmt.setDate(1, model.getDataFim());
            stmt.setDate(2, model.getDataInicio());
            stmt.setInt(3, model.getIdAnimal());
            stmt.setInt(4, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Tratamento get(int id) {
        return (Tratamento) DAO.retrieveById("tratamento", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Tratamento(rs.getInt("id"), rs.getDate("data_fim"), rs.getDate("data_inicio"), rs.getInt("id_animal"));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Tratamento> all = retrieve("SELECT * FROM tratamento", "tratamento").stream().map(Tratamento.class::cast).toList();

        String[] list = new String[all.size()];

        for(int i=0; i < list.length; i++){
            list[i] = all.get(i).getId() + " | " + AnimalDAO.getInstance().get(all.get(i).getIdAnimal());
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("tratamento");
    }


    public static String getAnimalNomeFromTratamento(Tratamento tratamento){
        return ((Animal) AnimalDAO.getInstance().get(tratamento.getIdAnimal())).getNome();
    }

    public static String getClienteNomeFromTratamento(Tratamento tratamento){
        int idCliente = ((Animal) AnimalDAO.getInstance().get(tratamento.getIdAnimal())).getIdCliente();
        return ((Cliente) ClienteDAO.getInstance().get(idCliente)).getNome();
    }

    public List<Tratamento> getAllUnfinished(){
        return retrieve("SELECT * FROM tratamento WHERE data_fim = null", "tratamento").stream().map(Tratamento.class::cast).toList();
    }
}
