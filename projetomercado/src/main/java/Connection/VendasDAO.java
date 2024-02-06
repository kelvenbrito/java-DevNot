package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Vendas;

public class VendasDAO {
    // atributo
    private Connection connection;
    private List<Vendas> vendas;

    // construtor
    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas_noite (idSerial SERIAL PRIMARY KEY, cpf VARCHAR(255), totalCompra VARCHAR(255), dataHora VARCHAR(255) )";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de vendas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de vendas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Vendas> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        vendas = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM vendas_noite");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Vendas com os valores do
                // registro

                Vendas venda = new Vendas(
                        rs.getString("idSerial"),
                        rs.getString("cpf"),
                        rs.getString("totalCompra"),
                        rs.getString("dataHora"));

                vendas.add(venda); // Adiciona o objeto Vendas à lista de vendas
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return vendas; // Retorna a lista de carros recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String cpf, String totalCompra, String dataHora) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO vendas_noite (cpf, totalCompra, dataHora)VALUES (?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.setString(2, totalCompra);
            stmt.setString(3, dataHora);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String idSerial) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela placa
        String sql = "DELETE FROM vendas_noite WHERE idSerial = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, idSerial);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void vender(String codProduto, int quantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo codProduto
        String sql = "UPDATE produtos_noite SET quantidade = ? WHERE codProduto = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, quantidade); // Corrigido: quantidade em terceiro
            stmt.setString(2, codProduto); // Por último, o código do produto
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

    public int quantidadeProd(String codigoProduto) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para pegar dados pelo codProduto
        String sql = "SELECT quantidade FROM produtos_noite WHERE codProduto = ?";
        int quantidade = 0;
        ResultSet rs = null;

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigoProduto);
            rs = stmt.executeQuery();

            if (rs.next()) {
                quantidade = rs.getInt("quantidade");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return quantidade;
    }

}
