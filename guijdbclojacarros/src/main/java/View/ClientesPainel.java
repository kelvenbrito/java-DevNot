package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Controller.ClientesControl;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Model.Carros;
import Model.Clientes;

public class ClientesPainel extends JPanel{
    // Atributos(componentes)
    private JButton cadastrar, apagar, editar;
    private JTextField cliNomeField, cliEnderecoField, cliTelefoneField, cliCpfField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public ClientesPainel() {
        super();
     // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro de Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("Nome"));
        cliNomeField = new JTextField(20);
        inputPanel.add(cliNomeField);
        inputPanel.add(new JLabel("Endereço"));
        cliEnderecoField = new JTextField(20);
        inputPanel.add(cliEnderecoField);
        inputPanel.add(new JLabel("Telefone"));
        cliTelefoneField = new JTextField(20);
        inputPanel.add(cliTelefoneField);
        inputPanel.add(new JLabel("CPF"));
        cliCpfField = new JTextField(20);
        inputPanel.add(cliCpfField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        add(botoes);
          // tabela de clientes
          JScrollPane jSPane = new JScrollPane();
          add(jSPane);
          tableModel = new DefaultTableModel(new Object[][] {},
                  new String[] { "Nome", "Endereço", "Telefone", "CPF" });
          table = new JTable(tableModel);
          jSPane.setViewportView(table);
          // criar o banco de dados
        new ClientesDAO().criaTabela();
        // executar o método de atualizar tabela
        atualizarTabela();
        // tratamento de eventos(construtor)
        
        //tratamento para click do mouse na tabela
         table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cliNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cliEnderecoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cliTelefoneField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    cliCpfField.setText((String) table.getValueAt(linhaSelecionada, 3));
                }
            }
        });

      ClientesControl operacoes = new ClientesControl(clientes,tableModel,table);

        //tratamento para botão cadastrar
        cadastrar.addActionListener(e->{
            try {
                operacoes.cadastrar(cliNomeField.getText(), cliEnderecoField.getText(),
                                    cliTelefoneField.getText(), cliCpfField.getText());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            cliNomeField.setText("");
            cliEnderecoField.setText("");
            cliTelefoneField.setText("");
            cliCpfField.setText("");
        });

        //tratamento do botão editar
        editar.addActionListener(e->{
            operacoes.atualizar(cliNomeField.getText(), cliEnderecoField.getText(),
                                cliTelefoneField.getText(), cliCpfField.getText());
            cliNomeField.setText("");
            cliEnderecoField.setText("");
            cliTelefoneField.setText("");
            cliCpfField.setText("");
        });

        //tratamento do botão apagar
        apagar.addActionListener(e->{
            operacoes.apagar(cliTelefoneField.getText());
            cliNomeField.setText("");
            cliEnderecoField.setText("");
            cliTelefoneField.setText("");
            cliCpfField.setText("");
        });


    }

    // métodos (atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();
        // Obtém os cliente atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getMarca(), cliente.getModelo(),

                    cliente.getAno(), cliente.getPlaca()});
        }
    }
}
  
    


