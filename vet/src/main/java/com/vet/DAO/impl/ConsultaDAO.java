package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.*;
import com.vet.model.impl.table.ConsultaTable;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaDAO extends DAO<Consulta> {
    private static ConsultaDAO instance = null;
    private static String retrieveByClienteName = "";
    private static String retrieveByAnimalName = "";
    private static String retrieveByVeterinarioName = "";

    public static ConsultaDAO getInstance(){
        if(instance == null){
            instance = new ConsultaDAO();
        }
        return instance;
    }

    private static List<Consulta> doFilterByClienteNameStep(List<Consulta> consultas){
        if (!retrieveByClienteName.isBlank() && !retrieveByClienteName.isEmpty()) {
            List<Integer> tratamentoIds = new ArrayList<>();

            for(var item: consultas){
                int idAnimal = TratamentoDAO.getInstance().get(item.getIdTratamento()).getIdAnimal();
                int idCliente = AnimalDAO.getInstance().get(idAnimal).getIdCliente();
                if(ClienteDAO.getInstance().get(idCliente).getNome().contains(retrieveByClienteName)){
                    tratamentoIds.add(item.getIdTratamento());
                }
            }

            consultas = consultas.stream().filter(c -> tratamentoIds.contains(c.getIdTratamento())).toList();
        }
        return consultas;
    }

    private static List<Consulta> doFilterByVeterinarioNameStep(List<Consulta> consultas) {
        if (!retrieveByVeterinarioName.isBlank() && !retrieveByVeterinarioName.isEmpty()) {
            List<Integer> veterinariosIds = new ArrayList<>();

            for(var item: consultas){
                if(VeterinarioDAO.getInstance().get(item.getIdVeterinario()).getNome().contains(retrieveByVeterinarioName)){
                    veterinariosIds.add(item.getIdVeterinario());
                }
            }

            consultas = consultas.stream().filter(c -> veterinariosIds.contains(c.getIdVeterinario())).toList();
        }
        return doFilterByAnimalNameStep(consultas);
    }

    private static List<Consulta> doFilterByAnimalNameStep(List<Consulta> consultas) {
        if (!retrieveByAnimalName.isBlank() && !retrieveByAnimalName.isEmpty()) {
            List<Integer> tratamentoIds = new ArrayList<>();

            for(var item: consultas){
                int idAnimal = TratamentoDAO.getInstance().get(item.getIdTratamento()).getIdAnimal();
                if(AnimalDAO.getInstance().get(idAnimal).getNome().contains(retrieveByAnimalName)){
                    tratamentoIds.add(item.getIdTratamento());
                }
            }

            consultas = consultas.stream().filter(c -> tratamentoIds.contains(c.getIdTratamento())).toList();
        }
        return doFilterByClienteNameStep(consultas);
    }

    private static List<Model> baseRetrieveBy(){
        return buildConsultasTableFromConsultas(
                doFilterByVeterinarioNameStep(retrieveAll("consulta").stream().map(Consulta.class::cast).toList())
        ).stream().map(Model.class::cast).toList();
    }

    public static List<Model> retrieveByClienteName(String nome){
        retrieveByClienteName = nome;

        return baseRetrieveBy();
    }

    private static List<Model> retrieveAll(String table, String orderByClause) {
        return retrieveAll(table)
                .stream()
                .sorted(Comparator.comparing(model -> {
                    if (orderByClause != null && orderByClause.equalsIgnoreCase("terminado ASC")) {
                        return ((Consulta) model).getTerminado();
                    } else {
                        return 0;
                    }
                }))
                .toList();
    }

    public static List<Consulta> retrieveByVeterinarioDiaHorario(int idVeterinario, Date dia, int horario){
        return retrieveByVeterinarioDiaHorarioDAO(idVeterinario, dia, horario).stream().map(Consulta.class::cast).toList();
    }

    public static List<Model> retrieveByVeterinarioName(String nome){
        retrieveByVeterinarioName = nome;

        return baseRetrieveBy();
    }

    public static List<Model> retrieveByAnimalName(String nome){
        retrieveByAnimalName = nome;

        return buildConsultasTableFromConsultas(
                doFilterByVeterinarioNameStep(retrieveAll("consulta").stream().map(Consulta.class::cast).toList())
        ).stream().map(Model.class::cast).toList();
    }

    private static List<ConsultaTable> buildConsultasTableFromConsultas(List<Consulta> consultas) {
        List<ConsultaTable> consultaTables = new ArrayList<>();

        for(var item: consultas){
            consultaTables.add(buildConsultaTableFromConsulta(item));
        }

        return consultaTables;
    }

    public static Model insert(String relato, Date dataConsulta, int idTratamento, int idVeterinario, int horario, int terminado) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO consulta (relato, data_consulta, horario, id_tratamento, id_veterinario, terminado) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, relato);
            stmt.setDate(2, dataConsulta);
            stmt.setInt(3, horario);
            stmt.setInt(4, idTratamento);
            stmt.setInt(5, idVeterinario);
            stmt.setInt(6, terminado);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("consulta", lastId("consulta","id"));
    }

    public static void update(Consulta model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET relato=?, data_consulta=?, id_tratamento=?, id_veterinario=?, terminado = ? WHERE id=?");
            stmt.setString(1, model.getRelato());
            stmt.setDate(2, model.getDataConsulta());
            stmt.setInt(3, model.getIdTratamento());
            stmt.setInt(4, model.getIdVeterinario());
            stmt.setInt(5, model.getTerminado());
            stmt.setInt(6, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static ConsultaTable buildConsultaTableFromConsulta(Consulta consulta) {
        return new ConsultaTable(
                consulta.getId(),
                consulta.getDataConsulta(),
                consulta.getHorario(),
                consulta.getRelato(),
                getClienteNomeFromConsulta(consulta),
                getAnimalNomeFromConsulta(consulta),
                getVeterinarioNomeFromConsulta(consulta),
                consulta.getIdTratamento(),
                (consulta.getTerminado() == 1) ? "Sim": "Não"
        );
    }

    public static List<Consulta> getAllUnfinished() {
        return retrieve("SELECT * FROM consulta WHERE terminado = 0", "consulta").stream().map(Consulta.class::cast).toList();
    }

    public static void finalizarConsulta(Integer id) {
        Consulta consulta = getInstance().get(id);
        consulta.setTerminado(1);
        update(consulta);
    }

    public static void remove(int idConsulta) {
        deleteById(getInstance().get(idConsulta), "consulta");
    }

    public static List<Consulta> getAllTratamentoConsulta(int id) {
        return retrieve("SELECT * FROM consulta WHERE id_tratamento = " + id, "consulta").stream().map(Consulta.class::cast).toList();
    }

    public static List<Consulta> getAllVeterinarioConsulta(int idVeterinario) {
        return retrieve("SELECT * FROM consulta WHERE id_veterinario = " + idVeterinario, "consulta").stream().map(Consulta.class::cast).toList();
    }

    @Override
    public Consulta get(int id) {
        return (Consulta) DAO.retrieveById("consulta", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Consulta(rs.getInt("id"), rs.getDate("data_consulta"), rs.getInt("horario"), rs.getString("relato"), rs.getInt("id_veterinario"), rs.getInt("id_tratamento"), rs.getInt("terminado"));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Consulta> all = retrieve("SELECT * FROM consulta", "consulta").stream().map(Consulta.class::cast).toList();

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Consulta> consultas) {
        String[] list = new String[consultas.size()];

        for(int i=0; i < list.length; i++){
            list[i] = consultas.get(i).getId() + "|" + consultas.get(i).getRelato();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("consulta");
    }

    public static String getVeterinarioNomeFromConsulta(Consulta consulta){
        return VeterinarioDAO.getInstance().get(consulta.getIdVeterinario()).getNome();
    }

    public static String getClienteNomeFromConsulta(Consulta consulta){
        int idAnimal = TratamentoDAO.getInstance().get(consulta.getIdTratamento()).getIdAnimal();
        int idCliente = AnimalDAO.getInstance().get(idAnimal).getIdCliente();
        return ClienteDAO.getInstance().get(idCliente).getNome();
    }

    public static String getAnimalNomeFromConsulta(Consulta consulta){
        int idAnimal = TratamentoDAO.getInstance().get(consulta.getIdTratamento()).getIdAnimal();
        return AnimalDAO.getInstance().get(idAnimal).getNome();
    }
}
