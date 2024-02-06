package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
import Connection.VendasDAO;
import Model.Produtos;

public class ProdutosControl {
    // Atributos
    private List<Produtos> produtos; // Lista de produtos
    private DefaultTableModel tableModel; // Modelo da tabela
    private JTable table; // Tabela

    // Construtor
    public ProdutosControl(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos; // Inicialização da lista de produtos
        this.tableModel = tableModel; // Inicialização do modelo da tabela
        this.table = table; // Inicialização da tabela
    }

    // Métodos do modelo CRUD

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        produtos = new ProdutosDAO().listarTodos(); // Obtém os produtos atualizados do banco de dados

        // Adiciona os produtos como novas linhas na tabela Swing
        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[] { produto.getCodigoBarra(), produto.getNome(),
                    produto.getPreco(), produto.getQuantidade() });
        }
    }

    // Método para cadastrar um novo produto no banco de dados
    public void cadastrar(String codigoBarra, String nome, String preco, String quantidade) {
        try {
            validarCampos(codigoBarra, nome, preco, quantidade);
            int existeCodigo = new ProdutosDAO().verificaCodigo(codigoBarra);

            if (existeCodigo > 0) {
                throw new NumberFormatException("Erro! Já existe um produto com o mesmo código");
            }
            int option = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente cadastrar esse produto do banco de dados?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {

                // Chama o método de cadastro no banco de dados
                new ProdutosDAO().cadastrar(codigoBarra, nome, Double.parseDouble(preco), Integer.parseInt(quantidade));
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                // Atualiza a tabela de exibição após o cadastro
                atualizarTabela();
                // Mensagem confirmando o cadastro
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para atualizar os dados de um produto no banco de dados
    public void atualizar(String codigoBarra, String nome, String preco, String quantidade) {
        try {
            validarCampos(codigoBarra, nome, preco, quantidade);
            int option = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente udar as informações de produto no banco de dados?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Chama o método de atualização no banco de dados
                new ProdutosDAO().atualizar(codigoBarra, nome, Double.parseDouble(preco), Integer.parseInt(quantidade));
                // Atualiza a tabela de exibição após a atualização
                atualizarTabela();
                // Mensagem confirmando a atualização
                JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para apagar um produto do banco de dados
    public void apagar(String codigoBarra) {
        int option = JOptionPane.showConfirmDialog(null,
                "Deseja realmente apagar esse produto no banco de dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Chama o método de exclusão no banco de dados
            new ProdutosDAO().apagar(codigoBarra);
            // Atualiza a tabela de exibição após a atualização
            atualizarTabela();
            // Mensagem confirmando a exclusão
            JOptionPane.showMessageDialog(null, "Produto apagado com sucesso.");
        }

    }

    // Método privado para validar os campos do produto
    private void validarCampos(String codigoBarra, String nome, String preco, String quantidade) {
        if (nome.isEmpty() || codigoBarra.isEmpty() || preco.isEmpty() || quantidade.isEmpty()) {
            throw new NumberFormatException("Erro! Verifique se há algum campo vazio");
        }
        if (!codigoBarra.matches("[0-9]+")) {
            throw new NumberFormatException("Erro! Verifique se o campo código de barras possui apenas números");
        }
        if (preco.contains(",")) {
            throw new NumberFormatException("Erro! Use ponto no lugar de vírgula no campo preço");
        }
        if (!preco.matches("[0-9.]+")) {
            throw new NumberFormatException("Erro! Verifique se o campo preço possui apenas números");
        }
        if (!quantidade.matches("[0-9]+")) {
            throw new NumberFormatException("Erro! Verifique se o campo quantidade possui apenas números");
        }
        if (!nome.matches("[a-zA-Z]+")) {
            throw new NumberFormatException("Erro! Verifique se o nome do produto contém apenas letras");
        }
    }
}
