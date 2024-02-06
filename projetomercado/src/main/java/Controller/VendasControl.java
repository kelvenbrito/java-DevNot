package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ProdutosDAO;
import Connection.VendasDAO;
import Model.Vendas;

public class VendasControl {
    // Atributos
    private List<Vendas> vendas; // Lista de vendas
    private DefaultTableModel tableModel; // Modelo da tabela
    private JTable table; // Tabela

    // Construtor
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas; // Inicialização da lista de vendas
        this.tableModel = tableModel; // Inicialização do modelo da tabela
        this.table = table; // Inicialização da tabela
    }

    // Método para cadastrar uma nova venda no banco de dados
    public void cadastrar(String cpf, String totalCompra, String dataHora) {
        int option = JOptionPane.showConfirmDialog(null,
                "Deseja realmente cadastrar essa venda no banco de dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            // Chama o método de cadastro no banco de dados
            new VendasDAO().cadastrar(cpf, totalCompra, dataHora);

            // Mensagem confirmando o cadastro
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso.");
        }
    }

    // Método para apagar uma venda do banco de dados
    public void apagar(String idSerial) {
        int option = JOptionPane.showConfirmDialog(null,
                "Deseja realmente Excluir venda no banco de dados?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            // Chama o método de exclusão no banco de dados
            new VendasDAO().apagar(idSerial);

            // Mensagem confirmando a exclusão
            JOptionPane.showMessageDialog(null, "Venda apagada com sucesso.");
        }
    }

    // Método para atualizar os dados de um produto no banco de dados após a venda
    public void vender(String codigoBarra, int quantidade) {
        try {
            
            // Chama o método que registra a venda no banco de dados
            new VendasDAO().vender(codigoBarra, quantidade);
            // Confirmação de venda

        } catch (NumberFormatException e) {
            // Tratamento de erro
            e.printStackTrace();
        }
    }
}
