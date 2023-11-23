package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Model.Clientes;

public class ClientesControl {
    // atributos
    private List<Clientes> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesControl (List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientes = new ClientesDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEndereco(),

                    cliente.getTelefone(), cliente.getCpf() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String nome, String endereco, String telefone, String cpf) {

        try {
            if (nome.isEmpty()||endereco.isEmpty()||telefone.isEmpty()||cpf.isEmpty()) {
                 throw new NumberFormatException("Erro! Verifique se há algum campo vazio");
            }

            // Verifica se o valor pode ser convertido para um número
            if (!cpf.matches("[0-9]*")) {
                throw new NumberFormatException("No campo cpf deve haver somente números");
            }

            if (!telefone.matches("[0-9]+")) {
                throw new NumberFormatException("No campo telefone deve haver somente números");
            }

            

            // Conversão para número apenas se a validação for bem-sucedida
            int valorNumero = Integer.parseInt(cpf);
            int telefoneNumero = Integer.parseInt(telefone);
            // Se a conversão for bem-sucedida, cadastra no banco de dados
            new ClientesDAO().cadastrar(nome, endereco, telefone, cpf);
            atualizarTabela(); // Atualiza a tabela de exibição após o cadastro

        } catch (NumberFormatException e) {
            // Tratamento da exceção ou exibição de mensagem de erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String nome, String endereco, String telefone, String cpf) {
        new ClientesDAO().atualizar(nome, endereco, telefone, cpf);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String cpf) {
        new ClientesDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}
