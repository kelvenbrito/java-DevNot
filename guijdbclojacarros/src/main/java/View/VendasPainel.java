package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.LayoutManager;

import Connection.CarrosDAO;
import Connection.ClientesDAO;
import Model.Carros;
import Model.Clientes;

public class VendasPainel extends JPanel {
    JComboBox<String> carrosComboBox;
    JComboBox<String> clientesComboBox;
    List<Carros> carros;
    List<Clientes> clientes;

    public VendasPainel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Vendas"));
        JPanel inputPanel = new JPanel();
        BorderLayout bord = new BorderLayout();
        inputPanel.setLayout(bord);
       
        clientesComboBox = new JComboBox<>();
        carrosComboBox = new JComboBox<>();
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();

        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }
        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getCpf()
                    + " " + cliente.getNome());
        }
         add(new JLabel("Carro"), BorderLayout.NORTH);
        add(carrosComboBox, BorderLayout.EAST);
        add(clientesComboBox, BorderLayout.WEST);

    }

    public void atualizarComboBox() {
        // Preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.removeAllItems();
        carrosComboBox.addItem("Selecione o Carro");
        for (Carros carro : carros) {
            carrosComboBox.addItem(carro.getMarca()
                    + " " + carro.getModelo()
                    + " " + carro.getPlaca());
        }

        clientes = new ClientesDAO().listarTodos();
        clientesComboBox.removeAllItems();
        clientesComboBox.addItem("Selecione o Cliente");
        for (Clientes cliente : clientes) {
            clientesComboBox.addItem(cliente.getCpf()
                    + " " + cliente.getNome());
        }
    }
}
