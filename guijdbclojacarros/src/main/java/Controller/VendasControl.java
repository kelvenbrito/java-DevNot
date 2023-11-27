package Controller;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesDAO;
import Connection.VendasDAO;
import Model.Vendas;

public class VendasControl {

    // atributos
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table;

    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
        this.table = table;
    }

    // métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        vendas = new VendasDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Vendas venda : vendas) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { venda.getCodVenda(), venda.getCPFCliente(), venda.getnomeClientes(),

                    venda.getCarrosVendidos(), venda.getDataVenda(), venda.getValortotal() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String nome, String cpf, String carVendidos, String hoje, String vt) {
        // cadastra no banco de dados
        new VendasDAO().cadastrar(nome, cpf, carVendidos, hoje, vt);
        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro

    }

}