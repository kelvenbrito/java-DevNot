package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Connection.ProdutosDAO;
import Connection.VendasDAO;
import Controller.ProdutosControl;
import Controller.VendasControl;
import Model.Produtos;
import Model.Vendas;
import Model.Clientes;

public class VendasPainel extends JPanel {
    // Atributos(componentes)
    private JButton inserirProduto, apagarProduto, editarProduto, finalizarVenda, cadastrar;
    private JTextField clienteCpfField, codigoProdutoField, quantidadeProdutoField, valorFinal;
    private JLabel status;
    private JComboBox formaPagamento;

    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private List<Vendas> vendas;
    private List<Clientes> clientes;
    private List<Produtos> produtos;
    double vf = 0;
    boolean descontoVip = false;
    int linhaEditar = 0;
    boolean verificPoduto = false;
    int quantidadeVenda;

    //
    // Construtor(GUI-JPanel)
    public VendasPainel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Caixa de Vendas"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2));
        inputPanel.add(new JLabel("CPF"));
        clienteCpfField = new JTextField(20);
        inputPanel.add(clienteCpfField);
        // Status Cliente
        inputPanel.add(status = new JLabel(""));
        inputPanel.add(cadastrar = new JButton("Cadastrar"));
        // Forma de pagamento
        inputPanel.add(new JLabel("Forma de Pagamento"));
        String[] formasPagamento = { "Dinheiro", "Cartão de Crédito", "Pix", "Vale Alimentação" };
        JComboBox<String> formaPagamento = new JComboBox<>(formasPagamento);
        inputPanel.add(formaPagamento);
        inputPanel.add(new JLabel("Código do Produto"));
        codigoProdutoField = new JTextField(3);
        inputPanel.add(codigoProdutoField);
        inputPanel.add(new JLabel("Quantidade"));
        quantidadeProdutoField = new JTextField(3);
        quantidadeProdutoField.setText("1");

        inputPanel.add(quantidadeProdutoField);
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(inserirProduto = new JButton("Inserir"));
        botoes.add(editarProduto = new JButton("Editar"));
        botoes.add(apagarProduto = new JButton("Apagar"));
        add(botoes);

        // tabela de clientes
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);

        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Código", "Nome", "Quantidade", "Preço", "Desconto VIP" }) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Aqui, você pode definir as colunas que não devem ser editáveis
                return column != 0 && column != 1 && column != 2 && column != 3 && column != 4; // Por exemplo, torna a
                                                                                                // coluna 0 (Código) e 2
                                                                                                // (Quantidade) não
                // editáveis
            }
        };
        table = new JTable(tableModel);

        jSPane.setViewportView(table);
        // Total da compra
        JPanel precoTotal = new JPanel();
        precoTotal.setLayout(new BorderLayout());
        precoTotal.add(new JLabel("Valor Final da Compra: "), BorderLayout.CENTER);
        precoTotal.add(valorFinal = new JTextField(20), BorderLayout.EAST);
        valorFinal.setEditable(false);
        add(precoTotal);

        JPanel teste = new JPanel();
        teste.add(finalizarVenda = new JButton("Finalizar"));
        add(teste);

        // Cria o banco de dados caso não tenha sido criado
        new VendasDAO().criaTabela();

        // Tratamento de eventos -- dentro construtor
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    linhaEditar = linhaSelecionada;
                    codigoProdutoField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    quantidadeProdutoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                }
            }
        });

        clienteCpfField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_ENTER) {

                    int linha = table.getRowCount();
                    if (linha == 0) {

                        clientes = new ClientesDAO().listarTodos();
                        for (Clientes cliente : clientes) {
                            if (clienteCpfField.getText().equals(cliente.getCpf())) {
                                status.setText("Cliente cadastrado!");
                                descontoVip = true;
                                break;
                            } else {
                                status.setText("Cliente não cadastrado!");
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Não é possivel inserir ou remover desconto VIP após  inserir um produto ao carrinho");
                    }
                }
            }
        });

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Formato personalizado
        String dataHora = dateTime.format(formatter); // Obtém data e hora formatadas

        VendasControl operacoes = new VendasControl(vendas, tableModel, table);
        // tratamento para botão cadastrar
        finalizarVenda.addActionListener(e -> {
            operacoes.cadastrar(clienteCpfField.getText(), valorFinal.getText(), dataHora);
            for (Produtos produto : produtos) {
                try {
                    if (produto.getQuantidade() <= 0) {
                        throw new Exception("Produto código: " + produto.getCodigoBarra() + " Nome: "
                                + produto.getNome() + " esta esgotado! faça o reabastecimento!");

                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }

        });

        inserirProduto.addActionListener(e -> {
            produtos = new ProdutosDAO().listarTodos();

            // Variavel para receber quantidade que tem no estoque do produto
            int quantDisponivel = new VendasDAO().quantidadeProd(codigoProdutoField.getText());
            try {
                for (Produtos produto : produtos) {
                    if (codigoProdutoField.getText().equals(produto.getCodigoBarra())) {

                        verificPoduto = true;
                    }
                }
                if (!verificPoduto) {
                    throw new Exception("Erro! Produto não encontrado!");
                }
                // Evita de inserir na tabela uma linha caso não tenha a quantidade no estoque
                if (Integer.parseInt(quantidadeProdutoField.getText()) > quantDisponivel) {

                    throw new Exception("Erro! Quantidade insuficiente no estoque!");
                }
                if (quantidadeProdutoField.getText().isEmpty()) {
                    throw new Exception("Erro! O campo do codigo do produto esta vazio!");
                }
                for (Produtos produto : produtos) {
                    if (codigoProdutoField.getText().equals(produto.getCodigoBarra())) {

                        if (descontoVip) {

                            tableModel.addRow(new Object[] { produto.getCodigoBarra(), produto.getNome(),
                                    quantidadeProdutoField.getText(), produto.getPreco(), produto.getPreco() * 0.75 });
                            vf += (produto.getPreco() * 0.75) * Double.parseDouble(quantidadeProdutoField.getText());
                            valorFinal.setText(vf + "");

                        } else {

                            tableModel.addRow(new Object[] { produto.getCodigoBarra(), produto.getNome(),
                                    quantidadeProdutoField.getText(), produto.getPreco(), 0 });
                            vf += produto.getPreco() * Double.parseDouble(quantidadeProdutoField.getText());
                            valorFinal.setText(vf + "");

                        }
                        quantidadeVenda = produto.getQuantidade() - Integer.parseInt(quantidadeProdutoField.getText());

                        operacoes.vender(codigoProdutoField.getText(), quantidadeVenda);

                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        cadastrar.addActionListener(e -> {
            // Exibe o painel com a tabela de histórico de vendas
            JFrame cadFrame = new JFrame("Cadastro de cliente");
            cadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            cadastroCliente tab3 = new cadastroCliente();
            cadFrame.add(tab3);
            cadFrame.pack();
            cadFrame.setVisible(true);
        });

        editarProduto.addActionListener(ev -> {
            if (linhaEditar != -1) { // Verifica se uma linha está selecionada na tabela
                String novoCodigo = codigoProdutoField.getText();
                String novaQuantidade = quantidadeProdutoField.getText();
                double precoAntigo = (double) tableModel.getValueAt(linhaEditar, 3);
                String quantidadeAntigaStr = (String) tableModel.getValueAt(linhaEditar, 2);
                int quantidadeAntiga = Integer.parseInt(quantidadeAntigaStr);

                tableModel.setValueAt(novoCodigo, linhaEditar, 0);
                tableModel.setValueAt(novaQuantidade, linhaEditar, 2);

                produtos = new ProdutosDAO().listarTodos();

                for (Produtos produto : produtos) {
                    if (codigoProdutoField.getText().equals(produto.getCodigoBarra())) {
                        if (descontoVip) {

                            tableModel.setValueAt(produto.getNome(), linhaEditar, 1);
                            tableModel.setValueAt(produto.getPreco(), linhaEditar, 3);

                            // Subtrai preco do produto no valorFinal
                            vf -= precoAntigo * quantidadeAntiga * 0.75;
                            vf += produto.getPreco() * 0.75 *
                                    Double.parseDouble(quantidadeProdutoField.getText());
                            valorFinal.setText(vf + "");

                            verificPoduto = true;

                        } else {

                            tableModel.setValueAt(produto.getNome(), linhaEditar, 1);
                            tableModel.setValueAt(produto.getPreco(), linhaEditar, 3);

                            // Subtrai preco do produto no valorFinal
                            vf -= precoAntigo * quantidadeAntiga;
                            vf += produto.getPreco() *
                                    Double.parseDouble(quantidadeProdutoField.getText());
                            valorFinal.setText(vf + "");

                            verificPoduto = true;

                        }

                        if (quantidadeAntiga - Integer.parseInt(quantidadeProdutoField.getText()) >= 0) {
                            quantidadeVenda = produto.getQuantidade() + (quantidadeAntiga
                                    - Integer.parseInt(quantidadeProdutoField.getText()));

                        } else {
                            quantidadeVenda = produto.getQuantidade()
                                    - (Integer.parseInt(quantidadeProdutoField.getText()) - quantidadeAntiga);
                        }

                        operacoes.vender(codigoProdutoField.getText(), quantidadeVenda);
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "");
            }

        });

        apagarProduto.addActionListener(ev -> {
            if (linhaEditar != -1) { // Verifica se uma linha está selecionada na tabela

                vf = 0;
                valorFinal.setText(vf + "");
                String quantidadeAntigaStr = (String) tableModel.getValueAt(linhaEditar, 2);
                int quantidadeAntiga = Integer.parseInt(quantidadeAntigaStr);
                produtos = new ProdutosDAO().listarTodos();

                for (Produtos produto : produtos) {
                    quantidadeVenda = produto.getQuantidade() + quantidadeAntiga;
                    operacoes.vender(codigoProdutoField.getText(), quantidadeVenda);
                }
                tableModel.removeRow(linhaEditar);

            } else {
                JOptionPane.showMessageDialog(null, "");

            }
        });

    }

}
