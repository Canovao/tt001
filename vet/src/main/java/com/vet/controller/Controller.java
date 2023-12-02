package com.vet.controller;

import com.vet.DAO.impl.*;
import com.vet.model.Model;
import com.vet.model.impl.*;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public final class Controller {

    private Controller(){}

    private static Integer getIdFromIdString(Object id){
        return Integer.valueOf(((String) id).split("\\|")[0].trim());
    }

    public static boolean updateCliente(List<JTextField> inputs, Object id, String nome, String endereco, String cep, String email, String telefone){
        if (verifyTextInputs(inputs, "Ao atualizar um Cliente\nTodos os campos devem ser preenchidos!")) {
            Cliente cliente = new Cliente(
                    getIdFromIdString(id),
                    nome, endereco, cep, email, telefone, "1"
            );

            ClienteDAO.update(cliente);

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static boolean addCliente(List<JTextField> inputs, String nome, String endereco, String cep, String email, String telefone){
        if (verifyTextInputs(inputs, "Ao cadastrar um Cliente\nTodos os campos devem ser preenchidos!")) {
            ClienteDAO.insert(nome, endereco, cep, email, telefone);

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static boolean updateVeterinario(List<JTextField> inputs, Object id, String nome, String endereco, String cep, String email, String telefone){
        if (verifyTextInputs(inputs, "Ao atualizar um Veterinário\nTodos os campos devem ser preenchidos!")) {
            Veterinario veterinario = new Veterinario(
                    getIdFromIdString(id),
                    nome, endereco, cep, email, telefone, "1"
            );

            VeterinarioDAO.update(veterinario);

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static boolean addVeterinario(List<JTextField> inputs, String nome, String endereco, String cep, String email, String telefone){
        if (verifyTextInputs(inputs, "Ao cadastrar um Veterinário\nTodos os campos devem ser preenchidos!")) {
            VeterinarioDAO.insert(nome, endereco, cep, email, telefone);

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    private static boolean verifyTextInputs(List<JTextField> textFields, String errorMessage){
        List<String> inputs = new ArrayList<>();

        for(var item: textFields){
            inputs.add(item.getText());
        }

        boolean proceed = true;

        for(var item: inputs){
            if(item.isEmpty() || item.isBlank()){
                proceed = false;
                showMessageDialog(null, errorMessage, "Erro", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }

        return proceed;
    }

    public static void clearInputs(List<JTextField> inputs){
        for(var item: inputs){
            item.setText("");
        }
    }

    public static boolean addAnimal(List<JTextField> inputs, String nome, Object anoNascimento, Object sexo, Object idEspecie, Object idCliente) {
        if (verifyTextInputs(inputs, "Ao cadastrar um Animal\nTodos os campos devem ser preenchidos!")) {
            AnimalDAO.insert(nome, (String) sexo, (Integer) anoNascimento, getIdFromIdString(idEspecie), getIdFromIdString(idCliente));

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static boolean updateAnimal(List<JTextField> inputs, Object id, String nome, Object anoNascimento, Object sexo, Object idEspecie, Object idCliente) {
        if (verifyTextInputs(inputs, "Ao atualizar um Animal\nTodos os campos devem ser preenchidos!")) {
            Animal animal = new Animal(
                    getIdFromIdString(id),
                    nome,
                    (Integer) anoNascimento,
                    (String) sexo,
                    getIdFromIdString(idEspecie),
                    getIdFromIdString(idCliente),
                    "1"
            );

            AnimalDAO.update(animal);

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static void addEspecie(List<JTextField> inputs, String nome) {
        if (verifyTextInputs(inputs, "Ao cadastrar uma Espécie\nTodos os campos devem ser preenchidos!")) {
            EspecieDAO.insert(nome);

            clearInputs(inputs);
        }
    }

    public static boolean addConsulta(Object dia, Object mes, Object ano, String relato, Object idVeterinario, Object idTratamento, Object horario) {
        if (relato.isEmpty() || relato.isBlank()) {
            showMessageDialog(null, "Ao cadastrar uma Consulta\nTodos os campos devem ser preenchidos!", "Erro", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            try{
                Date data = new Date((Integer)dia, (Integer)mes, (Integer)ano);
                ConsultaDAO.insert(relato, data, getIdFromIdString(idVeterinario), getIdFromIdString(idTratamento), (Integer)horario, 0);
                return true;
            }catch (Error e){
                showMessageDialog(null, "Data da Consulta inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    public static boolean addExame(String descricao, Object idConsulta) {
        if (descricao.isEmpty() || descricao.isBlank()) {
            showMessageDialog(null, "Ao cadastrar um Exame\nTodos os campos devem ser preenchidos!", "Erro", JOptionPane.WARNING_MESSAGE);
            ExameDAO.insert(descricao, getIdFromIdString(idConsulta));
            return true;
        } else {
            return false;
        }
    }

    public static boolean addTratamento(Object diaInicio, Object mesInicio, Object anoInicio, Object diaFim, Object mesFim, Object anoFim, Object idAnimal) {
        try{
            Date dataInicio = new Date((Integer)diaInicio, (Integer)mesInicio, (Integer)anoInicio);
            try{
                Date dataFim = new Date((Integer)diaFim, (Integer)mesFim, (Integer)anoFim);
                TratamentoDAO.insert(dataInicio, dataFim, getIdFromIdString(idAnimal));
                return true;
            }catch (Error e){
                showMessageDialog(null, "Data de fim do Tratamento inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
                System.err.println(e.getMessage());
                return false;
            }
        }catch (Error e){
            showMessageDialog(null, "Data de início do Tratamento inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static String[] getAllTratamentosUnfinished() {
        return TratamentoDAO.getInstance().getAllUnfinished();
    }

    public static String[] getAllClientesToComboBox() {
        return ClienteDAO.getInstance().getAllToComboBox();
    }

    public static String[] getAllClientesInactive() {
        List<Cliente> all = ClienteDAO.getAllInactive();

        return ClienteDAO.getInstance().buildToComboBox(all);
    }

    public static String[] getAllEspeciesToComboBox() {
        return EspecieDAO.getInstance().getAllToComboBox();
    }

    public static String[] getAllAnimaisToComboBox() {
        return AnimalDAO.getInstance().getAllToComboBox();
    }

    public static String[] getAllAnimaisInactive() {
        List<Animal> all = AnimalDAO.getAllInactive();

        return AnimalDAO.getInstance().buildToComboBox(all);
    }

    public static String[] getAllVeterinariosToComboBox() {
        return VeterinarioDAO.getInstance().getAllToComboBox();
    }

    public static String[] getAllVeterinariosInactive() {
        List<Veterinario> all = VeterinarioDAO.getAllInactive();

        return VeterinarioDAO.getInstance().buildToComboBox(all);
    }

    public static String[] getAllTratamentosToComboBox() {
        return TratamentoDAO.getInstance().getAllToComboBox();
    }

    public static String[] getAllConsultasUnfinished() {
        List<Consulta> all = ConsultaDAO.getAllUnfinished();

        return ConsultaDAO.getInstance().buildToComboBox(all);
    }

    public static String[] getAllConsultasToComboBox() {
        return ConsultaDAO.getInstance().getAllToComboBox();
    }

    public static void desativarCliente(Object id) {
        ClienteDAO.desativarCliente(getIdFromIdString(id));
    }

    public static void ativarCliente(Object id) {
        ClienteDAO.ativarCliente(getIdFromIdString(id));
    }

    public static void atualizarEspecie(Object id, String nome) {
        Especie especie = EspecieDAO.getInstance().get(getIdFromIdString(id));
        especie.setNome(nome);
        EspecieDAO.update(especie);
    }

    public static void desativarAnimal(Object id) {
        AnimalDAO.desativarAnimal(getIdFromIdString(id));
    }

    public static void ativarAnimal(Object id) {
        AnimalDAO.ativarAnimal(getIdFromIdString(id));
    }

    public static void desativarVeterinario(Object id) {
        VeterinarioDAO.desativarVeterinario(getIdFromIdString(id));
    }

    public static void ativarVeterinario(Object id) {
        VeterinarioDAO.ativarVeterinario(getIdFromIdString(id));
    }

    public static void finalizarConsulta(Object id) {
        ConsultaDAO.finalizarConsulta(getIdFromIdString(id));
    }

    public static void finalizarTratamento(Object id) {
        TratamentoDAO.finalizarTratamento(getIdFromIdString(id));
    }

    public static boolean addTratamentoIndeterminado(Object diaInicio, Object mesInicio, Object anoInicio, Object idAnimal) {
        try{
            Date dataInicio = new Date((Integer)diaInicio, (Integer)mesInicio, (Integer)anoInicio);
            TratamentoDAO.insert(dataInicio, null, getIdFromIdString(idAnimal));
            return true;
        }catch (Error e){
            showMessageDialog(null, "Data de início do Tratamento inválida!", "Erro", JOptionPane.WARNING_MESSAGE);
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static List<Model> getAllAnimais() {
        return AnimalDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllClientes() {
        return ClienteDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllConsultas() {
        return ConsultaDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllExames() {
        return ExameDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllTratamentos() {
        return TratamentoDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllVeterinarios() {
        return VeterinarioDAO.getInstance().retrieveAll();
    }

    public static List<Model> getAllClienteBySimilarName(String name) {
        return ClienteDAO.retrieveBySimilarName(name);
    }

    public static List<Model> getAllAnimalBySimilarName(String name) {
        return AnimalDAO.retrieveByAnimalName(name);
    }

    public static List<Model> getAllAnimalByTutorName(String name) {
        return AnimalDAO.retrieveByClienteName(name);
    }

    public static List<Model> getAllVeterinarioBySimilarName(String name) {
        return VeterinarioDAO.retrieveBySimilarName(name);
    }

    public static List<Model> getAllConsultaByClienteName(String name) {
        return ConsultaDAO.retrieveByClienteName(name);
    }

    public static List<Model> getAllConsultaByVeterinarioName(String name) {
        return ConsultaDAO.retrieveByVeterinarioName(name);
    }

    public static List<Model> getAllConsultaByAnimalName(String name) {
        return ConsultaDAO.retrieveByAnimalName(name);
    }

    public static void addConsultaOrderByTerminadoClause() {
        ConsultaDAO.addOrderByTerminadoClause();
    }

    public static void removeConsultaOrderByTerminadoClause() {
        ConsultaDAO.removeOrderByTerminadoClause();
    }

    public static List<Model> getAllExameByClienteName(String name) {
        return ExameDAO.retrieveByClienteName(name);
    }

    public static List<Model> getAllExameByVeterinarioName(String name) {
        return ExameDAO.retrieveByVeterinarioName(name);
    }

    public static List<Model> getAllExameByAnimalName(String name) {
        return ExameDAO.retrieveByAnimalName(name);
    }

    public static List<Model> getAllTratamentoByClienteName(String name) {
        return TratamentoDAO.retrieveByClienteName(name);
    }

    public static List<Model> getAllTratamentoByAnimalName(String name) {
        return TratamentoDAO.retrieveByAnimalName(name);
    }
}
