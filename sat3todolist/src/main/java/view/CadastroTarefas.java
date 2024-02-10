package view;

import java.util.ArrayList;
import java.util.List;

import connection.ListaDAO;
import controller.TarefasControl;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseEvent;

import model.Tarefas;

public class CadastroTarefas extends JFrame {
    private JPanel mainPanel;
    private JTextField taskInputField;
    private JButton addButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton deleteButton;
    private JButton markDoneButton;
    private JComboBox<String> filterComboBox;
    private JButton clearCompletedButton;
    private List<Tarefas> tarefas;
    private JScrollBar scrollBar;
    private JLabel label;
    private List<Tarefas> tarefasOriginais;

    // Construtor da classe TodoList
    public CadastroTarefas() {
        // Configura a janela principal
        super("Lista de tarefas");
        // Impede o fechamento padrão da janela
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // Define o tamanho da janela
        this.setSize(600, 300);

        // Inicialização do painel principal
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Inicialização da lista de tarefas e do modelo da lista
        tarefas = new ArrayList<>();
        tarefasOriginais = new ArrayList<>(tarefas);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        // Inicialização dos campos de entrada, botões e ComboBox
        taskInputField = new JTextField();
        addButton = new JButton("Adicionar");
        deleteButton = new JButton("Excluir");
        markDoneButton = new JButton("Concluir");
        filterComboBox = new JComboBox<>(new String[] { "Todas", "Ativas", "Concluídas" });
        clearCompletedButton = new JButton("Limpar Concluídas");
        scrollBar = new JScrollBar(JScrollBar.HORIZONTAL);
        label = new JLabel("Tamanho: 100");

        // Configuração do painel de entrada
        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(taskInputField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        // Configuração do painel de botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(deleteButton);
        buttonPanel.add(markDoneButton);
        buttonPanel.add(filterComboBox);
        buttonPanel.add(clearCompletedButton);
        buttonPanel.add(scrollBar);
        buttonPanel.add(label);

        // Adiciona os componentes ao painel principal
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(new JScrollPane(table), BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        this.add(mainPanel);

        // criar o banco de dados
        new ListaDAO().criaTabela();

        // executar o método de atualizar tabela
        atualizarTabela();

        // Adiciona listeners aos botões
        addButton.addActionListener(e -> {

            addTask();
            // executar o método de atualizar tabela
            atualizarTabela();

        });

        deleteButton.addActionListener(e -> {
            // Quando o botão "Excluir" é pressionado
            deleteTask();
            // executar o método de atualizar tabela
            atualizarTabela();

        });

        markDoneButton.addActionListener(e -> {
            // Quando o botão "Concluir" é pressionado
            markTaskDone();

        });

        filterComboBox.addItemListener(e -> {
            // Quando a seleção do ComboBox é alterada
            filterTasks();

        });

        clearCompletedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Quando o botão "Limpar Concluídas" é pressionado
                clearCompletedTasks();
            }
        });

        // Adiciona um KeyListener para a lista de tarefas para excluir com a tecla
        // "DEL"
        taskInputField.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_DELETE) {
                    // Quando a tecla "DEL" é pressionada na lista

                    // Remove a tarefa da lista e atualiza a interface
                    deleteTask();
                }
                if (key == KeyEvent.VK_ENTER) {
                    // Quando a tecla "Entert" é pressionada na lista

                    // Adiciona a tarefa na lista e atualiza a interface
                    addTask();
                }
            }

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

        // Adiciona um WindowListener para confirmar o fechamento da aplicação
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                // Quando a janela está prestes a ser fechada
                fecharJanela();
            }
        });

        // Adiciona um MouseListener para detectar cliques duplos na lista de tarefas
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getClickCount() == 2) {
                    editTask();
                }
            }
        });

        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                int valorScrollBar = scrollBar.getValue();
                int valorScrollBarMaximo = scrollBar.getMaximum() - scrollBar.getVisibleAmount();

                int larguraInicial = 600;
                int alturaInicial = 300;

                // Calcula o fator de escala para largura e altura
                double fatorEscala = 1.0 + (double) valorScrollBar / valorScrollBarMaximo;

                // Limita a largura e altura de acordo com os valores iniciais
                int novaLargura = (int) (larguraInicial * fatorEscala);
                int novaAltura = (int) (alturaInicial * fatorEscala);

                label.setText("Tamanho: " + (int) (fatorEscala * 100) + "%");

                // Define as novas dimensões para o painel principal
                mainPanel.setPreferredSize(new Dimension(novaLargura, novaAltura));
                mainPanel.revalidate(); // Revalida o layout para aplicar as alterações
                pack();
            }

        });

        run();

    }

    // Função para adicionar uma nova tarefa à lista
    private void addTask() {
        TarefasControl operacoes = new TarefasControl(tarefas, tableModel, table);
        // Obtém a descrição da tarefa do campo de entrada
        String taskDescription = taskInputField.getText().trim();
        if (!taskDescription.isEmpty()) {

            operacoes.cadastrar(taskDescription);

            // Limpa o campo de entrada
            taskInputField.setText("");
        }
    }

    

    // Função para excluir a tarefa selecionada da lista
    private void deleteTask() {
        TarefasControl operacoes = new TarefasControl(tarefas, tableModel, table);
        int selectedIndex = table.getSelectedColumn();
        if (selectedIndex >= 0 && selectedIndex < tarefas.size()) {
            // Exibe uma caixa de diálogo de confirmação
            int option = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "Confirmação",
                    JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Remove a tarefa da lista e atualiza a interface
                operacoes.apagar(selectedIndex);

            }
        }
    }

    // Função para marcar a tarefa selecionada como concluída
    // Função para marcar a tarefa selecionada como concluída
    private void markTaskDone() {
        int selectedIndex = table.getSelectedColumn();
        if (selectedIndex >= 0 && selectedIndex < tarefas.size()) {
            // Marca a tarefa como concluída e atualiza a interface
            Tarefas tarefa = tarefas.get(selectedIndex);
            tarefa.setcondicao(true);

        }
    }

    // Função para filtrar as tarefas com base na seleção do ComboBox
    private void filterTasks() {
        // Obtém a seleção do ComboBox
        String filter = (String) filterComboBox.getSelectedItem();
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
       
        for (Tarefas tarefa : tarefasOriginais) {
            if (filter.equals("Todas") || (filter.equals("Ativas") && !tarefa.iscondicao())
                    || (filter.equals("Concluídas") && tarefa.iscondicao())) {
                        tableModel.addRow(
                            new Object[] {tarefa.getDescricao() });
            }
        }
    }

    // Função para limpar todas as tarefas concluídas da lista
    private void clearCompletedTasks() {
        // Cria uma lista de tarefas concluídas
        List<Tarefas> completedTasks = new ArrayList<>();

        for (Tarefas tarefa : tarefas) {
            if (tarefa.iscondicao()) {
                completedTasks.add(tarefa);
            }
        }

        // Remove as tarefas concluídas da lista e atualiza a interface
        tarefas.removeAll(completedTasks);

    }

    private void fecharJanela() {
        int option = JOptionPane.showConfirmDialog(null, "Deseja realmente fechar a aplicação?", "Confirmação",
                JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Fecha a aplicação
            System.exit(0);
        }
    }

    // Função para editar a tarefa selecionada
    private void editTask() {
        int selectedIndex = table.getSelectedColumn();
        if (selectedIndex >= 0 && selectedIndex < tarefas.size()) {
            // Obtém a descrição atual da tarefa
            String currentDescription = tarefas.get(selectedIndex).getDescricao();

            // Pede ao usuário para editar a descrição
            String editedDescription = (String) JOptionPane.showInputDialog(null, "Editar Tarefa", "Edição de Tarefa",
                    JOptionPane.PLAIN_MESSAGE, null, null, currentDescription);

            // Atualiza a descrição se o usuário não cancelou
            if (editedDescription != null && !editedDescription.isEmpty()) {
                tarefas.get(selectedIndex).setDescricao(editedDescription);

            }
        }
    }

    // métodos (atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        tarefas = new ListaDAO().listarTodos();
        // Obtém os produtos atualizados do banco de dados
        for (Tarefas tarefa : tarefas) {
            // Adiciona os dados de cada produto como uma nova linha na tabela Swing
            tableModel.addRow(
                new Object[] {tarefa.getIdTarefa(), tarefa.getDescricao()});

        }

    }

    // Função para exibir a janela principal
    public void run() {
        this.setVisible(true);
    }

}