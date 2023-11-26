package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;
import com.vet.model.impl.Especie;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnimalDAO extends DAO<Animal> {
    private static DAO<?> instance = null;

    public static DAO<?> getInstance(){
        if(instance == null){
            instance = new AnimalDAO();
        }
        return instance;
    }

    public static Model insert(String nome, String sexo, int anoNascimento, int idEspecie, int idCliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (nome, sexo, ano_nascimento, id_especie, id_cliente) VALUES (?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, sexo);
            stmt.setInt(3, anoNascimento);
            stmt.setInt(4, idEspecie);
            stmt.setInt(5, idCliente);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("animal", lastId("animal","id"));
    }

    public List<Model> retrieveBySimilarName(String nome) {
        return DAO.retrieve("SELECT * FROM animal WHERE UPPER(nome) LIKE UPPER('%" + nome + "%')", "animal");
    }

    public static void update(Animal model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome=?, sexo=?, ano_nascimento=?, id_especie=?, id_cliente=? WHERE id=?");
            stmt.setString(1, model.getNome());
            stmt.setString(2, model.getSexo());
            stmt.setInt(3, model.getAnoNascimento());
            stmt.setInt(4, model.getIdEspecie());
            stmt.setInt(5, model.getIdCliente());
            stmt.setInt(6, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    @Override
    public Animal get(int id) {
        return (Animal) DAO.retrieveById("animal", id);
    }

    public Model build(ResultSet rs) throws SQLException {
        return new Animal(rs.getInt("id"), rs.getString("nome"), rs.getInt("ano_nascimento"), rs.getString("sexo"), rs.getInt("id_especie"), rs.getInt("id_cliente"), String.valueOf(rs.getInt("ativo")));
    }

    @Override
    public String[] getAllToComboBox() {
        List<Animal> all = retrieve("SELECT * FROM animal WHERE ativo = 1", "animal").stream().map(Animal.class::cast).toList();

        String[] list = new String[all.size()];

        for(int i=0; i < list.length; i++){
            list[i] = String.valueOf(all.get(i).getId()) + '|' + all.get(i).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("animal");
    }


    public static String getEspecieNomeFromAnimal(Animal animal){
        return ((Especie) EspecieDAO.getInstance().get(animal.getIdEspecie())).getNome();
    }

    public static String getClienteNomeFromAnimal(Animal animal){
        return ((Cliente) ClienteDAO.getInstance().get(animal.getIdCliente())).getNome();
    }
}
