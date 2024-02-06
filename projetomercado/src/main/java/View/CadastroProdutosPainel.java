package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;

import Connection.ProdutosDAO;
import Controller.ProdutosControl;
import Model.Produtos;

public class CadastroProdutosPainel extends JPanel {
    //[Declarações existentes de  componentes e atributos]
  private JTextField codBarras, nomeProd, precoProd, quantProd;
  private JButton cadastrar, apagar, editar;
  private List<Produtos> produtos;
  private JTable table;
  private DefaultTableModel tableModel;
  private int linhaSelecionada = -1;

  public CadastroProdutosPainel() {
    super();
    // entrada de dados
    // componentes da interface
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    add(new JLabel("Cadastro de Produtos"));
    JPanel inputPanel = new JPanel();
    inputPanel.setLayout(new GridLayout(4, 2));
    inputPanel.add(new JLabel("Código de Barras do Produto"));
    codBarras = new JTextField(20);
    inputPanel.add(codBarras);
    ;
    inputPanel.add(new JLabel("Nome"));
    nomeProd = new JTextField(20);
    inputPanel.add(nomeProd);
    inputPanel.add(new JLabel("Preço"));
    precoProd = new JTextField(20);
    inputPanel.add(precoProd);
    inputPanel.add(new JLabel("Quantidade"));
    quantProd = new JTextField(20);
    inputPanel.add(quantProd);
    add(inputPanel);
    JPanel botoes = new JPanel();
    botoes.add(cadastrar = new JButton("Cadastrar"));
    botoes.add(editar = new JButton("Editar"));
    botoes.add(apagar = new JButton("Apagar"));
    add(botoes);
    // tabela de produtos
    JScrollPane jSPane = new JScrollPane();
    add(jSPane);
    tableModel = new DefaultTableModel(new Object[][] {},
        new String[] { "Códico de Barras", "Nome", "Preço", "Quantidade" }) {
      @Override
      public boolean isCellEditable(int row, int column) {
        // Aqui, você pode definir as colunas que não devem ser editáveis
        return column != 0 && column != 1 && column != 2 && column != 3; //  torna a
                                                                         // coluna 0 (Código) e 2
                                                                         // (Quantidade) não
        // editáveis
      }
    };
    table = new JTable(tableModel);
    jSPane.setViewportView(table);

    // criar o banco de dados
    new ProdutosDAO().criaTabela();
    // executar o método de atualizar tabela
    atualizarTabela();

    // tratamento de eventos(construtor)
    // tratamento para click do mouse na tabela
    table.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent evt) {
        linhaSelecionada = table.rowAtPoint(evt.getPoint());
        if (linhaSelecionada != -1) {
          codBarras.setText((String) table.getValueAt(linhaSelecionada, 0));
          nomeProd.setText((String) table.getValueAt(linhaSelecionada, 1));
          double preco = (double) table.getValueAt(linhaSelecionada, 2);
          precoProd.setText(preco + "");
          quantProd.setText(String.valueOf((int) table.getValueAt(linhaSelecionada, 3)));

        }
      }
    });

    ProdutosControl operacoes = new ProdutosControl(produtos, tableModel, table);
    // tratamento para botão cadastrar
    cadastrar.addActionListener(e -> {


      

      operacoes.cadastrar(codBarras.getText(), nomeProd.getText(),
          precoProd.getText(), quantProd.getText());

      codBarras.setText("");
      nomeProd.setText("");
      precoProd.setText("");
      quantProd.setText("");
    });

    // tratamento do botão editar
    editar.addActionListener(e -> {
      operacoes.atualizar(codBarras.getText(), nomeProd.getText(),
          precoProd.getText(), quantProd.getText());
      codBarras.setText("");
      nomeProd.setText("");
      precoProd.setText("");
      quantProd.setText("");
    });

    // tratamento do botão apagar
    apagar.addActionListener(e -> {
      operacoes.apagar(codBarras.getText());
      codBarras.setText("");
      nomeProd.setText("");
      precoProd.setText("");
      quantProd.setText("");
    });

  }

  // métodos (atualizar tabela)
  // Método para atualizar a tabela de exibição com dados do banco de dados
  void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    produtos = new ProdutosDAO().listarTodos();
    // Obtém os produtos atualizados do banco de dados
    for (Produtos produto : produtos) {
      // Adiciona os dados de cada produto como uma nova linha na tabela Swing
      tableModel.addRow(
          new Object[] { produto.getCodigoBarra(), produto.getNome(), produto.getPreco(), produto.getQuantidade() });

    }
    // Aplica o renderizador de células à coluna de quantidade (assumindo que seja a
    // coluna 3)
    table.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer() {
      @Override
      public void setValue(Object value) {
        if (value instanceof Integer && (Integer) value <= 5) {
          setBackground(Color.RED);
        } else {
          setBackground(table.getBackground()); // Define a cor de fundo padrão da tabela
        }
        setText((value == null) ? "" : value.toString());
      }
    });

  }

}