package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Produtos;

public class ProdutosDAO {
    // atributo
    private Connection connection;
    private List<Produtos> produtos;

    // construtor
    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos_noite (codProduto VARCHAR(255) PRIMARY KEY, nome VARCHAR(255), preco DOUBLE PRECISION, quantidade INTEGER)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de produtos criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de produtos: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        produtos = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM produtos_noite");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Produtos com os valores do
                // registro

                Produtos produto = new Produtos(
                        rs.getString("codProduto"),
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"));
                produtos.add(produto); // Adiciona o objeto Produto à lista de produtos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return produtos; // Retorna a lista de carros recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String codProduto, String nome, double preco, int quantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO produtos_noite (codProduto, nome, preco, quantidade)VALUES (?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codProduto);
            stmt.setString(2, nome);
            stmt.setDouble(3, preco);
            stmt.setInt(4, quantidade);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String codProduto, String nome, double preco, int quantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo código do
        // produto
        String sql = "UPDATE produtos_noite SET nome = ?, preco = ?, quantidade = ? WHERE codProduto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome); // Corrigido: nome vem primeiro
            stmt.setDouble(2, preco); // Corrigido: preco em segundo
            stmt.setInt(3, quantidade); // Corrigido: quantidade em terceiro
            stmt.setString(4, codProduto); // Por último, o código do produto

            int rowsEdit = stmt.executeUpdate(); // Executa a instrução SQL e obtém o número de linhas afetadas
            if (rowsEdit > 0) {
                System.out.println("Produto atualizado com sucesso");
            } else {
                System.out.println("Nenhum produto foi atualizado. Verifique o código do produto.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codProduto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo código do produto
        String sql = "DELETE FROM produtos_noite WHERE codProduto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codProduto);
            int rowsDeleted = stmt.executeUpdate(); // Executa a instrução SQL e obtém o número de linhas deletadas
            if (rowsDeleted > 0) {
                System.out.println("Produto apagado com sucesso");
            } else {
                System.out.println("Nenhum produto foi apagado. Verifique o código do produto.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public int verificaCodigo(String codigoProduto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para pegar dados pelo codProduto
        String sql = "SELECT codProduto FROM produtos_noite WHERE codProduto = ? ";
        int codProduto = 0;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigoProduto);
            rs = stmt.executeQuery();
            if (rs.next()) {
                codProduto = rs.getInt("codProduto");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }

        return codProduto;
    }

}
