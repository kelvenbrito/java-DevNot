package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import Model.Vendas;

public class VendasDAO {
    // atributo
    private Connection connection;
    private List<Vendas> vendas;

    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

         // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas_lojacarros (CodVenda SERIAL PRIMARY KEY, NomeCliente VARCHAR(255), CPFCliente VARCHAR(255), carrosVendidos VARCHAR(255), dataVenda VARCHAR(255), valorTotal VARCHAR(255))";

        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
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
            String sql = "SELECT * FROM vendas_lojacarros";
            stmt = connection.prepareStatement(sql);
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro

                Vendas venda = new Vendas(
                        rs.getString("NomeCliente"),
                        rs.getString("CPFCliente"),
                        rs.getString("carrosVendidos"),
                        rs.getString("valorTotal"),
                        rs.getString("dataVenda"),
                        rs.getString("CodVenda"));
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

    public void cadastrar(String nome, String CPF, String carVendidos, String hoje, String vt) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO vendas_lojacarros (NomeCliente, CPFCliente, carrosVendidos, dataVenda, valorTotal) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
    
            stmt.setString(1, nome); // Índice 1 para o primeiro parâmetro
            stmt.setString(2, CPF); // Índice 2 para o segundo parâmetro
            stmt.setString(3, carVendidos); // Índice 3 para o terceiro parâmetro
            stmt.setString(4, hoje); // Índice 4 para o quarto parâmetro
            stmt.setString(5, vt); // Índice 5 para o quinto parâmetro
    
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    
}