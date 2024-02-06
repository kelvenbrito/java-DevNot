package View;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Connection.ClientesDAO;
import Controller.ClientesControl;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class cadastroCliente extends JPanel {
    private JButton cadastrar, excluir;
    private JTextField nomeCliente, cpfCliente;

    public cadastroCliente() {
        super();
        setLayout(new BorderLayout());
        // add(new JLabel("Cadastro de Clientes"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Cadastro de Clientes"));
        inputPanel.add(new JLabel(""));
        inputPanel.add(new JLabel("Nome"));
        nomeCliente = new JTextField(20);
        inputPanel.add(nomeCliente);
        inputPanel.add(new JLabel("CPF"));
        cpfCliente = new JTextField(20);
        inputPanel.add(cpfCliente);
        add(inputPanel, BorderLayout.NORTH);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(excluir = new JButton("Excluir"));
        add(botoes);

        // criar o banco de dados
        new ClientesDAO().criaTabela();

        // tratamento de eventos(construtor)
        ClientesControl operacoes = new ClientesControl();

        // tratamento para botão cadastrar
        cadastrar.addActionListener(e -> {

            operacoes.cadastrar(nomeCliente.getText(), cpfCliente.getText());

            nomeCliente.setText("");
            cpfCliente.setText("");
        });

        // tratamento do botão apagar
        excluir.addActionListener(e -> {
            operacoes.apagar(cpfCliente.getText());
            cpfCliente.setText("");
            nomeCliente.setText("");
        });
    }
}