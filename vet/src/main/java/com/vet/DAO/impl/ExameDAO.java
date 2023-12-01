package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.ExameTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ExameDAO extends DAO<Exame> {
    private static ExameDAO instance = null;
    private static String retrieveByClienteName = "";
    private static String retrieveByAnimalName = "";
    private static String retrieveByVeterinarioName = "";

    public static ExameDAO getInstance(){
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

    private static List<Model> baseRetrieveBy(){
        return buildExamesTableFromExames(
                doFilterByVeterinarioNameStep(retrieveAll("exame").stream().map(Exame.class::cast).toList())
        ).stream().map(Model.class::cast).toList();
    }

    private static List<Exame> doFilterByClienteNameStep(List<Exame> exames){
        if (!retrieveByClienteName.isBlank() && !retrieveByClienteName.isEmpty()) {
            List<Integer> consultaIds = new ArrayList<>();

            for(var item: exames){
                int idTratamento = ConsultaDAO.getInstance().get(item.getIdConsulta()).getIdTratamento();
                int idAnimal = TratamentoDAO.getInstance().get(idTratamento).getIdAnimal();
                int idCliente = AnimalDAO.getInstance().get(idAnimal).getIdCliente();
                if(ClienteDAO.getInstance().get(idCliente).getNome().contains(retrieveByClienteName)){
                    consultaIds.add(item.getIdConsulta());
                }
            }

            exames = exames.stream().filter(c -> consultaIds.contains(c.getIdConsulta())).toList();
        }
        return exames;
    }

    private static List<Exame> doFilterByVeterinarioNameStep(List<Exame> exames) {
        if (!retrieveByVeterinarioName.isBlank() && !retrieveByVeterinarioName.isEmpty()) {
            List<Integer> consultaIds = new ArrayList<>();

            for(var item: exames){
                int idVeterinario = ConsultaDAO.getInstance().get(item.getIdConsulta()).getIdVeterinario();
                if(VeterinarioDAO.getInstance().get(idVeterinario).getNome().contains(retrieveByVeterinarioName)){
                    consultaIds.add(item.getIdConsulta());
                }
            }

            exames = exames.stream().filter(c -> consultaIds.contains(c.getIdConsulta())).toList();
        }
        return doFilterByAnimalNameStep(exames);
    }

    private static List<Exame> doFilterByAnimalNameStep(List<Exame> exames) {
        if (!retrieveByAnimalName.isBlank() && !retrieveByAnimalName.isEmpty()) {
            List<Integer> consultaIds = new ArrayList<>();

            for(var item: exames){
                int idTratamento = ConsultaDAO.getInstance().get(item.getIdConsulta()).getIdTratamento();
                int idAnimal = TratamentoDAO.getInstance().get(idTratamento).getIdAnimal();
                if(AnimalDAO.getInstance().get(idAnimal).getNome().contains(retrieveByAnimalName)){
                    consultaIds.add(item.getIdConsulta());
                }
            }

            exames = exames.stream().filter(c -> consultaIds.contains(c.getIdConsulta())).toList();
        }
        return doFilterByClienteNameStep(exames);
    }

    public static List<Model> retrieveByClienteName(String nome){
        retrieveByClienteName = nome;

        return baseRetrieveBy();
    }

    private static List<ExameTable> buildExamesTableFromExames(List<Exame> exames) {
        List<ExameTable> exameTables = new ArrayList<>();

        for(var item: exames){
            exameTables.add(buildExameTableFromExame(item));
        }

        return exameTables;
    }

    public static List<Model> retrieveByVeterinarioName(String nome){
        retrieveByVeterinarioName = nome;

        return baseRetrieveBy();
    }

    public static List<Model> retrieveByAnimalName(String nome){
        retrieveByAnimalName = nome;

        return baseRetrieveBy();
    }

    public static ExameTable buildExameTableFromExame(Exame exame) {
        return new ExameTable(
                exame.getId(),
                exame.getDescricao(),
                getClienteNomeFromExame(exame),
                getAnimalNomeFromExame(exame),
                getVeterinarioNomeFromExame(exame),
                getConsultaRelatoFromExame(exame)
        );
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

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Exame> exames) {
        String[] list = new String[exames.size()];

        for(int i=0; i < list.length; i++){
            list[i] = exames.get(i).getId() + "|" + exames.get(i).getDescricao();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("exame");
    }

    public static String getConsultaRelatoFromExame(Exame exame){
        return exame.getIdConsulta() + "|" + ConsultaDAO.getInstance().get(exame.getIdConsulta()).getRelato();
    }

    public static String getClienteNomeFromExame(Exame exame){
        int idTratamento = ConsultaDAO.getInstance().get(exame.getIdConsulta()).getIdTratamento();
        int idAnimal = TratamentoDAO.getInstance().get(idTratamento).getIdAnimal();
        int idCliente = AnimalDAO.getInstance().get(idAnimal).getIdCliente();
        return ClienteDAO.getInstance().get(idCliente).getNome();
    }

    public static String getAnimalNomeFromExame(Exame exame){
        int idTratamento = ConsultaDAO.getInstance().get(exame.getIdConsulta()).getIdTratamento();
        int idAnimal = TratamentoDAO.getInstance().get(idTratamento).getIdAnimal();
        return AnimalDAO.getInstance().get(idAnimal).getNome();
    }

    public static String getVeterinarioNomeFromExame(Exame exame){
        int idVeterinario = ConsultaDAO.getInstance().get(exame.getIdConsulta()).getIdVeterinario();
        return VeterinarioDAO.getInstance().get(idVeterinario).getNome();
    }
}
