package com.vet.view;

import com.vet.controller.Controller;
import com.vet.view.table.Flush;
import com.vet.view.table.impl.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 * Vet's project Main frame
 * @author Nicolas Canova
 */
public class Frame extends JFrame {

    public Frame() {
        initComponents();
    }

    private void initComponents() {

        JTabbedPane mainTabbedPane = new JTabbedPane();
        JPanel clientePanel = new JPanel();
        JTabbedPane clienteTabbedPane = new JTabbedPane();
        JPanel cadastrarClientePanel = new JPanel();
        JLabel nomeClienteLabel = new JLabel();
        nomeClienteTextField = new javax.swing.JTextField();
        JLabel cepClienteLabel = new JLabel();
        cepClienteTextField = new javax.swing.JTextField();
        JLabel enderecoClienteLabel = new JLabel();
        enderecoClienteTextField = new javax.swing.JTextField();
        JLabel telefoneClienteLabel = new JLabel();
        telefoneClienteTextField = new javax.swing.JTextField();
        emailClienteTextField = new javax.swing.JTextField();
        JLabel emailClienteLabel = new JLabel();
        JButton cadastrarClienteButton = new JButton();
        JPanel atualizarClientePanel = new JPanel();
        JLabel atualizarClienteLabel = new JLabel();
        atualizarClienteComboBox = new javax.swing.JComboBox<>();
        JLabel atualizarNomeClienteLabel = new JLabel();
        atualizarNomeClienteTextField = new javax.swing.JTextField();
        JLabel atualizarCepClienteLabel = new JLabel();
        atualizarCepClienteTextField = new javax.swing.JTextField();
        JLabel atualizarEnderecoClienteLabel = new JLabel();
        atualizarEnderecoClienteTextField = new javax.swing.JTextField();
        JLabel atualizarTelefoneClienteLabel = new JLabel();
        atualizarTelefoneClienteTextField = new javax.swing.JTextField();
        JLabel atualizarEmailClienteLabel = new JLabel();
        atualizarEmailClienteTextField = new javax.swing.JTextField();
        JButton atualizarClienteButton = new JButton();
        JPanel desativarClientePanel = new JPanel();
        JLabel desativarClienteLabel = new JLabel();
        desativarClienteComboBox = new javax.swing.JComboBox<>();
        JButton desativarClienteButton = new JButton();
        JPanel ativarClientePanel = new JPanel();
        JLabel ativarClienteLabel = new JLabel();
        ativarClienteComboBox = new javax.swing.JComboBox<>();
        JButton ativarClienteButton = new JButton();
        JScrollPane clienteScrollPane = new JScrollPane();
        JTable clienteTable = new JTable();
        JLabel filterByNameClienteLabel = new JLabel();
        filterByNameClienteTextField = new javax.swing.JTextField();
        JButton clearFilterByNameClienteButton = new JButton();
        JPanel animalPanel = new JPanel();
        JTabbedPane animalTabbedPane = new JTabbedPane();
        JPanel cadastrarAnimalPanel = new JPanel();
        JLabel especieAnimalLabel = new JLabel();
        JLabel nomeAnimalLabel = new JLabel();
        JLabel tutorLabel = new JLabel();
        JLabel anoNascimentoAnimalLabel = new JLabel();
        JLabel sexoAnimalLabel = new JLabel();
        nomeAnimalTextField = new javax.swing.JTextField();
        JButton cadastrarAnimalButton = new JButton();
        sexoAnimalComboBox = new javax.swing.JComboBox<>();
        anoNascimentoAnimalSpinner = new javax.swing.JSpinner();
        especieAnimalComboBox = new javax.swing.JComboBox<>();
        tutorComboBox = new javax.swing.JComboBox<>();
        JPanel cadastrarEspeciesPanel = new JPanel();
        JLabel nomeEspecieLabel = new JLabel();
        nomeEspecieTextField = new javax.swing.JTextField();
        JButton cadastrarEspecieButton = new JButton();
        JPanel atualizarAnimalPanel = new JPanel();
        JLabel atualizarAnimalLabel = new JLabel();
        atualizarAnimalComboBox = new javax.swing.JComboBox<>();
        JLabel atualizarTutorLabel = new JLabel();
        atualizarTutorComboBox = new javax.swing.JComboBox<>();
        JLabel atualizarEspecieLabel = new JLabel();
        atualizarEspecieAnimalComboBox = new javax.swing.JComboBox<>();
        JLabel atualizarNomeAnimalLabel = new JLabel();
        atualizarNomeAnimalTextField = new javax.swing.JTextField();
        JLabel atualizarAnoNascimentoAnimalLabel = new JLabel();
        atualizarAnoNascimentoAnimalSpinner = new javax.swing.JSpinner();
        JLabel atualizarSexoAnimalLabel = new JLabel();
        atualizarSexoAnimalComboBox = new javax.swing.JComboBox<>();
        JButton atualizarAnimalButton = new JButton();
        JPanel atualizarEspeciesPanel = new JPanel();
        JLabel atualizarNomeEspecieLabel = new JLabel();
        atualizarNomeEspecieTextField = new javax.swing.JTextField();
        JButton atualizarNomeEspecieButton = new JButton();
        JLabel selecionarEspecieAtualizarLabel = new JLabel();
        selecionarEspecieAtualizarComboBox = new javax.swing.JComboBox<>();
        JPanel desativarAnimalPanel = new JPanel();
        JLabel desativarAnimalLabel = new JLabel();
        desativarAnimalComboBox = new javax.swing.JComboBox<>();
        JButton desativarAnimalButton = new JButton();
        JPanel ativarAnimalPanel = new JPanel();
        JLabel ativarAnimalLabel = new JLabel();
        ativarAnimalComboBox = new javax.swing.JComboBox<>();
        JButton ativarAnimalButton = new JButton();
        JScrollPane animalScrollPane = new JScrollPane();
        JTable animalTable = new JTable();
        JLabel filterByNameAnimalLabel = new JLabel();
        filterByNameAnimalTextField = new javax.swing.JTextField();
        JButton clearFilterByNameAnimalButton = new JButton();
        JLabel filterByTutorAnimalLabel = new JLabel();
        filterByTutorAnimalTextField = new javax.swing.JTextField();
        JButton clearFilterByTutorAnimalButton = new JButton();
        JPanel veterinarioPanel = new JPanel();
        JTabbedPane veterinarioTabbedPane = new JTabbedPane();
        JPanel cadastrarVeterinarioTabbedPane = new JPanel();
        JLabel nomeVeterinarioLabel = new JLabel();
        nomeVeterinarioTextField = new javax.swing.JTextField();
        JLabel cepVeterinarioLabel = new JLabel();
        cepVeterinarioTextField = new javax.swing.JTextField();
        JLabel enderecoVeterinarioLabel = new JLabel();
        enderecoVeterinarioTextField = new javax.swing.JTextField();
        JLabel telefoneVeterinarioLabel = new JLabel();
        telefoneVeterinarioTextField = new javax.swing.JTextField();
        emailVeterinarioTextField = new javax.swing.JTextField();
        JLabel emailVeterinarioLabel = new JLabel();
        JButton cadastrarVeterinarioButton = new JButton();
        JPanel atualizarVeterinario = new JPanel();
        atualizarVeterinarioComboBox = new javax.swing.JComboBox<>();
        JLabel atualizarVeterinarioLabel = new JLabel();
        JButton atualizarVeterinarioButton = new JButton();
        atualizarEmailVeterinarioTextField = new javax.swing.JTextField();
        JLabel atualizarEmailVeterinarioLabel = new JLabel();
        atualizarTelefoneVeterinarioTextField = new javax.swing.JTextField();
        JLabel atualizarTelefoneVeterinarioLabel = new JLabel();
        atualizarEnderecoVeterinarioTextField = new javax.swing.JTextField();
        JLabel atualizarEnderecoVeterinarioLabel = new JLabel();
        atualizarCepVeterinarioTextField = new javax.swing.JTextField();
        JLabel atualizarCepVeterinarioLabel = new JLabel();
        atualizarNomeVeterinarioTextField = new javax.swing.JTextField();
        JLabel atualizarNomeVeterinarioLabel = new JLabel();
        JPanel desativarVeterinarioPanel = new JPanel();
        JLabel desativarVeterinarioLabel = new JLabel();
        desativarVeterinarioComboBox = new javax.swing.JComboBox<>();
        JButton desativarVeterinarioButton = new JButton();
        JPanel ativarVeterinarioPanel = new JPanel();
        JLabel ativarVeterinarioLabel = new JLabel();
        ativarVeterinarioComboBox = new javax.swing.JComboBox<>();
        JButton ativarVeterinarioButton = new JButton();
        JScrollPane veterinarioScrollPane = new JScrollPane();
        JTable veterinarioTable = new JTable();
        JLabel filterByNameVeterinarioLabel = new JLabel();
        filterByNameVeterinarioTextField = new javax.swing.JTextField();
        JButton clearFilterByNameVeterinarioButton = new JButton();
        JPanel consultaPanel = new JPanel();
        JTabbedPane consultaTabbedPane = new JTabbedPane();
        JPanel cadastrarConsulta = new JPanel();
        JLabel dataConsultaLabel = new JLabel();
        JLabel relatoConsultaLabel = new JLabel();
        JLabel veterinarioConsultaLabel = new JLabel();
        JButton cadastrarConsultaButton = new JButton();
        JLabel tratamentoConsultaLabel = new JLabel();
        tratamentoConsultaComboBox = new javax.swing.JComboBox<>();
        veterinarioConsultaComboBox = new javax.swing.JComboBox<>();
        diaConsultaSpinner = new javax.swing.JSpinner();
        mesConsultaSpinner = new javax.swing.JSpinner();
        anoConsultaSpinner = new javax.swing.JSpinner();
        JLabel diaConsultaLabel = new JLabel();
        JLabel mesConsultaLabel = new JLabel();
        JLabel anoConsultaLabel = new JLabel();
        JScrollPane relatoCadastrarConsultaScrollPane = new JScrollPane();
        relatoConsultaTextArea = new javax.swing.JTextArea();
        horarioConsultaComboBox = new javax.swing.JComboBox<>();
        JLabel horarioConsultaLabel = new JLabel();
        JPanel desativarConsultaPanel = new JPanel();
        JLabel finalizarConsultaLabel = new JLabel();
        finalizarConsultaComboBox = new javax.swing.JComboBox<>();
        JButton finalizarConsultaButton = new JButton();
        JScrollPane consultaScrollPane = new JScrollPane();
        JTable consultaTable = new JTable();
        JLabel filterByClienteConsultaLabel = new JLabel();
        filterByClienteConsultaTextField = new javax.swing.JTextField();
        JButton clearFilterByClienteConsultaButton = new JButton();
        JLabel filterByVeterinarioConsultaLabel = new JLabel();
        filterByVeterinarioConsultaTextField = new javax.swing.JTextField();
        JButton clearFilterByVeterinarioConsultaButton = new JButton();
        JLabel filterByAnimalConsultaLabel = new JLabel();
        filterByAnimalConsultaTextField = new javax.swing.JTextField();
        JButton clearFilterByAnimalConsultaButton = new JButton();
        orderByTerminadoConsultaToggleButton = new javax.swing.JToggleButton();
        JPanel examePanel = new JPanel();
        JTabbedPane exameTabbedPane = new JTabbedPane();
        JPanel cadastrarExamePanel = new JPanel();
        JLabel descricaoExameLabel = new JLabel();
        JLabel consultaExameLabel = new JLabel();
        JButton cadastrarExameButton = new JButton();
        consultaExameComboBox = new javax.swing.JComboBox<>();
        JScrollPane descricaoCadastrarExamePane = new JScrollPane();
        descricaoExameTextArea = new javax.swing.JTextArea();
        JScrollPane exameScrollPane = new JScrollPane();
        JTable exameTable = new JTable();
        JLabel filterByClienteExameLabel = new JLabel();
        filterByClienteExameTextField = new javax.swing.JTextField();
        JButton clearFilterByClienteExameButton = new JButton();
        JLabel filterByVeterinarioExameLabel = new JLabel();
        filterByVeterinarioExameTextField = new javax.swing.JTextField();
        JButton clearFilterByVeterinarioExameButton = new JButton();
        JLabel filterByAnimalExameLabel = new JLabel();
        filterByAnimalExameTextField = new javax.swing.JTextField();
        JButton clearFilterByAnimalExameButton = new JButton();
        JPanel tratamentoPanel = new JPanel();
        JTabbedPane tratamentoTabbedPane = new JTabbedPane();
        JPanel cadastrarTratamentoPanel = new JPanel();
        JLabel dataFimTratamentoLabel = new JLabel();
        JLabel animalTratamentoLabel = new JLabel();
        animalTratamentoComboBox = new javax.swing.JComboBox<>();
        JLabel dataInicioLabel = new JLabel();
        JButton cadastrarTratamentoButton = new JButton();
        diaFimTratamentoSpinner = new javax.swing.JSpinner();
        JLabel diaFimTratamentoLabel = new JLabel();
        JLabel mesFimTratamentoLabel = new JLabel();
        mesFimTratamentoSpinner = new javax.swing.JSpinner();
        JLabel anoFimTratamentoLabel = new JLabel();
        anoFimTratamentoSpinner = new javax.swing.JSpinner();
        diaInicioTratamentoSpinner = new javax.swing.JSpinner();
        JLabel diaInicioTratamentoLabel = new JLabel();
        JLabel mesInicioTratamentoLabel = new JLabel();
        mesInicioTratamentoSpinner = new javax.swing.JSpinner();
        JLabel anoInicioTratamentoLabel = new JLabel();
        anoInicioTratamentoSpinner = new javax.swing.JSpinner();
        dataFimTratamentoIndeterminadaCheckBox = new javax.swing.JCheckBox();
        JPanel finalizarTratamentoPanel = new JPanel();
        finalizarTratamentoComboBox = new javax.swing.JComboBox<>();
        JLabel finalizarTratamentoLabel = new JLabel();
        JButton finalizarTratamentoButton = new JButton();
        JScrollPane tratamentoScrollPane = new JScrollPane();
        JTable tratamentoTable = new JTable();
        JLabel filterByClienteTratamentoLabel = new JLabel();
        filterByClienteTratamentoTextField = new javax.swing.JTextField();
        JButton clearFilterByClienteTratamentoButton = new JButton();
        JLabel filterByAnimalTratamentoLabel = new JLabel();
        filterByAnimalTratamentoTextField = new javax.swing.JTextField();
        JButton clearFilterByAnimalTratamentoButton = new JButton();
        JLabel logoIcon = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeClienteLabel.setText("Nome Cliente");

        cepClienteLabel.setText("CEP Cliente");

        enderecoClienteLabel.setText("Endereço Cliente");

        telefoneClienteLabel.setText("Telefone Cliente");

        emailClienteLabel.setText("Email Cliente");

        cadastrarClienteButton.setText("Cadastrar");
        cadastrarClienteButton.addActionListener(e -> addCliente());

        javax.swing.GroupLayout cadastrarClientePanelLayout = new javax.swing.GroupLayout(cadastrarClientePanel);
        cadastrarClientePanel.setLayout(cadastrarClientePanelLayout);
        cadastrarClientePanelLayout.setHorizontalGroup(
            cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                .addGroup(cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(cadastrarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(emailClienteLabel))
                            .addGroup(cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailClienteTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(telefoneClienteTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(enderecoClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cepClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cepClienteLabel)
                                            .addComponent(enderecoClienteLabel)
                                            .addComponent(telefoneClienteLabel)))))))
                    .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(nomeClienteLabel)))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        cadastrarClientePanelLayout.setVerticalGroup(
            cadastrarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarClientePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nomeClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cepClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cepClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        clienteTabbedPane.addTab("Cadastrar Cliente", cadastrarClientePanel);

        atualizarClienteLabel.setText("Cliente");

        atualizarNomeClienteLabel.setText("Nome Cliente");

        atualizarCepClienteLabel.setText("CEP Cliente");

        atualizarEnderecoClienteLabel.setText("Endereço Cliente");

        atualizarTelefoneClienteLabel.setText("Telefone Cliente");

        atualizarEmailClienteLabel.setText("Email Cliente");

        atualizarClienteButton.setText("Atualizar");
        atualizarClienteButton.addActionListener(e -> updateCliente());

        javax.swing.GroupLayout atualizarClientePanelLayout = new javax.swing.GroupLayout(atualizarClientePanel);
        atualizarClientePanel.setLayout(atualizarClientePanelLayout);
        atualizarClientePanelLayout.setHorizontalGroup(
            atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, atualizarClientePanelLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(atualizarClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atualizarEmailClienteTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(atualizarTelefoneClienteTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(atualizarEnderecoClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(atualizarCepClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(atualizarNomeClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(atualizarClientePanelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(atualizarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(atualizarClientePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atualizarNomeClienteLabel)
                            .addComponent(atualizarCepClienteLabel)
                            .addComponent(atualizarEnderecoClienteLabel)
                            .addComponent(atualizarTelefoneClienteLabel)
                            .addComponent(atualizarEmailClienteLabel))))
                .addGap(52, 52, 52))
            .addGroup(atualizarClientePanelLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(atualizarClienteLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        atualizarClientePanelLayout.setVerticalGroup(
            atualizarClientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarClientePanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(atualizarClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarCepClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarCepClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEnderecoClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEnderecoClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTelefoneClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTelefoneClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEmailClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEmailClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        clienteTabbedPane.addTab("Atualizar Cliente", atualizarClientePanel);

        desativarClienteLabel.setText("Cliente");

        desativarClienteButton.setText("Desativar");
        desativarClienteButton.addActionListener(e -> desativarCliente());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(desativarClientePanel);
        desativarClientePanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desativarClienteComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(desativarClienteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(desativarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(desativarClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desativarClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desativarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );

        clienteTabbedPane.addTab("Desativar Cliente", desativarClientePanel);

        ativarClienteLabel.setText("Cliente");

        ativarClienteButton.setText("Ativar");
        ativarClienteButton.addActionListener(e -> ativarCliente());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(ativarClientePanel);
        ativarClientePanel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ativarClienteComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(ativarClienteLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(ativarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ativarClienteLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ativarClienteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ativarClienteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(434, Short.MAX_VALUE))
        );

        clienteTabbedPane.addTab("Ativar Cliente", ativarClientePanel);
        clienteTabbedPane.addChangeListener(e -> clienteTabbedPaneChangeListener());

        clienteTable.setModel(clienteTableModel);
        clienteScrollPane.setViewportView(clienteTable);

        filterByNameClienteLabel.setText("Filtrar por nome");
        filterByNameClienteTextField.addActionListener(this::filterByNameClienteTextFieldActionPerformed);

        clearFilterByNameClienteButton.setText("X");
        clearFilterByNameClienteButton.addActionListener(this::clearFilterByNameClienteButtonActionPerformed);

        javax.swing.GroupLayout clientePanelLayout = new javax.swing.GroupLayout(clientePanel);
        clientePanel.setLayout(clientePanelLayout);
        clientePanelLayout.setHorizontalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clientePanelLayout.createSequentialGroup()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(clienteScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 849, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(clientePanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(filterByNameClienteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByNameClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByNameClienteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(clienteTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        clientePanelLayout.setVerticalGroup(
            clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(clienteTabbedPane)
            .addGroup(clientePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clientePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByNameClienteLabel)
                    .addComponent(filterByNameClienteTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByNameClienteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteScrollPane))
        );

        mainTabbedPane.addTab("Cliente", clientePanel);
        mainTabbedPane.addChangeListener(e -> mainTabbedPaneChangeListener());

        especieAnimalLabel.setText("Espécie");

        nomeAnimalLabel.setText("Nome Animal");

        tutorLabel.setText("Cliente tutor do Animal");

        anoNascimentoAnimalLabel.setText("Ano de nascimento do Animal");

        sexoAnimalLabel.setText("Sexo Animal");

        cadastrarAnimalButton.setText("Cadastrar");
        cadastrarAnimalButton.addActionListener(e -> addAnimal());

        sexoAnimalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        javax.swing.GroupLayout cadastrarAnimalPanelLayout = new javax.swing.GroupLayout(cadastrarAnimalPanel);
        cadastrarAnimalPanel.setLayout(cadastrarAnimalPanelLayout);
        cadastrarAnimalPanelLayout.setHorizontalGroup(
            cadastrarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                .addGroup(cadastrarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(cadastrarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomeAnimalTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(especieAnimalComboBox, 0, 300, Short.MAX_VALUE)
                            .addComponent(tutorComboBox, 0, 300, Short.MAX_VALUE)
                            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(cadastrarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(especieAnimalLabel))
                            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(nomeAnimalLabel))
                            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(anoNascimentoAnimalLabel))
                            .addComponent(anoNascimentoAnimalSpinner)
                            .addComponent(sexoAnimalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(sexoAnimalLabel)))
                    .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(tutorLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadastrarAnimalPanelLayout.setVerticalGroup(
            cadastrarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarAnimalPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tutorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tutorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(especieAnimalLabel)
                .addGap(12, 12, 12)
                .addComponent(especieAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anoNascimentoAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anoNascimentoAnimalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexoAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sexoAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Cadastrar Animal", cadastrarAnimalPanel);
        animalTabbedPane.addChangeListener(e -> animalTabbedPaneChangeListener());

        nomeEspecieLabel.setText("Nome Espécie");

        cadastrarEspecieButton.setText("Cadastrar");
        cadastrarEspecieButton.addActionListener(e -> addEspecie());

        javax.swing.GroupLayout cadastrarEspeciesPanelLayout = new javax.swing.GroupLayout(cadastrarEspeciesPanel);
        cadastrarEspeciesPanel.setLayout(cadastrarEspeciesPanelLayout);
        cadastrarEspeciesPanelLayout.setHorizontalGroup(
            cadastrarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarEspeciesPanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(cadastrarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeEspecieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cadastrarEspeciesPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(cadastrarEspecieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(58, 58, 58))
            .addGroup(cadastrarEspeciesPanelLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(nomeEspecieLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadastrarEspeciesPanelLayout.setVerticalGroup(
            cadastrarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarEspeciesPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(nomeEspecieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeEspecieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarEspecieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Cadastrar Espécies", cadastrarEspeciesPanel);

        atualizarAnimalLabel.setText("Animal");

        atualizarTutorLabel.setText("Cliente tutor do Animal");

        atualizarEspecieLabel.setText("Espécie");

        atualizarNomeAnimalLabel.setText("Nome Animal");

        atualizarAnoNascimentoAnimalLabel.setText("Ano de nascimento do Animal");

        atualizarSexoAnimalLabel.setText("Sexo Animal");

        atualizarSexoAnimalComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        atualizarAnimalButton.setText("Atualizar");
        atualizarAnimalButton.addActionListener(e -> updateAnimal());

        javax.swing.GroupLayout atualizarAnimalPanelLayout = new javax.swing.GroupLayout(atualizarAnimalPanel);
        atualizarAnimalPanel.setLayout(atualizarAnimalPanelLayout);
        atualizarAnimalPanelLayout.setHorizontalGroup(
            atualizarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarAnimalPanelLayout.createSequentialGroup()
                .addGroup(atualizarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(atualizarAnimalPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(atualizarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(atualizarNomeAnimalTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(atualizarEspecieAnimalComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                            .addComponent(atualizarAnoNascimentoAnimalSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(atualizarTutorComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                            .addComponent(atualizarAnimalComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(atualizarSexoAnimalComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, atualizarAnimalPanelLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(atualizarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(atualizarNomeAnimalLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarAnoNascimentoAnimalLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarSexoAnimalLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarTutorLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarEspecieLabel, javax.swing.GroupLayout.Alignment.LEADING)))))
                    .addGroup(atualizarAnimalPanelLayout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(atualizarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(atualizarAnimalPanelLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(atualizarAnimalLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        atualizarAnimalPanelLayout.setVerticalGroup(
            atualizarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarAnimalPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(atualizarAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTutorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTutorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEspecieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizarEspecieAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarAnoNascimentoAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarAnoNascimentoAnimalSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarSexoAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarSexoAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Atualizar Animal", atualizarAnimalPanel);

        atualizarNomeEspecieLabel.setText("Nome Espécie");

        atualizarNomeEspecieButton.setText("Atualizar");
        atualizarNomeEspecieButton.addActionListener(e -> atualizarEspecie());

        selecionarEspecieAtualizarLabel.setText("Espécie");

        javax.swing.GroupLayout atualizarEspeciesPanelLayout = new javax.swing.GroupLayout(atualizarEspeciesPanel);
        atualizarEspeciesPanel.setLayout(atualizarEspeciesPanelLayout);
        atualizarEspeciesPanelLayout.setHorizontalGroup(
            atualizarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarEspeciesPanelLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(atualizarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(atualizarEspeciesPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(atualizarNomeEspecieLabel))
                    .addComponent(atualizarNomeEspecieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(atualizarEspeciesPanelLayout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(atualizarNomeEspecieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(atualizarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(selecionarEspecieAtualizarComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 300, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, atualizarEspeciesPanelLayout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(selecionarEspecieAtualizarLabel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        atualizarEspeciesPanelLayout.setVerticalGroup(
            atualizarEspeciesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarEspeciesPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(selecionarEspecieAtualizarLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selecionarEspecieAtualizarComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizarNomeEspecieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeEspecieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(atualizarNomeEspecieButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Atualizar Espécies", atualizarEspeciesPanel);

        desativarAnimalLabel.setText("Animal");

        desativarAnimalButton.setText("Desativar");
        desativarAnimalButton.addActionListener(e -> desativarAnimal());

        javax.swing.GroupLayout desativarAnimalPanelLayout = new javax.swing.GroupLayout(desativarAnimalPanel);
        desativarAnimalPanel.setLayout(desativarAnimalPanelLayout);
        desativarAnimalPanelLayout.setHorizontalGroup(
            desativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarAnimalPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(desativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(desativarAnimalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(desativarAnimalPanelLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(desativarAnimalLabel)))
                    .addGroup(desativarAnimalPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(desativarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
        desativarAnimalPanelLayout.setVerticalGroup(
            desativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarAnimalPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(desativarAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desativarAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(desativarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Desativar Animal", desativarAnimalPanel);

        ativarAnimalLabel.setText("Animal");

        ativarAnimalButton.setText("Ativar");
        ativarAnimalButton.addActionListener(e -> ativarAnimal());

        javax.swing.GroupLayout ativarAnimalPanelLayout = new javax.swing.GroupLayout(ativarAnimalPanel);
        ativarAnimalPanel.setLayout(ativarAnimalPanelLayout);
        ativarAnimalPanelLayout.setHorizontalGroup(
            ativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ativarAnimalPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(ativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ativarAnimalComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ativarAnimalPanelLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(ativarAnimalLabel)))
                    .addGroup(ativarAnimalPanelLayout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(ativarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71))
        );
        ativarAnimalPanelLayout.setVerticalGroup(
            ativarAnimalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ativarAnimalPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ativarAnimalLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ativarAnimalComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ativarAnimalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(389, Short.MAX_VALUE))
        );

        animalTabbedPane.addTab("Ativar Animal", ativarAnimalPanel);

        animalTable.setModel(animalTableModel);
        animalScrollPane.setViewportView(animalTable);

        filterByNameAnimalLabel.setText("Filtrar por nome");

        filterByNameAnimalTextField.addActionListener(this::filterByNameAnimalTextFieldActionPerformed);

        clearFilterByNameAnimalButton.setText("X");
        clearFilterByNameAnimalButton.addActionListener(this::clearFilterByNameAnimalButtonActionPerformed);

        filterByTutorAnimalLabel.setText("Filtrar por tutor");

        filterByTutorAnimalTextField.addActionListener(this::filterByTutorAnimalTextFieldActionPerformed);

        clearFilterByTutorAnimalButton.setText("X");
        clearFilterByTutorAnimalButton.addActionListener(this::clearFilterByTutorAnimalButtonActionPerformed);

        javax.swing.GroupLayout animalPanelLayout = new javax.swing.GroupLayout(animalPanel);
        animalPanel.setLayout(animalPanelLayout);
        animalPanelLayout.setHorizontalGroup(
            animalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, animalPanelLayout.createSequentialGroup()
                .addGroup(animalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(animalPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(animalScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(animalPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(filterByNameAnimalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByNameAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByNameAnimalButton)
                        .addGap(18, 18, 18)
                        .addComponent(filterByTutorAnimalLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByTutorAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByTutorAnimalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(animalTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        animalPanelLayout.setVerticalGroup(
            animalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(animalTabbedPane)
            .addGroup(animalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(animalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByNameAnimalLabel)
                    .addComponent(filterByNameAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByNameAnimalButton)
                    .addGroup(animalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterByTutorAnimalLabel)
                        .addComponent(filterByTutorAnimalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearFilterByTutorAnimalButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(animalScrollPane))
        );

        mainTabbedPane.addTab("Animal", animalPanel);

        nomeVeterinarioLabel.setText("Nome Veterinário");

        cepVeterinarioLabel.setText("CEP Veterinário");

        enderecoVeterinarioLabel.setText("Endereço Veterinário");

        telefoneVeterinarioLabel.setText("Telefone Veterinário");

        emailVeterinarioLabel.setText("Email Veterinário");

        cadastrarVeterinarioButton.setText("Cadastrar");
        cadastrarVeterinarioButton.addActionListener(e -> addVeterinario());

        javax.swing.GroupLayout cadastrarVeterinarioLayout = new javax.swing.GroupLayout(cadastrarVeterinarioTabbedPane);
        cadastrarVeterinarioTabbedPane.setLayout(cadastrarVeterinarioLayout);
        cadastrarVeterinarioLayout.setHorizontalGroup(
            cadastrarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                .addGroup(cadastrarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(cadastrarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(telefoneVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cepVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(enderecoVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(cadastrarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cepVeterinarioLabel)
                                    .addComponent(enderecoVeterinarioLabel)
                                    .addComponent(telefoneVeterinarioLabel)
                                    .addComponent(emailVeterinarioLabel)))))
                    .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(cadastrarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(nomeVeterinarioLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cadastrarVeterinarioLayout.setVerticalGroup(
            cadastrarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarVeterinarioLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(nomeVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cepVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cepVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(telefoneVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cadastrarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        veterinarioTabbedPane.addTab("Cadastrar Veterinário", cadastrarVeterinarioTabbedPane);
        veterinarioTabbedPane.addChangeListener(e -> veterinarioTabbedPaneChangeListener());

        atualizarVeterinarioLabel.setText("Veterinário");

        atualizarVeterinarioButton.setText("Atualizar");
        atualizarVeterinarioButton.addActionListener(e -> updateVeterinario());

        atualizarEmailVeterinarioLabel.setText("Email Veterinário");

        atualizarTelefoneVeterinarioLabel.setText("Telefone Veterinário");

        atualizarEnderecoVeterinarioLabel.setText("Endereço Veterinário");

        atualizarCepVeterinarioLabel.setText("CEP Veterinário");

        atualizarNomeVeterinarioLabel.setText("Nome Veterinário");

        javax.swing.GroupLayout atualizarVeterinarioLayout = new javax.swing.GroupLayout(atualizarVeterinario);
        atualizarVeterinario.setLayout(atualizarVeterinarioLayout);
        atualizarVeterinarioLayout.setHorizontalGroup(
            atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                .addGroup(atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(atualizarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(atualizarEmailVeterinarioTextField)
                                .addComponent(atualizarTelefoneVeterinarioTextField)
                                .addComponent(atualizarCepVeterinarioTextField)
                                .addComponent(atualizarNomeVeterinarioTextField)
                                .addComponent(atualizarEnderecoVeterinarioTextField)
                                .addComponent(atualizarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(atualizarNomeVeterinarioLabel)
                                    .addComponent(atualizarCepVeterinarioLabel)
                                    .addComponent(atualizarEnderecoVeterinarioLabel)
                                    .addComponent(atualizarTelefoneVeterinarioLabel)
                                    .addComponent(atualizarEmailVeterinarioLabel)))))
                    .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(atualizarVeterinarioLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        atualizarVeterinarioLayout.setVerticalGroup(
            atualizarVeterinarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atualizarVeterinarioLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(atualizarVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarNomeVeterinarioLabel)
                .addGap(12, 12, 12)
                .addComponent(atualizarNomeVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarCepVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarCepVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEnderecoVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEnderecoVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTelefoneVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarTelefoneVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEmailVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(atualizarEmailVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atualizarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        veterinarioTabbedPane.addTab("Atualizar Veterinário", atualizarVeterinario);

        desativarVeterinarioLabel.setText("Veterinário");

        desativarVeterinarioButton.setText("Desativar");
        desativarVeterinarioButton.addActionListener(e -> desativarVeterinario());

        javax.swing.GroupLayout desativarVeterinarioPanelLayout = new javax.swing.GroupLayout(desativarVeterinarioPanel);
        desativarVeterinarioPanel.setLayout(desativarVeterinarioPanelLayout);
        desativarVeterinarioPanelLayout.setHorizontalGroup(
            desativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarVeterinarioPanelLayout.createSequentialGroup()
                .addGroup(desativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desativarVeterinarioPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(desativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(desativarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(desativarVeterinarioPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(desativarVeterinarioLabel))))
                    .addGroup(desativarVeterinarioPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(desativarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desativarVeterinarioPanelLayout.setVerticalGroup(
            desativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarVeterinarioPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(desativarVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desativarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(desativarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        veterinarioTabbedPane.addTab("Desativar Veterinário", desativarVeterinarioPanel);

        ativarVeterinarioLabel.setText("Veterinário");

        ativarVeterinarioButton.setText("Ativar");
        ativarVeterinarioButton.addActionListener(e -> ativarVeterinario());

        javax.swing.GroupLayout ativarVeterinarioPanelLayout = new javax.swing.GroupLayout(ativarVeterinarioPanel);
        ativarVeterinarioPanel.setLayout(ativarVeterinarioPanelLayout);
        ativarVeterinarioPanelLayout.setHorizontalGroup(
            ativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ativarVeterinarioPanelLayout.createSequentialGroup()
                .addGroup(ativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ativarVeterinarioPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(ativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ativarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ativarVeterinarioPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(ativarVeterinarioLabel))))
                    .addGroup(ativarVeterinarioPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(ativarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ativarVeterinarioPanelLayout.setVerticalGroup(
            ativarVeterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ativarVeterinarioPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ativarVeterinarioLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ativarVeterinarioComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ativarVeterinarioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        veterinarioTabbedPane.addTab("Ativar Veterinário", ativarVeterinarioPanel);

        veterinarioTable.setModel(veterinarioTableModel);
        veterinarioScrollPane.setViewportView(veterinarioTable);

        filterByNameVeterinarioLabel.setText("Filtrar por nome");

        filterByNameVeterinarioTextField.addActionListener(this::filterByNameVeterinarioTextFieldActionPerformed);

        clearFilterByNameVeterinarioButton.setText("X");
        clearFilterByNameVeterinarioButton.addActionListener(this::clearFilterByNameVeterinarioButtonActionPerformed);

        javax.swing.GroupLayout veterinarioPanelLayout = new javax.swing.GroupLayout(veterinarioPanel);
        veterinarioPanel.setLayout(veterinarioPanelLayout);
        veterinarioPanelLayout.setHorizontalGroup(
            veterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, veterinarioPanelLayout.createSequentialGroup()
                .addGroup(veterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(veterinarioPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(veterinarioScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(veterinarioPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(filterByNameVeterinarioLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByNameVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByNameVeterinarioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(veterinarioTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        veterinarioPanelLayout.setVerticalGroup(
            veterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(veterinarioTabbedPane)
            .addGroup(veterinarioPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(veterinarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByNameVeterinarioLabel)
                    .addComponent(filterByNameVeterinarioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByNameVeterinarioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(veterinarioScrollPane))
        );

        mainTabbedPane.addTab("Veterinário", veterinarioPanel);

        dataConsultaLabel.setText("Data");

        relatoConsultaLabel.setText("Relato consulta");

        veterinarioConsultaLabel.setText("Veterinário");

        cadastrarConsultaButton.setText("Cadastrar");
        cadastrarConsultaButton.addActionListener(e -> addConsulta());

        tratamentoConsultaLabel.setText("Tratamento");

        diaConsultaSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        mesConsultaSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        anoConsultaSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        diaConsultaLabel.setText("Dia");

        mesConsultaLabel.setText("Mês");

        anoConsultaLabel.setText("Ano");

        relatoConsultaTextArea.setColumns(20);
        relatoConsultaTextArea.setRows(5);
        relatoCadastrarConsultaScrollPane.setViewportView(relatoConsultaTextArea);

        horarioConsultaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "8", "9", "10", "11", "12", "13", "14", "15", "16", "17" }));

        horarioConsultaLabel.setText("Horário");

        javax.swing.GroupLayout cadastrarConsultaLayout = new javax.swing.GroupLayout(cadastrarConsulta);
        cadastrarConsulta.setLayout(cadastrarConsultaLayout);
        cadastrarConsultaLayout.setHorizontalGroup(
            cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tratamentoConsultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(relatoCadastrarConsultaScrollPane, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, cadastrarConsultaLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(relatoConsultaLabel)
                                    .addComponent(tratamentoConsultaLabel)
                                    .addComponent(veterinarioConsultaLabel)))
                            .addComponent(veterinarioConsultaComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(horarioConsultaComboBox, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addComponent(cadastrarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(11, 11, 11)))
                    .addComponent(dataConsultaLabel))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                        .addComponent(horarioConsultaLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                        .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(diaConsultaLabel)
                            .addComponent(diaConsultaSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mesConsultaSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(mesConsultaLabel))
                        .addGap(18, 18, 18)
                        .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(anoConsultaSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(anoConsultaLabel))
                        .addGap(117, 117, 117))))
        );
        cadastrarConsultaLayout.setVerticalGroup(
            cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarConsultaLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaConsultaLabel)
                    .addComponent(mesConsultaLabel)
                    .addComponent(anoConsultaLabel)
                    .addComponent(dataConsultaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarConsultaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaConsultaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesConsultaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoConsultaSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(horarioConsultaLabel)
                .addGap(12, 12, 12)
                .addComponent(horarioConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(relatoConsultaLabel)
                .addGap(11, 11, 11)
                .addComponent(relatoCadastrarConsultaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tratamentoConsultaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tratamentoConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(veterinarioConsultaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(veterinarioConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        consultaTabbedPane.addTab("Cadastrar Consulta", cadastrarConsulta);
        consultaTabbedPane.addChangeListener(e -> consultaTabbedPaneChangeListener());

        finalizarConsultaLabel.setText("Consulta");

        finalizarConsultaButton.setText("Finalizar");
        finalizarConsultaButton.addActionListener(e -> finalizarConsulta());

        javax.swing.GroupLayout desativarConsultaPanelLayout = new javax.swing.GroupLayout(desativarConsultaPanel);
        desativarConsultaPanel.setLayout(desativarConsultaPanelLayout);
        desativarConsultaPanelLayout.setHorizontalGroup(
            desativarConsultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarConsultaPanelLayout.createSequentialGroup()
                .addGroup(desativarConsultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desativarConsultaPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(desativarConsultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalizarConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(desativarConsultaPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(finalizarConsultaLabel))))
                    .addGroup(desativarConsultaPanelLayout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(finalizarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        desativarConsultaPanelLayout.setVerticalGroup(
            desativarConsultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desativarConsultaPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(finalizarConsultaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizarConsultaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalizarConsultaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        consultaTabbedPane.addTab("Finalizar Consulta", desativarConsultaPanel);

        consultaTable.setModel(consultaTableModel);
        consultaScrollPane.setViewportView(consultaTable);

        filterByClienteConsultaLabel.setText("Filtrar por Cliente");

        filterByClienteConsultaTextField.addActionListener(this::filterByClienteConsultaTextFieldActionPerformed);

        clearFilterByClienteConsultaButton.setText("X");
        clearFilterByClienteConsultaButton.addActionListener(this::clearFilterByClienteConsultaButtonActionPerformed);

        filterByVeterinarioConsultaLabel.setText("Filtrar por Veterinario");

        filterByVeterinarioConsultaTextField.addActionListener(this::filterByVeterinarioConsultaTextFieldActionPerformed);

        clearFilterByVeterinarioConsultaButton.setText("X");
        clearFilterByVeterinarioConsultaButton.addActionListener(this::clearFilterByVeterinarioConsultaButtonActionPerformed);

        filterByAnimalConsultaLabel.setText("Filtrar por Animal");

        filterByAnimalConsultaTextField.addActionListener(this::filterByAnimalConsultaTextFieldActionPerformed);

        clearFilterByAnimalConsultaButton.setText("X");
        clearFilterByAnimalConsultaButton.addActionListener(this::clearFilterByAnimalConsultaButtonActionPerformed);

        orderByTerminadoConsultaToggleButton.setText("Ordenar por Terminado");
        orderByTerminadoConsultaToggleButton.addActionListener(this::orderByTerminadoConsultaToggleButtonActionPerformed);

        javax.swing.GroupLayout consultaPanelLayout = new javax.swing.GroupLayout(consultaPanel);
        consultaPanel.setLayout(consultaPanelLayout);
        consultaPanelLayout.setHorizontalGroup(
            consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaPanelLayout.createSequentialGroup()
                .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(consultaPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(consultaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(consultaPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(consultaPanelLayout.createSequentialGroup()
                                .addComponent(filterByAnimalConsultaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterByAnimalConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterByAnimalConsultaButton))
                            .addGroup(consultaPanelLayout.createSequentialGroup()
                                .addComponent(filterByClienteConsultaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterByClienteConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterByClienteConsultaButton)))
                        .addGap(18, 18, 18)
                        .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(consultaPanelLayout.createSequentialGroup()
                                .addComponent(filterByVeterinarioConsultaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterByVeterinarioConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterByVeterinarioConsultaButton))
                            .addGroup(consultaPanelLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(orderByTerminadoConsultaToggleButton)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(consultaTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        consultaPanelLayout.setVerticalGroup(
            consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(consultaTabbedPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByClienteConsultaLabel)
                    .addComponent(filterByClienteConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByClienteConsultaButton)
                    .addComponent(filterByVeterinarioConsultaLabel)
                    .addComponent(filterByVeterinarioConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByVeterinarioConsultaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(consultaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByAnimalConsultaLabel)
                    .addComponent(filterByAnimalConsultaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByAnimalConsultaButton)
                    .addComponent(orderByTerminadoConsultaToggleButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(consultaScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainTabbedPane.addTab("Consulta", consultaPanel);

        descricaoExameLabel.setText("Descrição");

        consultaExameLabel.setText("Consulta");

        cadastrarExameButton.setText("Cadastrar");
        cadastrarExameButton.addActionListener(e -> addExame());

        descricaoExameTextArea.setColumns(20);
        descricaoExameTextArea.setRows(5);
        descricaoCadastrarExamePane.setViewportView(descricaoExameTextArea);

        javax.swing.GroupLayout cadastrarExamePanelLayout = new javax.swing.GroupLayout(cadastrarExamePanel);
        cadastrarExamePanel.setLayout(cadastrarExamePanelLayout);
        cadastrarExamePanelLayout.setHorizontalGroup(
            cadastrarExamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarExamePanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(descricaoExameLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarExamePanelLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(cadastrarExamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarExamePanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(consultaExameLabel))
                    .addGroup(cadastrarExamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(descricaoCadastrarExamePane, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(consultaExameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(cadastrarExamePanelLayout.createSequentialGroup()
                            .addComponent(cadastrarExameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(103, 103, 103))))
                .addGap(58, 58, 58))
        );
        cadastrarExamePanelLayout.setVerticalGroup(
            cadastrarExamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarExamePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(descricaoExameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricaoCadastrarExamePane, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultaExameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultaExameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarExameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(228, Short.MAX_VALUE))
        );

        exameTabbedPane.addTab("Cadastrar Exame", cadastrarExamePanel);
        exameTabbedPane.addChangeListener(e -> exameTabbedPaneChangeListener());

        exameTable.setModel(exameTableModel);
        exameScrollPane.setViewportView(exameTable);

        filterByClienteExameLabel.setText("Filtrar por Cliente");

        filterByClienteExameTextField.addActionListener(this::filterByClienteExameTextFieldActionPerformed);

        clearFilterByClienteExameButton.setText("X");
        clearFilterByClienteExameButton.addActionListener(this::clearFilterByClienteExameButtonActionPerformed);

        filterByVeterinarioExameLabel.setText("Filtrar por Veterinario");

        filterByVeterinarioExameTextField.addActionListener(this::filterByVeterinarioExameTextFieldActionPerformed);

        clearFilterByVeterinarioExameButton.setText("X");
        clearFilterByVeterinarioExameButton.addActionListener(this::clearFilterByVeterinarioExameButtonActionPerformed);

        filterByAnimalExameLabel.setText("Filtrar por Animal");

        filterByAnimalExameTextField.addActionListener(this::filterByAnimalExameTextFieldActionPerformed);

        clearFilterByAnimalExameButton.setText("X");
        clearFilterByAnimalExameButton.addActionListener(this::clearFilterByAnimalExameButtonActionPerformed);

        javax.swing.GroupLayout examePanelLayout = new javax.swing.GroupLayout(examePanel);
        examePanel.setLayout(examePanelLayout);
        examePanelLayout.setHorizontalGroup(
            examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, examePanelLayout.createSequentialGroup()
                .addGroup(examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(examePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(exameScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(examePanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(examePanelLayout.createSequentialGroup()
                                .addComponent(filterByAnimalExameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterByAnimalExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterByAnimalExameButton))
                            .addGroup(examePanelLayout.createSequentialGroup()
                                .addComponent(filterByClienteExameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterByClienteExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterByClienteExameButton)))
                        .addGap(18, 18, 18)
                        .addComponent(filterByVeterinarioExameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByVeterinarioExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByVeterinarioExameButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(exameTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        examePanelLayout.setVerticalGroup(
            examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exameTabbedPane)
            .addGroup(examePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByClienteExameLabel)
                    .addComponent(filterByClienteExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByClienteExameButton)
                    .addComponent(filterByVeterinarioExameLabel)
                    .addComponent(filterByVeterinarioExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByVeterinarioExameButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(examePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByAnimalExameLabel)
                    .addComponent(filterByAnimalExameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByAnimalExameButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exameScrollPane))
        );

        mainTabbedPane.addTab("Exame", examePanel);

        dataFimTratamentoLabel.setText("Data fim");

        animalTratamentoLabel.setText("Animal");

        dataInicioLabel.setText("Data Início");

        cadastrarTratamentoButton.setText("Cadastrar");
        cadastrarTratamentoButton.addActionListener(e -> addTratamento());

        diaFimTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        diaFimTratamentoLabel.setText("Dia");

        mesFimTratamentoLabel.setText("Mês");

        mesFimTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        anoFimTratamentoLabel.setText("Ano");

        anoFimTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        diaInicioTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        diaInicioTratamentoLabel.setText("Dia");

        mesInicioTratamentoLabel.setText("Mês");

        mesInicioTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        anoInicioTratamentoLabel.setText("Ano");

        anoInicioTratamentoSpinner.setMinimumSize(new java.awt.Dimension(80, 22));

        dataFimTratamentoIndeterminadaCheckBox.setText("Data fim Indeterminada");

        javax.swing.GroupLayout cadastrarTratamentoPanelLayout = new javax.swing.GroupLayout(cadastrarTratamentoPanel);
        cadastrarTratamentoPanel.setLayout(cadastrarTratamentoPanelLayout);
        cadastrarTratamentoPanelLayout.setHorizontalGroup(
            cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                        .addComponent(dataFimTratamentoIndeterminadaCheckBox)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                        .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(animalTratamentoComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                        .addComponent(dataInicioLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addComponent(diaInicioTratamentoLabel))
                                    .addComponent(diaInicioTratamentoSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                        .addGap(82, 82, 82)
                                        .addComponent(mesInicioTratamentoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(anoInicioTratamentoLabel))
                                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mesInicioTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(anoInicioTratamentoSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                            .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                .addComponent(animalTratamentoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cadastrarTratamentoPanelLayout.createSequentialGroup()
                                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                                        .addComponent(dataFimTratamentoLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(diaFimTratamentoLabel))
                                    .addComponent(diaFimTratamentoSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(mesFimTratamentoSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mesFimTratamentoLabel))
                                .addGap(6, 6, 6)
                                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(anoFimTratamentoSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(anoFimTratamentoLabel))))
                        .addGap(59, 59, 59))))
            .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(cadastrarTratamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cadastrarTratamentoPanelLayout.setVerticalGroup(
            cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cadastrarTratamentoPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mesInicioTratamentoLabel)
                    .addComponent(anoInicioTratamentoLabel)
                    .addComponent(dataInicioLabel)
                    .addComponent(diaInicioTratamentoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaInicioTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesInicioTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoInicioTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaFimTratamentoLabel)
                    .addComponent(mesFimTratamentoLabel)
                    .addComponent(anoFimTratamentoLabel)
                    .addComponent(dataFimTratamentoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cadastrarTratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diaFimTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mesFimTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoFimTratamentoSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dataFimTratamentoIndeterminadaCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(animalTratamentoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(animalTratamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarTratamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tratamentoTabbedPane.addTab("Cadastrar Tratamento", cadastrarTratamentoPanel);
        tratamentoTabbedPane.addChangeListener(e -> tratamentoTabbedPaneChangeListener());

        finalizarTratamentoLabel.setText("Tratamento");

        finalizarTratamentoButton.setText("Finalizar");
        finalizarTratamentoButton.addActionListener(e -> finalizarTratamento());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(finalizarTratamentoPanel);
        finalizarTratamentoPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(finalizarTratamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(finalizarTratamentoLabel))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(finalizarTratamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(finalizarTratamentoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizarTratamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizarTratamentoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(467, Short.MAX_VALUE))
        );

        tratamentoTabbedPane.addTab("Finalizar Tratamento", finalizarTratamentoPanel);

        tratamentoTable.setModel(tratamentoTableModel);
        tratamentoScrollPane.setViewportView(tratamentoTable);

        filterByClienteTratamentoLabel.setText("Filtrar por Cliente");

        filterByClienteTratamentoTextField.addActionListener(this::filterByClienteTratamentoTextFieldActionPerformed);

        clearFilterByClienteTratamentoButton.setText("X");
        clearFilterByClienteTratamentoButton.addActionListener(this::clearFilterByClienteTratamentoButtonActionPerformed);

        filterByAnimalTratamentoLabel.setText("Filtrar por Animal");

        filterByAnimalTratamentoTextField.addActionListener(this::filterByAnimalTratamentoTextFieldActionPerformed);

        clearFilterByAnimalTratamentoButton.setText("X");
        clearFilterByAnimalTratamentoButton.addActionListener(this::clearFilterByAnimalTratamentoButtonActionPerformed);

        javax.swing.GroupLayout tratamentoPanelLayout = new javax.swing.GroupLayout(tratamentoPanel);
        tratamentoPanel.setLayout(tratamentoPanelLayout);
        tratamentoPanelLayout.setHorizontalGroup(
            tratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tratamentoPanelLayout.createSequentialGroup()
                .addGroup(tratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tratamentoPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tratamentoScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(tratamentoPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(filterByClienteTratamentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByClienteTratamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByClienteTratamentoButton)
                        .addGap(18, 18, 18)
                        .addComponent(filterByAnimalTratamentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByAnimalTratamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFilterByAnimalTratamentoButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(tratamentoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tratamentoPanelLayout.setVerticalGroup(
            tratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tratamentoTabbedPane)
            .addGroup(tratamentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tratamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByClienteTratamentoLabel)
                    .addComponent(filterByClienteTratamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByClienteTratamentoButton)
                    .addComponent(filterByAnimalTratamentoLabel)
                    .addComponent(filterByAnimalTratamentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearFilterByAnimalTratamentoButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tratamentoScrollPane))
        );

        mainTabbedPane.addTab("Tratamento", tratamentoPanel);

        logoIcon.setIcon(new ImageIcon("src/main/java/com/vet/img/clinicaveterinaria.png"));
        logoIcon.setMaximumSize(new java.awt.Dimension(32, 32));
        logoIcon.setMinimumSize(new java.awt.Dimension(32, 32));
        logoIcon.setPreferredSize(new java.awt.Dimension(64, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(logoIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(mainTabbedPane)
                .addContainerGap())
        );

        pack();
        flushAllTables();
        flushAllComboBox();
        flushAllSpinner();
        flushAllTextInput();
        this.setTitle("Clínica Veterinária");
    }

    private void filterByNameClienteTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        clienteTableModel.clear();
        clienteTableModel.addListOfItems(Controller.getAllClienteBySimilarName(filterByNameClienteTextField.getText()));
    }

    private void clearFilterByNameClienteButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByNameClienteTextField.setText("");
        flushTable(Flush.CLIENTE);
    }

    private void filterByNameAnimalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        animalTableModel.clear();
        animalTableModel.addListOfItems(Controller.getAllAnimalBySimilarName(filterByNameAnimalTextField.getText()));
    }

    private void clearFilterByNameAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByNameAnimalTextField.setText("");
        flushTable(Flush.ANIMAL);
    }

    private void filterByTutorAnimalTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        animalTableModel.clear();
        animalTableModel.addListOfItems(Controller.getAllAnimalByTutorName(filterByTutorAnimalTextField.getText()));
    }

    private void clearFilterByTutorAnimalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByTutorAnimalTextField.setText("");
        flushTable(Flush.ANIMAL);
    }

    private void filterByNameVeterinarioTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        veterinarioTableModel.clear();
        veterinarioTableModel.addListOfItems(Controller.getAllVeterinarioBySimilarName(filterByNameVeterinarioTextField.getText()));
    }

    private void clearFilterByNameVeterinarioButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByNameVeterinarioTextField.setText("");
        flushTable(Flush.VETERINARIO);
    }

    private void filterByClienteConsultaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        consultaTableModel.clear();
        consultaTableModel.addListOfItems(Controller.getAllConsultaByClienteName(filterByClienteConsultaTextField.getText()));
    }

    private void clearFilterByClienteConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByClienteConsultaTextField.setText("");
        flushTable(Flush.CONSULTA);
    }

    private void filterByVeterinarioConsultaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        consultaTableModel.clear();
        consultaTableModel.addListOfItems(Controller.getAllConsultaByVeterinarioName(filterByVeterinarioConsultaTextField.getText()));
    }

    private void clearFilterByVeterinarioConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByVeterinarioConsultaTextField.setText("");
        flushTable(Flush.CONSULTA);
    }

    private void filterByAnimalConsultaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        consultaTableModel.clear();
        consultaTableModel.addListOfItems(Controller.getAllConsultaByAnimalName(filterByAnimalConsultaTextField.getText()));
    }

    private void clearFilterByAnimalConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByAnimalConsultaTextField.setText("");
        flushTable(Flush.CONSULTA);
    }

    private void orderByTerminadoConsultaToggleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(orderByTerminadoConsultaToggleButton.isSelected()){
            Controller.addConsultaOrderByTerminadoClause();
        } else {
            Controller.removeConsultaOrderByTerminadoClause();
        }
        consultaTableModel.addListOfItems(Controller.getAllConsultaByAnimalName(filterByAnimalConsultaTextField.getText()));
    }

    private void filterByClienteExameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        exameTableModel.clear();
        exameTableModel.addListOfItems(Controller.getAllExameByClienteName(filterByClienteExameTextField.getText()));
    }

    private void clearFilterByClienteExameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByClienteExameTextField.setText("");
        flushTable(Flush.EXAME);
    }

    private void filterByVeterinarioExameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        exameTableModel.clear();
        exameTableModel.addListOfItems(Controller.getAllExameByVeterinarioName(filterByVeterinarioExameTextField.getText()));
    }

    private void clearFilterByVeterinarioExameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByVeterinarioExameTextField.setText("");
        flushTable(Flush.EXAME);
    }

    private void filterByAnimalExameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        exameTableModel.clear();
        exameTableModel.addListOfItems(Controller.getAllExameByAnimalName(filterByAnimalExameTextField.getText()));
    }

    private void clearFilterByAnimalExameButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByClienteTratamentoTextField.setText("");
        flushTable(Flush.EXAME);
    }

    private void filterByClienteTratamentoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        tratamentoTableModel.clear();
        tratamentoTableModel.addListOfItems(Controller.getAllTratamentoByClienteName(filterByClienteTratamentoTextField.getText()));
    }

    private void clearFilterByClienteTratamentoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByClienteTratamentoTextField.setText("");
        flushTable(Flush.TRATAMENTO);
    }

    private void filterByAnimalTratamentoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {
        tratamentoTableModel.clear();
        tratamentoTableModel.addListOfItems(Controller.getAllTratamentoByAnimalName(filterByAnimalTratamentoTextField.getText()));
    }

    private void clearFilterByAnimalTratamentoButtonActionPerformed(java.awt.event.ActionEvent evt) {
        filterByAnimalTratamentoTextField.setText("");
        flushTable(Flush.TRATAMENTO);
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
    }

    // SPINNER
    private JSpinner anoConsultaSpinner;
    private JSpinner anoFimTratamentoSpinner;
    private JSpinner anoInicioTratamentoSpinner;
    private JSpinner atualizarAnoNascimentoAnimalSpinner;
    private JSpinner diaConsultaSpinner;
    private JSpinner diaFimTratamentoSpinner;
    private JSpinner diaInicioTratamentoSpinner;
    private JSpinner anoNascimentoAnimalSpinner;
    private JSpinner mesConsultaSpinner;
    private JSpinner mesFimTratamentoSpinner;
    private JSpinner mesInicioTratamentoSpinner;


    // TEXT FIELD
    private JTextField atualizarCepClienteTextField;
    private JTextField atualizarCepVeterinarioTextField;
    private JTextField atualizarEmailClienteTextField;
    private JTextField atualizarEmailVeterinarioTextField;
    private JTextField atualizarEnderecoClienteTextField;
    private JTextField atualizarEnderecoVeterinarioTextField;
    private JTextField atualizarNomeAnimalTextField;
    private JTextField atualizarNomeClienteTextField;
    private JTextField atualizarNomeEspecieTextField;
    private JTextField atualizarNomeVeterinarioTextField;
    private JTextField atualizarTelefoneClienteTextField;
    private JTextField atualizarTelefoneVeterinarioTextField;
    private JTextField cepClienteTextField;
    private JTextField cepVeterinarioTextField;
    private JTextField emailClienteTextField;
    private JTextField emailVeterinarioTextField;
    private JTextField enderecoClienteTextField;
    private JTextField enderecoVeterinarioTextField;
    private JTextField filterByAnimalConsultaTextField;
    private JTextField filterByAnimalExameTextField;
    private JTextField filterByAnimalTratamentoTextField;
    private JTextField filterByClienteConsultaTextField;
    private JTextField filterByClienteExameTextField;
    private JTextField filterByClienteTratamentoTextField;
    private JTextField filterByNameAnimalTextField;
    private JTextField filterByNameClienteTextField;
    private JTextField filterByNameVeterinarioTextField;
    private JTextField filterByTutorAnimalTextField;
    private JTextField filterByVeterinarioConsultaTextField;
    private JTextField filterByVeterinarioExameTextField;
    private JTextField nomeAnimalTextField;
    private JTextField nomeClienteTextField;
    private JTextField nomeEspecieTextField;
    private JTextField nomeVeterinarioTextField;
    private JTextField telefoneClienteTextField;
    private JTextField telefoneVeterinarioTextField;


    // CHECK BOX
    private JCheckBox dataFimTratamentoIndeterminadaCheckBox;


    // TEXT AREA
    private JTextArea descricaoExameTextArea;
    private JTextArea relatoConsultaTextArea;


    // TOGGLE BUTTON
    private JToggleButton orderByTerminadoConsultaToggleButton;


    // COMBO BOX
    private JComboBox<String> animalTratamentoComboBox;
    private JComboBox<String> ativarAnimalComboBox;
    private JComboBox<String> ativarClienteComboBox;
    private JComboBox<String> ativarVeterinarioComboBox;
    private JComboBox<String> atualizarAnimalComboBox;
    private JComboBox<String> atualizarClienteComboBox;
    private JComboBox<String> atualizarEspecieAnimalComboBox;
    private JComboBox<String> atualizarSexoAnimalComboBox;
    private JComboBox<String> atualizarTutorComboBox;
    private JComboBox<String> atualizarVeterinarioComboBox;
    private JComboBox<String> consultaExameComboBox;
    private JComboBox<String> desativarAnimalComboBox;
    private JComboBox<String> desativarClienteComboBox;
    private JComboBox<String> desativarVeterinarioComboBox;
    private JComboBox<String> especieAnimalComboBox;
    private JComboBox<String> finalizarConsultaComboBox;
    private JComboBox<String> finalizarTratamentoComboBox;
    private JComboBox<String> selecionarEspecieAtualizarComboBox;
    private JComboBox<String> sexoAnimalComboBox;
    private JComboBox<String> tratamentoConsultaComboBox;
    private JComboBox<String> tutorComboBox;
    private JComboBox<String> veterinarioConsultaComboBox;
    private JComboBox<String> horarioConsultaComboBox;


    // TABLE MODELS
    private final AnimalTableModel animalTableModel = new AnimalTableModel();
    private final ClienteTableModel clienteTableModel = new ClienteTableModel();
    private final ConsultaTableModel consultaTableModel = new ConsultaTableModel();
    private final ExameTableModel exameTableModel = new ExameTableModel();
    private final TratamentoTableModel tratamentoTableModel = new TratamentoTableModel();
    private final VeterinarioTableModel veterinarioTableModel = new VeterinarioTableModel();


    private void flushAllSpinner(){
        anoConsultaSpinner.setValue(2023);
        anoFimTratamentoSpinner.setValue(2023);
        anoInicioTratamentoSpinner.setValue(2023);
        atualizarAnoNascimentoAnimalSpinner.setValue(2020);
        diaConsultaSpinner.setValue(1);
        diaFimTratamentoSpinner.setValue(31);
        diaInicioTratamentoSpinner.setValue(1);
        anoNascimentoAnimalSpinner.setValue(2020);
        mesConsultaSpinner.setValue(1);
        mesFimTratamentoSpinner.setValue(12);
        mesInicioTratamentoSpinner.setValue(1);
    }

    private void flushAllTextInput(){
        // Exame
        descricaoExameTextArea.setText("");
        filterByAnimalExameTextField.setText("");
        filterByClienteExameTextField.setText("");
        filterByVeterinarioExameTextField.setText("");

        // Consulta
        relatoConsultaTextArea.setText("");
        filterByAnimalConsultaTextField.setText("");
        filterByClienteConsultaTextField.setText("");
        filterByVeterinarioConsultaTextField.setText("");

        // Cliente
        atualizarCepClienteTextField.setText("");
        atualizarEmailClienteTextField.setText("");
        atualizarEnderecoClienteTextField.setText("");
        atualizarNomeClienteTextField.setText("");
        atualizarTelefoneClienteTextField.setText("");
        cepClienteTextField.setText("");
        emailClienteTextField.setText("");
        enderecoClienteTextField.setText("");
        filterByNameClienteTextField.setText("");
        nomeClienteTextField.setText("");
        telefoneClienteTextField.setText("");

        // Veterinario
        atualizarCepVeterinarioTextField.setText("");
        atualizarEmailVeterinarioTextField.setText("");
        atualizarEnderecoVeterinarioTextField.setText("");
        atualizarNomeVeterinarioTextField.setText("");
        atualizarTelefoneVeterinarioTextField.setText("");
        cepVeterinarioTextField.setText("");
        emailVeterinarioTextField.setText("");
        enderecoVeterinarioTextField.setText("");
        filterByNameVeterinarioTextField.setText("");
        nomeVeterinarioTextField.setText("");
        telefoneVeterinarioTextField.setText("");

        // Animal
        atualizarNomeAnimalTextField.setText("");
        filterByNameAnimalTextField.setText("");
        filterByTutorAnimalTextField.setText("");
        nomeAnimalTextField.setText("");

        // Especie
        atualizarNomeEspecieTextField.setText("");
        nomeEspecieTextField.setText("");

        // Tratamento
        filterByAnimalTratamentoTextField.setText("");
        filterByClienteTratamentoTextField.setText("");
    }

    private void flushAllComboBox(){
        flushComboBox(Flush.TRATAMENTO);
        flushComboBox(Flush.ANIMAL);
        flushComboBox(Flush.CLIENTE);
        flushComboBox(Flush.VETERINARIO);
        flushComboBox(Flush.ESPECIE);
        flushComboBox(Flush.EXAME);
        flushComboBox(Flush.CONSULTA);
    }

    private void flushComboBox(Flush comboBox){
        switch(comboBox){
            case TRATAMENTO -> {
                animalTratamentoComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllAnimaisToComboBox()));
                finalizarTratamentoComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllTratamentosUnfinished()));
            }
            case ANIMAL -> {
                atualizarAnimalComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllAnimaisToComboBox()));
                ativarAnimalComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllAnimaisInactive()));
                atualizarTutorComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllClientesToComboBox()));
                desativarAnimalComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllAnimaisToComboBox()));
                especieAnimalComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllEspeciesToComboBox()));
                atualizarEspecieAnimalComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllEspeciesToComboBox()));
                tutorComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllClientesToComboBox()));
            }
            case CLIENTE -> {
                ativarClienteComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllClientesInactive()));
                atualizarClienteComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllClientesToComboBox()));
                desativarClienteComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllClientesToComboBox()));
            }
            case VETERINARIO -> {
                ativarVeterinarioComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllVeterinariosInactive()));
                atualizarVeterinarioComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllVeterinariosToComboBox()));
                desativarVeterinarioComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllVeterinariosToComboBox()));
            }
            case ESPECIE -> {
                selecionarEspecieAtualizarComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllEspeciesToComboBox()));
            }
            case EXAME -> {
                consultaExameComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllConsultasToComboBox()));
            }
            case CONSULTA -> {
                finalizarConsultaComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllConsultasUnfinished()));
                tratamentoConsultaComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllTratamentosToComboBox()));
                veterinarioConsultaComboBox.setModel(new DefaultComboBoxModel<>(Controller.getAllVeterinariosToComboBox()));
            }
        }
    }

    private void flushAllTables(){
        flushTable(Flush.CLIENTE);
        flushTable(Flush.CONSULTA);
        flushTable(Flush.ANIMAL);
        flushTable(Flush.EXAME);
        flushTable(Flush.VETERINARIO);
        flushTable(Flush.TRATAMENTO);
    }

    private void flushTable(Flush table){
        switch (table){
            case ANIMAL -> {
                animalTableModel.clear();
                animalTableModel.addListOfItems(Controller.getAllAnimais());
            }
            case CLIENTE -> {
                clienteTableModel.clear();
                clienteTableModel.addListOfItems(Controller.getAllClientes());
            }
            case CONSULTA -> {
                consultaTableModel.clear();
                consultaTableModel.addListOfItems(Controller.getAllConsultas());
            }
            case EXAME -> {
                exameTableModel.clear();
                exameTableModel.addListOfItems(Controller.getAllExames());
            }
            case TRATAMENTO -> {
                tratamentoTableModel.clear();
                tratamentoTableModel.addListOfItems(Controller.getAllTratamentos());
            }
            case VETERINARIO -> {
                veterinarioTableModel.clear();
                veterinarioTableModel.addListOfItems(Controller.getAllVeterinarios());
            }
            default -> {
                return;
            }
        }
        flushAllTextInput();
        flushAllComboBox();
    }

    private void addCliente(){
        List<JTextField> inputs = List.of(
                nomeClienteTextField,
                enderecoClienteTextField,
                cepClienteTextField,
                emailClienteTextField,
                telefoneClienteTextField
        );

        if(
            Controller.addCliente(inputs,
                nomeClienteTextField.getText(),
                enderecoClienteTextField.getText(),
                cepClienteTextField.getText(),
                emailClienteTextField.getText(),
                telefoneClienteTextField.getText()
            )
        ){
            flushTable(Flush.CLIENTE);
        }
    }

    private void updateCliente(){
        List<JTextField> inputs = List.of(
                atualizarNomeClienteTextField,
                atualizarEnderecoClienteTextField,
                atualizarCepClienteTextField,
                atualizarEmailClienteTextField,
                atualizarTelefoneClienteTextField
        );

        if(
                Controller.updateCliente(inputs,
                        atualizarClienteComboBox.getSelectedItem(),
                        atualizarNomeClienteTextField.getText(),
                        atualizarEnderecoClienteTextField.getText(),
                        atualizarCepClienteTextField.getText(),
                        atualizarEmailClienteTextField.getText(),
                        atualizarTelefoneClienteTextField.getText()
                )
        ){
            flushTable(Flush.CLIENTE);
        }
    }

    private void addAnimal(){
        List<JTextField> inputs = List.of(
                nomeAnimalTextField
        );

        if(
                Controller.addAnimal(inputs,
                        nomeAnimalTextField.getText(),
                        anoNascimentoAnimalSpinner.getValue(),
                        sexoAnimalComboBox.getSelectedItem(),
                        especieAnimalComboBox.getSelectedItem(),
                        tutorComboBox.getSelectedItem()
                )
        ){
            flushTable(Flush.ANIMAL);
        }
    }

    private void updateAnimal(){
        List<JTextField> inputs = List.of(
                atualizarNomeAnimalTextField
        );

        if(
                Controller.updateAnimal(inputs,
                        atualizarAnimalComboBox.getSelectedItem(),
                        atualizarNomeAnimalTextField.getText(),
                        atualizarAnoNascimentoAnimalSpinner.getValue(),
                        atualizarSexoAnimalComboBox.getSelectedItem(),
                        atualizarEspecieAnimalComboBox.getSelectedItem(),
                        atualizarTutorComboBox.getSelectedItem()
                )
        ){
            flushTable(Flush.ANIMAL);
        }
    }

    private void addEspecie(){
        List<JTextField> inputs = List.of(
                nomeEspecieTextField
        );

        Controller.addEspecie(inputs,
                nomeEspecieTextField.getText()
        );
    }

    private void addVeterinario(){
        List<JTextField> inputs = List.of(
                nomeVeterinarioTextField,
                enderecoVeterinarioTextField,
                cepVeterinarioTextField,
                emailVeterinarioTextField,
                telefoneVeterinarioTextField
        );

        if(
                Controller.addVeterinario(inputs,
                        nomeVeterinarioTextField.getText(),
                        enderecoVeterinarioTextField.getText(),
                        cepVeterinarioTextField.getText(),
                        emailVeterinarioTextField.getText(),
                        telefoneVeterinarioTextField.getText()
                )
        ){
            flushTable(Flush.VETERINARIO);
        }
    }

    private void updateVeterinario(){
        List<JTextField> inputs = List.of(
                atualizarNomeVeterinarioTextField,
                atualizarEnderecoVeterinarioTextField,
                atualizarCepVeterinarioTextField,
                atualizarEmailVeterinarioTextField,
                atualizarTelefoneVeterinarioTextField
        );

        if(
                Controller.updateVeterinario(inputs,
                        atualizarVeterinarioComboBox.getSelectedItem(),
                        atualizarNomeVeterinarioTextField.getText(),
                        atualizarEnderecoVeterinarioTextField.getText(),
                        atualizarCepVeterinarioTextField.getText(),
                        atualizarEmailVeterinarioTextField.getText(),
                        atualizarTelefoneVeterinarioTextField.getText()
                )
        ){
            flushTable(Flush.VETERINARIO);
        }
    }

    private void addConsulta(){
        if(
                Controller.addConsulta(
                        diaConsultaSpinner.getValue(),
                        mesConsultaSpinner.getValue(),
                        anoConsultaSpinner.getValue(),
                        relatoConsultaTextArea.getText(),
                        veterinarioConsultaComboBox.getSelectedItem(),
                        tratamentoConsultaComboBox.getSelectedItem(),
                        horarioConsultaComboBox.getSelectedItem()
                )
        ){
            flushTable(Flush.CONSULTA);
        }
    }

    private void addExame(){
        if(
                Controller.addExame(
                        descricaoExameTextArea.getText(),
                        consultaExameComboBox.getSelectedItem()
                )
        ){
            flushTable(Flush.EXAME);
        }
    }

    private void addTratamento(){
        if(dataFimTratamentoIndeterminadaCheckBox.isSelected()){
            if(
                    Controller.addTratamentoIndeterminado(
                            diaInicioTratamentoSpinner.getValue(),
                            mesInicioTratamentoSpinner.getValue(),
                            anoInicioTratamentoSpinner.getValue(),

                            animalTratamentoComboBox.getSelectedItem()
                    )
            ){
                flushTable(Flush.TRATAMENTO);
            }
        } else{
            if(
                    Controller.addTratamento(
                            diaInicioTratamentoSpinner.getValue(),
                            mesInicioTratamentoSpinner.getValue(),
                            anoInicioTratamentoSpinner.getValue(),

                            diaFimTratamentoSpinner.getValue(),
                            mesFimTratamentoSpinner.getValue(),
                            anoFimTratamentoSpinner.getValue(),

                            animalTratamentoComboBox.getSelectedItem()
                    )
            ){
                flushTable(Flush.TRATAMENTO);
            }
        }
    }

    private void finalizarTratamento() {
        Controller.finalizarTratamento(finalizarTratamentoComboBox.getSelectedItem());
        flushTable(Flush.TRATAMENTO);
    }

    private void finalizarConsulta() {
        Controller.finalizarConsulta(finalizarConsultaComboBox.getSelectedItem());
        flushTable(Flush.CONSULTA);
    }

    private void ativarVeterinario() {
        Controller.ativarVeterinario(ativarVeterinarioComboBox.getSelectedItem());
        flushTable(Flush.VETERINARIO);
    }

    private void desativarVeterinario() {
        Controller.desativarVeterinario(desativarVeterinarioComboBox.getSelectedItem());
        flushTable(Flush.VETERINARIO);
    }

    private void ativarAnimal() {
        Controller.ativarAnimal(ativarAnimalComboBox.getSelectedItem());
        flushTable(Flush.ANIMAL);
    }

    private void desativarAnimal() {
        Controller.desativarAnimal(desativarAnimalComboBox.getSelectedItem());
        flushTable(Flush.ANIMAL);
    }

    private void atualizarEspecie() {
        Controller.atualizarEspecie(selecionarEspecieAtualizarComboBox.getSelectedItem(), atualizarNomeEspecieTextField.getText());
        flushTable(Flush.ANIMAL);
    }

    private void ativarCliente() {
        Controller.ativarCliente(ativarClienteComboBox.getSelectedItem());
        flushTable(Flush.CLIENTE);
    }

    private void desativarCliente() {
        Controller.desativarCliente(desativarClienteComboBox.getSelectedItem());
        flushTable(Flush.CLIENTE);
    }


    private void mainTabbedPaneChangeListener(){
        flushAllTextInput();
        flushAllSpinner();
        flushAllComboBox();
    }


    private void clienteTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
    private void animalTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
    private void veterinarioTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
    private void consultaTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
    private void exameTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
    private void tratamentoTabbedPaneChangeListener(){
        mainTabbedPaneChangeListener();
    }
}
