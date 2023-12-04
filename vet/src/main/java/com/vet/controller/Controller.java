package com.vet.controller;

import com.vet.DAO.impl.*;
import com.vet.model.Model;
import com.vet.model.impl.*;

import javax.swing.*;
import java.sql.Date;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
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
                showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
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
            showMessageDialog(null, "Ao cadastrar uma Consulta\nTodos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        } else {
            try {
                LocalDate localDate = LocalDate.of((Integer) ano, (Integer) mes, (Integer) dia);

                Date data = Date.valueOf(localDate);

                if (ConsultaDAO.retrieveByVeterinarioDiaHorario(getIdFromIdString(idVeterinario), data, Integer.parseInt((String) horario)).isEmpty()) {
                    ConsultaDAO.insert(relato, data, getIdFromIdString(idTratamento), getIdFromIdString(idVeterinario), Integer.parseInt((String) horario), 0);
                    return true;
                } else {
                    showMessageDialog(null, "Ao cadastrar uma Consulta\nO veterinário, dia e horário não podem se repetir!", "Erro", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (DateTimeException | NumberFormatException e) {
                showMessageDialog(null, "Data da Consulta inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    public static boolean addExame(String descricao, Object idConsulta) {
        if (!descricao.isEmpty() || !descricao.isBlank()) {
            ExameDAO.insert(descricao, getIdFromIdString(idConsulta));
            return true;
        } else {
            showMessageDialog(null, "Ao cadastrar um Exame\nTodos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean addTratamento(Object diaInicio, Object mesInicio, Object anoInicio, Object diaFim, Object mesFim, Object anoFim, Object idAnimal) {
        try{
            LocalDate localDate = LocalDate.of((Integer)anoInicio, (Integer)mesInicio, (Integer)diaInicio);

            Date dataInicio = Date.valueOf(localDate);

            try{
                localDate = LocalDate.of((Integer)anoFim, (Integer)mesFim, (Integer)diaFim);

                Date dataFim = Date.valueOf(localDate);

                TratamentoDAO.insert(dataInicio, dataFim, getIdFromIdString(idAnimal));
                return true;
            }catch (Exception e){
                showMessageDialog(null, "Data de fim do Tratamento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                System.err.println(e.getMessage());
                return false;
            }
        }catch (Exception e){
            showMessageDialog(null, "Data de início do Tratamento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
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
        int idCliente = getIdFromIdString(id);
        ClienteDAO.desativarCliente(idCliente);

        var allAnimais = AnimalDAO.getAllClienteAnimal(idCliente);

        for(var item: allAnimais){
            desativarAnimal(item.getId() + "| ");
        }
    }

    public static void ativarCliente(Object id) {
        int idCliente = getIdFromIdString(id);
        ClienteDAO.ativarCliente(idCliente);

        var allAnimais = AnimalDAO.getAllClienteAnimal(idCliente);

        for(var item: allAnimais){
            ativarAnimal(item.getId() + "| ");
        }
    }

    public static void atualizarEspecie(Object id, String nome) {
        Especie especie = EspecieDAO.getInstance().get(getIdFromIdString(id));
        especie.setNome(nome);
        EspecieDAO.update(especie);
    }

    public static void desativarAnimal(Object id) {
        int idAnimal = getIdFromIdString(id);
        AnimalDAO.desativarAnimal(idAnimal);
        var tratamentosDoAnimal = TratamentoDAO.getAllAnimalTratamentos(idAnimal);

        for(var item: tratamentosDoAnimal){
            var allConsulta = ConsultaDAO.getAllTratamentoConsulta(item.getId());

            for(var consulta: allConsulta){
                removerConsulta(consulta.getId() + "| ");
            }

            removerTratamento(item.getId() + "| ");
        }
    }

    public static void ativarAnimal(Object id) {
        AnimalDAO.ativarAnimal(getIdFromIdString(id));
    }

    public static void desativarVeterinario(Object id) {
        int idVeterinario = getIdFromIdString(id);
        VeterinarioDAO.desativarVeterinario(idVeterinario);

        var allConsultas = ConsultaDAO.getAllVeterinarioConsulta(idVeterinario);

        for(var item: allConsultas){
            removerConsulta(item.getId() + "| ");
        }
    }

    public static void ativarVeterinario(Object id) {
        VeterinarioDAO.ativarVeterinario(getIdFromIdString(id));
    }

    public static void finalizarConsulta(Object id) {
        ConsultaDAO.finalizarConsulta(getIdFromIdString(id));
    }

    public static void finalizarTratamento(Object id, Object diaFim, Object mesFim, Object anoFim) {
        try{
            LocalDate localDate = LocalDate.of((Integer) anoFim, (Integer) mesFim, (Integer) diaFim);

            Date data = Date.valueOf(localDate);

            TratamentoDAO.finalizarTratamento(getIdFromIdString(id), data);
        }catch(Exception e){
            showMessageDialog(null, "Data de fim do Tratamento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
        }
    }

    public static boolean addTratamentoIndeterminado(Object diaInicio, Object mesInicio, Object anoInicio, Object idAnimal) {
        try{
            LocalDate localDate = LocalDate.of((Integer)anoInicio, (Integer)mesInicio, (Integer)diaInicio);

            Date dataInicio = Date.valueOf(localDate);

            TratamentoDAO.insert(dataInicio, null, getIdFromIdString(idAnimal));
            return true;
        }catch (Exception e){
            showMessageDialog(null, "Data de início do Tratamento inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public static String[] getAllTratamentosFinished() {
        return TratamentoDAO.getInstance().getAllFinished();
    }

    public static void removerTratamento(Object id) {
        var all = ConsultaDAO.getInstance().retrieveAll();
        boolean canRemove = true;

        for(var item: all){
            if (((Consulta) item).getIdTratamento() == getIdFromIdString(id)){
                canRemove = false;
                break;
            }
        }

        if(canRemove){
            TratamentoDAO.remove(getIdFromIdString(id));
        } else{
            showMessageDialog(null, "Tratamento não pode ser excluído pois há uma consulta dessa tratamento\nremova a consulta antes", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static String[] getAllExamesToComboBox() {
        return ExameDAO.getInstance().getAllToComboBox();
    }

    public static void removerExame(Object id) {
        ExameDAO.remove(getIdFromIdString(id));
    }

    public static void removerConsulta(Object id) {
        int idConsulta = getIdFromIdString(id);
        var allExames = ExameDAO.getInstance().retrieveAll().stream().map(Exame.class::cast).toList();

        for(var item: allExames){
            if(item.getIdConsulta() == idConsulta){
                ExameDAO.remove(item.getId());
            }
        }

        ConsultaDAO.remove(idConsulta);
    }

    public static void removerEspecie(Object id) {
        int idEspecie = getIdFromIdString(id);
        var allAnimals = AnimalDAO.getInstance().retrieveAll().stream().map(Animal.class::cast).toList();
        boolean canRemove = true;

        for(var item: allAnimals){
            if(item.getIdEspecie() == idEspecie){
                canRemove = false;
                break;
            }
        }

        if(canRemove){
            EspecieDAO.remove(getIdFromIdString(id));
        } else{
            showMessageDialog(null, "Espécie não pode ser excluída pois há animais dessa espécie\natualize os animais antes", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
