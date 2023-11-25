package com.vet.controller;

import com.vet.DAO.impl.*;
import com.vet.model.impl.Animal;
import com.vet.model.impl.Cliente;
import com.vet.model.impl.Veterinario;

import javax.swing.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public final class Controller {

    private Controller(){}

    private static Integer getIdFromIdString(Object id){
        return Integer.valueOf(((String) id).split("|")[0]);
    }

    public static boolean updateCliente(List<JTextField> inputs, Object id, String nome, String endereco, String cep, String email, String telefone){
        if (verifyTextInputs(inputs, "Ao atualizar um Cliente\nTodos os campos devem ser preenchidos!")) {
            Cliente cliente = new Cliente(
                    getIdFromIdString(id),
                    nome, endereco, cep, email, telefone
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
                    nome, endereco, cep, email, telefone
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

    private static boolean isPositive(Integer input, String errorMessage){
        if (input >= 0){
            return true;
        } else {
            showMessageDialog(null, errorMessage);
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
                showMessageDialog(null, errorMessage);
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

    public static boolean addAnimal(List<JTextField> inputs, String nome, Object idade, Object sexo, Object idEspecie, Object idCliente) {
        if (verifyTextInputs(inputs, "Ao cadastrar um Animal\nTodos os campos devem ser preenchidos!") && isPositive((Integer) idade, "Ao cadastrar um Animal\nA idade deve ser maior ou igual a zero!")) {
            AnimalDAO.insert(nome, (String) sexo, (Integer) idade, getIdFromIdString(idEspecie), getIdFromIdString(idCliente));

            clearInputs(inputs);

            return true;
        } else {
            return false;
        }
    }

    public static boolean updateAnimal(List<JTextField> inputs, Object id, String nome, Object idade, Object sexo, Object idEspecie, Object idCliente) {
        if (verifyTextInputs(inputs, "Ao atualizar um Animal\nTodos os campos devem ser preenchidos!") && isPositive((Integer) idade, "Ao cadastrar um Animal\nA idade deve ser maior ou igual a zero!")) {
            Animal animal = new Animal(
                    getIdFromIdString(id),
                    nome,
                    (Integer) idade,
                    (String) sexo,
                    getIdFromIdString(idEspecie),
                    getIdFromIdString(idCliente)
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

    public static boolean addConsulta(Object dia, Object mes, Object ano, String relato, Object idVeterinario, Object idTratamento) {
        if (relato.isEmpty() || relato.isBlank()) {
            showMessageDialog(null, "Ao cadastrar uma Consulta\nTodos os campos devem ser preenchidos!");
            return false;
        } else {
            try{
                Date data = new Date((Integer)dia, (Integer)mes, (Integer)ano);
                ConsultaDAO.insert(relato, data, getIdFromIdString(idVeterinario), getIdFromIdString(idTratamento));
                return true;
            }catch (Error e){
                showMessageDialog(null, "Data da Consulta inválida!");
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    public static boolean addExame(String descricao, Object idConsulta) {
        if (descricao.isEmpty() || descricao.isBlank()) {
            showMessageDialog(null, "Ao cadastrar um Exame\nTodos os campos devem ser preenchidos!");
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
                showMessageDialog(null, "Data de fim do Tratamento inválida!");
                System.err.println(e.getMessage());
                return false;
            }
        }catch (Error e){
            showMessageDialog(null, "Data de início do Tratamento inválida!");
            System.err.println(e.getMessage());
            return false;
        }
    }
}
