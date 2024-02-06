package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.Clientes;
import Model.Produtos;

public class ClientesDAO {
    // atributo
    private Connection connection;
    private List<Clientes> clientes;

    // construtor
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_noite (nome VARCHAR(255), cpf VARCHAR(255) PRIMARY KEY)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de clientes criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de clientes: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        clientes = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_noite");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Cliente com os valores do
                // registro

                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("cpf"));
                clientes.add(cliente); // Adiciona o objeto Produto à lista de produtos
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return clientes; // Retorna a lista de carros recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String cpf) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO clientes_noite (nome, cpf)VALUES (?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Criente inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String cpf) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para apagar dados pela placa
    String sql = "DELETE FROM clientes_noite WHERE cpf = ?";
    try {
    stmt = connection.prepareStatement(sql);
    stmt.setString(1, cpf);
    stmt.executeUpdate(); // Executa a instrução SQL
    System.out.println("Cliente apagado com sucesso");
    } catch (SQLException e) {
    throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
    } finally {
    ConnectionFactory.closeConnection(connection, stmt);
    }
    }




public int verificaCpf(String cpf) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para pegar dados pelo codProduto
    String sql = "SELECT cpf FROM clientes_noite WHERE cpf = ? ";
    int cpfExiste = 0;
    ResultSet rs = null;

    try {
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, cpf);
        rs = stmt.executeQuery();

        if (rs.next()) {
           cpfExiste= rs.getInt("cpf");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        ConnectionFactory.closeConnection(connection, stmt, rs);
    }

    return cpfExiste;
}

}