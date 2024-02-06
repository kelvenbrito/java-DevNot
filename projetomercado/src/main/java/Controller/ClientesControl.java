package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Connection.ProdutosDAO;
import Model.Clientes;

public class ClientesControl {
    // Atributos
    private List<Clientes> clientes; // Lista de clientes
    private DefaultTableModel tableModel; // Modelo da tabela
    private JTable table; // Tabela

    // Construtor
    public ClientesControl() {
        this.clientes = clientes; // Inicialização da lista de clientes
        this.tableModel = tableModel; // Inicialização do modelo da tabela
        this.table = table; // Inicialização da tabela
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String cpf, String nome) {
        try {
            
            // Verifica se há campos vazios
            if (nome.isEmpty() || cpf.isEmpty()) {
                throw new NumberFormatException("Erro! Verifique se há algum campo vazio");
            }
            // Verifica se o CPF possui apenas números
            if (cpf.matches("[0-9]+")) {
                throw new NumberFormatException("Erro! Verifique se o campo CPF possui apenas números");
            }
            // Verifica se o nome contém apenas letras
            if (nome.matches("[a-zA-Z]+")) {
                throw new NumberFormatException("Erro! Verifique se o nome contém apenas letras");
            }

            // Verifica se o CPF já está cadastrado
            int existeCpf = new ClientesDAO().verificaCpf(cpf);
            if (existeCpf > 0) {
                throw new NumberFormatException("Erro! Já existe um CPF cadastrado");
            }
            int option = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente cadastrar esse CPF no banco de dados?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Chama o método de cadastro no banco de dados
                new ClientesDAO().cadastrar(cpf, nome);

                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
            }

        } catch (NumberFormatException e) {
            // Exibe mensagem de erro caso haja exceção
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    // Método para apagar um cliente do banco de dados
    public void apagar(String cpf) {
        int option = JOptionPane.showConfirmDialog(null,
                "Deseja realmente Excluir esse CPF no banco de dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            // Chama o método de exclusão no banco de dados
            new ClientesDAO().apagar(cpf);

            // Mensagem confirmando a exclusão
            JOptionPane.showMessageDialog(null, "Cliente apagado com sucesso.");
        }

    }
}
