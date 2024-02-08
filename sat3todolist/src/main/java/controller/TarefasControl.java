package controller;

import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connection.ListaDAO;
import model.Tarefas;

public class TarefasControl {
    // Atributos
    private List<Tarefas> tarefas; // Lista de tarefas
    private DefaultListModel listModel; // Modelo da lista
    private JList taskList; // lista

    public TarefasControl(List<Tarefas> tarefas, DefaultListModel<String> listModel, JList<String> taskList) {
        this.tarefas = tarefas; // Inicialização da lista de tarefas
        this.listModel = listModel; // Inicialização do modelo da tabela
        this.taskList = taskList; // Inicialização da tabela
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        listModel.clear(); // Limpa todas as linhas existentes na tabela
        tarefas = new ListaDAO().listarTodos(); // Obtém as tarefas atualizados do banco de dados

        // Adiciona as tarefas como novas linhas na tabela Swing
        for (Tarefas tarefa : tarefas) {
            listModel.addElement(new Object[] { tarefa.getDescricao(), tarefa.iscondicao() });
        }
    }

    // Método para cadastrar uma nova tarefa no banco de dados
    public void cadastrar(String descricao) {
        int option = JOptionPane.showConfirmDialog(null,
                "Deseja realmente cadastrar essa Tarefa no banco de dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            // Chama o método de cadastro no banco de dados
            new ListaDAO().cadastrar(descricao);

            // Mensagem confirmando o cadastro
            JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso.");
            // Atualiza a tabela de exibição após o cadastro
            atualizarTabela();
        }

    }

     // Método para atualizar os dados de um produto no banco de dados
     public void atualizar(String idTarefa, String descricao, String condicao) {
        try {
            int option = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente alterar as informações dessa tarefa no banco de dados?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Chama o método de atualização no banco de dados
                new ListaDAO().atualizar(idTarefa, descricao, condicao);
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
        public void apagar(String idTarefa) {
            int option = JOptionPane.showConfirmDialog(null,
                    "Deseja realmente apagar esse produto no banco de dados?",
                    "Confirmação", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                // Chama o método de exclusão no banco de dados
                new ListaDAO().apagar(idTarefa);
                // Atualiza a tabela de exibição após a atualização
                atualizarTabela();
                // Mensagem confirmando a exclusão
                JOptionPane.showMessageDialog(null, "Produto apagado com sucesso.");
            }
    
        }
}
