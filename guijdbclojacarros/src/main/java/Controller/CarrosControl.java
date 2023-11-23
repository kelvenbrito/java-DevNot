package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

public class CarrosControl {
    // atributos
    private List<Carros> carros;
    private DefaultTableModel tableModel;
    private JTable table;

    // construtor
    public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
        this.carros = carros;
        this.tableModel = tableModel;
        this.table = table;
    }

    // métodos do modelo CRUD
    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        carros = new CarrosDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (Carros carro : carros) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

                    carro.getAno(), carro.getPlaca(), carro.getValor() });
        }
    }

    // Método para cadastrar um novo carro no banco de dados
    public void cadastrar(String marca, String modelo, String ano, String placa, String valor) {
      

        try {
            if (marca.isEmpty()||modelo.isEmpty()||ano.isEmpty()||placa.isEmpty()||valor.isEmpty()) {
                throw new NumberFormatException("Erro! Verifique se há algum campo vazio");
           }
            // Verifica se o valor pode ser convertido para um número
            if (!valor.matches("[0-9]*")) {
                throw new NumberFormatException("No campo valor deve haver somente números");
            }

            if (!ano.matches("[0-9]*")) {
                throw new NumberFormatException("No campo ano deve haver somente números");
            }

            if (placa.length() != 7) {
                 throw new NumberFormatException("Erro o valor digitado não corresponde ao codigo padrao de uma placa no brasil!\n No campo Placa deve haver quatro letras e três numeros");
            }
            if (!placa.substring(0, 3).matches("[A-Z]*")) {
                throw new NumberFormatException("Erro o valor digitado não corresponde ao codigo padrao de uma placa no brasil!\n  Você deve digitar letras nos tres digitos iniciais!");
            }
            if (!placa.substring(4).matches("[0-9]*")) {
               throw new NumberFormatException("Erro o valor digitado não corresponde ao codigo padrao de uma placa no brasil!\n  Você deve digitar numeros nos quatros digitos finais!");
            }

            // Conversão para número apenas se a validação for bem-sucedida
            double valorNumero = Double.parseDouble(valor);
            double anoNumero = Double.parseDouble(ano);
            // Se a conversão for bem-sucedida, cadastra no banco de dados
            new CarrosDAO().cadastrar(marca, modelo, ano, placa, valor);
            atualizarTabela(); // Atualiza a tabela de exibição após o cadastro

        } catch (NumberFormatException e) {
            // Tratamento da exceção ou exibição de mensagem de erro
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    // Método para atualizar os dados de um carro no banco de dados
    public void atualizar(String marca, String modelo, String ano, String placa, String valor) {
        new CarrosDAO().atualizar(marca, modelo, ano, placa, valor);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um carro do banco de dados
    public void apagar(String placa) {
        new CarrosDAO().apagar(placa);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }
}