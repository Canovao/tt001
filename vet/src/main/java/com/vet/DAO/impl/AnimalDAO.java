package com.vet.DAO.impl;


import com.vet.DAO.DAO;
import com.vet.model.Model;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;
import com.vet.model.impl.Especie;
import com.vet.model.impl.table.AnimalTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AnimalDAO extends DAO<Animal> {
    private static AnimalDAO instance = null;

    private static String retrieveByAnimalName = "";
    private static String retrieveByClienteName = "";

    public static AnimalDAO getInstance(){
        if(instance == null){
            instance = new AnimalDAO();
        }
        return instance;
    }

    public static Model insert(String nome, String sexo, int anoNascimento, int idEspecie, int idCliente) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("INSERT INTO animal (nome, sexo, ano_nascimento, id_especie, id_cliente, ativo) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, nome);
            stmt.setString(2, sexo);
            stmt.setInt(3, anoNascimento);
            stmt.setInt(4, idEspecie);
            stmt.setInt(5, idCliente);
            stmt.setInt(6, 1);
            executeUpdate(stmt);
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retrieveById("animal", lastId("animal","id"));
    }

    private static List<Animal> doFilterByClienteNameStep(List<Animal> animais){
        if (!retrieveByClienteName.isBlank() && !retrieveByClienteName.isEmpty()) {
            List<Integer> clientesIds = ClienteDAO.retrieveBySimilarName(retrieveByClienteName)
                    .stream()
                    .map(Cliente.class::cast)
                    .filter(e -> e.getNome().contains(retrieveByClienteName))
                    .map(Cliente::getId).toList();

            List<Animal> animaisToRemove = new ArrayList<>();

            for (var item : animais) {
                if (!clientesIds.contains(item.getIdCliente())) {
                    animaisToRemove.add(item);
                }
            }

            for (var item : animaisToRemove) {
                animais.remove(item);
            }
        }
        return animais;
    }

    private static List<Model> baseRetrieveBy(){
        return buildAnimaisTableFromAnimais(
                doFilterByClienteNameStep(
                        DAO.retrieve("SELECT * FROM animal WHERE UPPER(nome) LIKE UPPER('%" + retrieveByAnimalName + "%')", "animal").stream().map(Animal.class::cast).toList()
                )
        ).stream().map(Model.class::cast).toList();
    }

    public static List<Model> retrieveByAnimalName(String nome) {
        retrieveByAnimalName = nome;

        return baseRetrieveBy();
    }

    public static List<Model> retrieveByClienteName(String nome) {
        retrieveByClienteName = nome;

        return baseRetrieveBy();
    }

    public static List<AnimalTable> buildAnimaisTableFromAnimais(List<Animal> animais){
        List<AnimalTable> animalTables = new ArrayList<>();

        for(var item: animais){
            animalTables.add(buildAnimalTableFromAnimal(item));
        }

        return animalTables;
    }

    public static void update(Animal model) {
        try {
            PreparedStatement stmt;
            stmt = DAO.getConnection().prepareStatement("UPDATE animal SET nome=?, sexo=?, ano_nascimento=?, id_especie=?, id_cliente=?, ativo=? WHERE id=?");
            stmt.setString(1, model.getNome());
            stmt.setString(2, model.getSexo());
            stmt.setInt(3, model.getAnoNascimento());
            stmt.setInt(4, model.getIdEspecie());
            stmt.setInt(5, model.getIdCliente());
            stmt.setInt(6, Integer.parseInt(model.getAtivo()));
            stmt.setInt(7, model.getId());
            executeUpdate(stmt);
        } catch (SQLException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }

    public static AnimalTable buildAnimalTableFromAnimal(Animal animal) {
        return new AnimalTable(
                animal.getId(),
                animal.getNome(),
                animal.getAnoNascimento(),
                animal.getSexo(),
                getEspecieNomeFromAnimal(animal),
                getClienteNomeFromAnimal(animal),
                (animal.getAtivo().equalsIgnoreCase("1")) ? "Sim": "Não"
        );
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

        return buildToComboBox(all);
    }

    @Override
    public String[] buildToComboBox(List<Animal> animals) {
        String[] list = new String[animals.size()];

        for(int i=0; i < list.length; i++){
            list[i] = animals.get(i).getId() + "|" + animals.get(i).getNome();
        }

        return list;
    }

    @Override
    public List<Model> retrieveAll() {
        return retrieveAll("animal");
    }


    public static String getEspecieNomeFromAnimal(Animal animal){
        return EspecieDAO.getInstance().get(animal.getIdEspecie()).getNome();
    }

    public static String getClienteNomeFromAnimal(Animal animal){
        return ClienteDAO.getInstance().get(animal.getIdCliente()).getNome();
    }
}
