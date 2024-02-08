package connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Tarefas;

public class ListaDAO {
    // atributo
    private Connection connection;
    private List<Tarefas> tarefas;

    // construtor
    public ListaDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS tarefas_ToDoList(idTarefa SERIAL PRIMARY KEY, descricao VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de tarefas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de tarefas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Listar todos os valores cadastrados
    public List<Tarefas> listarTodos() {
          PreparedStatement stmt = null;
          // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
           // Declaração do objeto ResultSet para armazenar os resultados da consulta
        tarefas = new ArrayList<>();
        // Cria uma lista para armazenar as tarefas recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM tarefas_ToDoList");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Tarefas com os valores do
                // registro
                
                Tarefas tarefa = new Tarefas(
                        rs.getString("descricao"));
                       
                        tarefas.add(tarefa); // Adiciona o objeto Tarefas à lista de tarefas
                    }
                } catch (SQLException ex) {
                    System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
                } finally {
                    ConnectionFactory.closeConnection(connection, stmt, rs);
        
                    // Fecha a conexão, o PreparedStatement e o ResultSet
                }
            return tarefas; // Retorna a lista de tarefas recuperados do banco de dados

    }

    // Cadastrar Carro no banco
    public void cadastrar(String descricao) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO tarefas_ToDoList (descricao) VALUES (?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, descricao);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
    // Atualizar dados no banco
    public void atualizar(String idTarefa, String descricao, String condicao) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pelo código do
        // produto
        String sql = "UPDATE tarefas_ToDoList SET descricao = ?, condicao = ? WHERE idTarefa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, descricao); // Corrigido: nome vem primeiro
            stmt.setString(3, idTarefa); // Corrigido: quantidade em terceiro


            int rowsEdit = stmt.executeUpdate(); // Executa a instrução SQL e obtém o número de linhas afetadas
            if (rowsEdit > 0) {
                System.out.println("Tarefa atualizado com sucesso");
            } else {
                System.out.println("Nenhum tarefa foi atualizado. Verifique o código do produto.");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
     // Apagar dados do banco
     public void apagar(String idTarefa) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pela placa
        String sql = "DELETE FROM tarefas_ToDoListidSerial  WHERE idTarefa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, idTarefa);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }



}


