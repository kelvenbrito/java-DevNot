package View;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ItemEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Connection.VendasDAO;
import Controller.CarrosControl;
import Controller.VendasControl;
import Model.Vendas;
import Model.Carros;
import Model.Clientes;

public class VendasPainel extends JPanel {
    JComboBox<String> carrosComboBox;
    JComboBox<String> clientesComboBox;
    List<Carros> carros;
    List<Clientes> clientes;
    JLabel placa;
    JLabel marca;
    JLabel modelo;
    JLabel ano;
    JLabel valor;
    JLabel cpf;
    JLabel nome;
    JLabel endereco;
    JLabel telefone;
    List<Vendas> vendas;
    private JTable table;
    private DefaultTableModel tableModel;
    String numeroPlaca;

    public VendasPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Vendas"));

        JPanel carrosPanel = new JPanel();
        JPanel clientesPanel = new JPanel();
        JPanel infoCarroPanel = new JPanel();
        JPanel infoClientesPanel = new JPanel();
        JButton vender = new JButton("Vender");
        JButton histVenda = new JButton("Historico de Venda");

        add(carrosPanel);
        add(clientesPanel);
        add(vender);
        add(histVenda);

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);

        clientesComboBox = new JComboBox<>();
        carrosComboBox = new JComboBox<>();
        placa = new JLabel(" ");
        marca = new JLabel(" ");
        modelo = new JLabel(" ");
        ano = new JLabel(" ");
        valor = new JLabel(" ");

        cpf = new JLabel(" ");
        nome = new JLabel(" ");
        endereco = new JLabel(" ");
        telefone = new JLabel(" ");

        carrosPanel.setLayout(new BorderLayout());
        carrosPanel.add(carrosComboBox, BorderLayout.NORTH);
        carrosPanel.add(infoCarroPanel, BorderLayout.CENTER);
        infoCarroPanel.setLayout(new GridLayout(2, 3));
        infoCarroPanel.add(placa);
        infoCarroPanel.add(marca);
        infoCarroPanel.add(modelo);
        infoCarroPanel.add(ano);
        infoCarroPanel.add(valor);
        clientesPanel.setLayout(new BorderLayout());
        clientesPanel.add(clientesComboBox, BorderLayout.NORTH);
        clientesPanel.add(infoClientesPanel, BorderLayout.CENTER);
        infoClientesPanel.setLayout(new GridLayout(2, 3));
        infoClientesPanel.add(cpf);
        infoClientesPanel.add(nome);
        infoClientesPanel.add(endereco);
        infoClientesPanel.add(telefone);

        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();

        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }

        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getCpf()
                    + " " + cliente.getNome());
        }

        // criar o banco de dados
        new VendasDAO().criaTabela();
        // executar o método de atualizar tabela
        atualizarComboBox();

        carrosComboBox.addItemListener(e -> {
            // Quando a seleção do ComboBox é alterada
            informacaoCarros();

        });

        clientesComboBox.addItemListener(e -> {
            // Quando a seleção do ComboBox é alterada
            informacaoClientes();

        });

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato personalizado
        String data = date.format(formatter);

        VendasControl operacoesVendas = new VendasControl(vendas, tableModel, table);
        CarrosControl operacoesCarros = new CarrosControl(carros, tableModel, table);

        // tratamento para botão cadastrar
        vender.addActionListener(e -> {
            try {
                int option = JOptionPane.showConfirmDialog(null,
                        "Deseja realmente realizar essa venda \nessa venda sera registrada no banco de dados?", "Confirmação",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    operacoesVendas.cadastrar(nome.getText(), cpf.getText(), placa.getText(), data,
                            valor.getText());
                    // Verificar se a placa está presente em algum carro da lista
                    for (Carros carro : carros) {
                        if (carro.getPlaca().equals(numeroPlaca)) {
                            operacoesCarros.venderCarro(carro.getPlaca());
                            atualizarTabela();

                            break; // Se a placa for encontrada, encerramos o loop
                        }
                    }
                }

            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        });
        JScrollPane jSPane = new JScrollPane();
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Cod.Venda", "CPF-Cliente", "Nome-Cliente", "Placa-Carro", "Data", "Valor" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        histVenda.addActionListener(e -> {
            vendas = new VendasDAO().listarTodos();
            // Adiciona uma linha à tabela com as informações atuais
            for (Vendas venda : vendas) {
                // Adiciona uma linha à tabela com as informações atuais
                tableModel.addRow(new Object[] {
                        venda.getCodVenda(),
                        venda.getCPFCliente(),
                        venda.getnomeClientes(),
                        venda.getPlacaCarroVendido(),
                        venda.getDataVenda(),
                        venda.getValortotal()
                });
            }

            // Exibe o painel com a tabela de histórico de vendas
            JFrame historicoVendasFrame = new JFrame("Histórico de Vendas");
            historicoVendasFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            historicoVendasFrame.add(jSPane);
            historicoVendasFrame.pack();
            historicoVendasFrame.setVisible(true);
        });
    }

    public void atualizarComboBox() {
        // Limpa os ComboBoxes
        carrosComboBox.removeAllItems();
        clientesComboBox.removeAllItems();

        // Preenche novamente os ComboBoxes
        carrosComboBox.addItem("Selecione o Carro");
        clientesComboBox.addItem("Selecione o Cliente");

        // Busca os novos dados do banco
        carros = new CarrosDAO().listarTodos();
        clientes = new ClientesDAO().listarTodos();

        // Adiciona os novos itens aos ComboBoxes
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca() + " " + carro.getModelo() + " " + carro.getPlaca());
        }

        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getCpf() + " " + cliente.getNome());
        }

        // Notifica a GUI sobre as mudanças
        carrosComboBox.revalidate();
        carrosComboBox.repaint();

        clientesComboBox.revalidate();
        clientesComboBox.repaint();
    }

    public void informacaoCarros() {
        // Obtém a seleção do ComboBox
        String filtroCar = (String) carrosComboBox.getSelectedItem();

        for (Carros carro : carros) {
            if (filtroCar.equals(carro.getMarca() + " " + carro.getModelo() + " " + carro.getPlaca())) {
                placa.setText("placa: " + carro.getPlaca());
                marca.setText("Marca: " + carro.getMarca());
                modelo.setText("Modelo: " + carro.getModelo());
                ano.setText("Ano: " + carro.getAno());
                valor.setText("Valor: " + carro.getValor());
                numeroPlaca = placa.getText().substring(carro.getPlaca().length());
            }
        }
    }

    public void informacaoClientes() {
        // Obtém a seleção do ComboBox
        String filtroCli = (String) clientesComboBox.getSelectedItem();
        for (Clientes cliente : clientes) {
            if (filtroCli.equals(cliente.getCpf() + " " + cliente.getNome())) {
                cpf.setText("CPF: " + cliente.getCpf());
                nome.setText("Nome: " + cliente.getNome());
                endereco.setText("Endereço: " + cliente.getEndereco());
                telefone.setText("Telefone: " + cliente.getTelefone());

            }
        }
    }

    // métodos (atualizar tabela)
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

                    carro.getAno(), carro.getPlaca(), carro.getValor() });
        }
    }

}