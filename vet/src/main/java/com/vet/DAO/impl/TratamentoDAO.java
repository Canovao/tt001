package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.TratamentoTable;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TratamentoDAO extends DAO<Tratamento> {
    private static TratamentoDAO instance = null;
    private static String retrieveByClienteName = "";
    private static String retrieveByAnimalName = "";

    public static TratamentoDAO getInstance(){
        if(instance == null){
            instance = new TratamentoDAO();
        }
        return instance;
    }

    private static List<Tratamento> doFilterByClienteNameStep(List<Tratamento> tratamentos){
        if (!retrieveByClienteName.isBlank() && !retrieveByClienteName.isEmpty()) {
            List<Integer> animaisIds = new ArrayList<>();

            for(var item: tratamentos){
                int idCliente = AnimalDAO.getInstance().get(item.getIdAnimal()).getIdCliente();
                if(ClienteDAO.getInstance().get(idCliente).getNome().contains(retrieveByClienteName)){
                    animaisIds.add(item.getIdAnimal());
                }
            }

            tratamentos = tratamentos.stream().filter(c -> animaisIds.contains(c.getIdAnimal())).toList();
        }
        return tratamentos;
    }

    private static List<Tratamento> doFilterByAnimalNameStep(List<Tratamento> tratamentos) {
        if (!retrieveByAnimalName.isBlank() && !retrieveByAnimalName.isEmpty()) {
            List<Integer> animaisIds = new ArrayList<>();

            for(var item: tratamentos){
                if(AnimalDAO.getInstance().get(item.getIdAnimal()).getNome().contains(retrieveByAnimalName)){
                    animaisIds.add(item.getIdAnimal());
                }
            }

            tratamentos = tratamentos.stream().filter(c -> animaisIds.contains(c.getIdAnimal())).toList();
        }
        return doFilterByClienteNameStep(tratamentos);
    }

    private static List<Model> baseRetrieveBy(){
        return buildTratamentosTableFromTratamentos(
                doFilterByAnimalNameStep(retrieveAll("tratamento").stream().map(Tratamento.class::cast).toList())
        ).stream().map(Model.class::cast).toList();
    }

    public static List<Model> retrieveByClienteName(String nome){
        retrieveByClienteName = nome;

        return baseRetrieveBy();
    }

    public static List<Model> retrieveByAnimalName(String nome){
        retrieveByAnimalName = nome;

        return baseRetrieveBy();
    }

    private static List<TratamentoTable> buildTratamentosTableFromTratamentos(List<Tratamento> tratamentos) {
        List<TratamentoTable> tratamentoTables = new ArrayList<>();

        for(var item: tratamentos){
            tratamentoTables.add(buildTratamentoTableFromTratamento(item));
        }

        return tratamentoTables;
    }

    public static Model insert(Date dataInicio, Date dataFim, int idAnimal) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO tratamento (data_inicio, data_fim, id_Animal) VALUES (?,?,?)");
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

    public static TratamentoTable buildTratamentoTableFromTratamento(Tratamento tratamento) {
        return new TratamentoTable(
                tratamento.getId(),
                tratamento.getDataInicio(),
                tratamento.getDataFim(),
                getAnimalNomeFromTratamento(tratamento),
                getClienteNomeFromTratamento(tratamento)
        );
    }

    public static void finalizarTratamento(Integer id, Date data) {
        Tratamento tratamento = getInstance().get(id);
        tratamento.setDataFim(data);
        update(tratamento);
    }

    public static void remove(Integer id) {
        deleteById(getInstance().get(id), "tratamento");
    }

    public static List<Tratamento> getAllAnimalTratamentos(int idAnimal) {
        return retrieve("SELECT * FROM tratamento where id_animal = " + idAnimal, "tratamento").stream().map(Tratamento.class::cast).toList();
    }

    @Override
    public Tratamento get(int id) {
        return (Tratamento) DAO.retrieveById("tratamento", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Tratamento(rs.getInt("id"), rs.getDate("data_inicio"), rs.getDate("data_fim"), rs.getInt("id_animal"));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Tratamento> all = retrieve("SELECT * FROM tratamento", "tratamento").stream().map(Tratamento.class::cast).toList();

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Tratamento> tratamentos) {
        String[] list = new String[tratamentos.size()];

        for(int i=0; i < list.length; i++){
            Animal animal = AnimalDAO.getInstance().get(tratamentos.get(i).getIdAnimal());
            list[i] = tratamentos.get(i).getId() + "|" + (animal).getNome() + "|" + ClienteDAO.getInstance().get(animal.getIdCliente()).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("tratamento");
    }


    public static String getAnimalNomeFromTratamento(Tratamento tratamento){
        return AnimalDAO.getInstance().get(tratamento.getIdAnimal()).getNome();
    }

    public static String getClienteNomeFromTratamento(Tratamento tratamento){
        int idCliente = AnimalDAO.getInstance().get(tratamento.getIdAnimal()).getIdCliente();
        return ClienteDAO.getInstance().get(idCliente).getNome();
    }

    public String[] getAllUnfinished(){
        List<Tratamento> all = retrieve("SELECT * FROM tratamento WHERE data_fim is null", "tratamento").stream().map(Tratamento.class::cast).toList();

        return buildToComboBox(all);
    }

    public String[] getAllFinished() {
        List<Tratamento> all = retrieve("SELECT * FROM tratamento WHERE data_fim is not null", "tratamento").stream().map(Tratamento.class::cast).toList();

        return buildToComboBox(all);
    }
}
