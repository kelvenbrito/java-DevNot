import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AgendaUsuarios extends JPanel {
    // atributos
    private JTextField inputData;
    private JTextField inputHora;
    private JTextField inputNome;
    private JTextField inputDresc;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;

    // métodos
    public AgendaUsuarios() {

        // modelagem e criação da tabela
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Descrição");
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // declaração dos componentes
        inputData = new JTextField(20);
        inputHora = new JTextField(20);
        inputNome = new JTextField(20);
        inputDresc = new JTextField(30);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton salvarButton = new JButton("Salvar");
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Data:"));
        inputPanel.add(inputData);
        inputPanel.add(new JLabel("Hora:"));
        inputPanel.add(inputHora);
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Descrição:"));
        inputPanel.add(inputDresc);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(salvarButton);
        // set do layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        // deserialização quando abre a tabela
        File arquivo = new File("dados2.txt");
        if (arquivo.exists()) {
            usuarios = Serializacao.deserializar("dados2.txt");
            atualizarTabelaAgenda();
        }
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    inputData.setText((String) table.getValueAt(linhaSelecionada, 0));
                    inputHora.setText((String) table.getValueAt(linhaSelecionada, 1));
                    inputNome.setText((String) table.getValueAt(linhaSelecionada, 2));
                    inputDresc.setText((String) table.getValueAt(linhaSelecionada, 3));

                }
            }
        });
        OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.agendarUsuario(inputData.getText(),inputHora.getText(),inputNome.getText(), inputDresc.getText());
                inputData.setText("");
                inputHora.setText("");
                inputNome.setText("");
                inputDresc.setText("");
            }
        });
        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizarUsuarioAgenda(linhaSelecionada,inputData.getText(),inputHora.getText(),inputNome.getText(), inputDresc.getText() );

            }
        });
        apagarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagarUsuario(linhaSelecionada);
            }
        });
      
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.salvarUsuariosAgenda();
            }
        });
    }

    private void atualizarTabelaAgenda() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getData(),usuario.getHora(),usuario.getNome(), usuario.getDescrição() });
        }

    }
}