package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.*;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConsultaDAO extends DAO<Consulta> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new ConsultaDAO();
        }
        return instance;
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
            stmt = DAO.getConnection().prepareStatement("UPDATE consulta SET relato=?, data_consulta=?, id_tratamento=?, id_veterinario=? WHERE id=?");
            stmt.setString(1, model.getRelato());
            stmt.setDate(2, model.getDataConsulta());
            stmt.setInt(3, model.getIdTratamento());
            stmt.setInt(4, model.getIdVeterinario());
            stmt.setInt(5, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
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

        String[] list = new String[all.size()];

        for(int i=0; i < list.length; i++){
            list[i] = all.get(i).getId() + " | " + all.get(i).getRelato();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("consulta");
    }

    public static String getVeterinarioNomeFromConsulta(Consulta consulta){
        return ((Veterinario) VeterinarioDAO.getInstance().get(consulta.getIdVeterinario())).getNome();
    }

    public static String getClienteNomeFromConsulta(Consulta consulta){
        int idAnimal = ((Tratamento) TratamentoDAO.getInstance().get(consulta.getIdTratamento())).getIdAnimal();
        int idCliente = ((Animal) AnimalDAO.getInstance().get(idAnimal)).getIdCliente();
        return ((Cliente) ClienteDAO.getInstance().get(idCliente)).getNome();
    }

    public static String getAnimalNomeFromConsulta(Consulta consulta){
        int idAnimal = ((Tratamento) TratamentoDAO.getInstance().get(consulta.getIdTratamento())).getIdAnimal();
        return ((Animal) AnimalDAO.getInstance().get(idAnimal)).getNome();
    }
}
