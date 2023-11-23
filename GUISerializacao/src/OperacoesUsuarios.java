import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacoesUsuarios {
    //atributos
    private List<Usuario> usuarios;
    private DefaultTableModel tableModel;
    private JTable table;
    //construtor
    public OperacoesUsuarios(List<Usuario> usuarios, DefaultTableModel tableModel, JTable table) {
        this.usuarios = usuarios;
        this.tableModel = tableModel;
        this.table = table;
    }
    //métodos do crud
    public void cadastrarUsuario(String nome, String idade) {
        int idadeInt = Integer.parseInt(idade);
        Usuario usuario = new Usuario(nome, idadeInt);
        usuarios.add(usuario);
        atualizarTabela();
    }
    public void agendarUsuario(String data, String hora, String nome, String descricao) {
        Usuario usuario = new Usuario(data,hora,nome,descricao);
        usuarios.add(usuario);
        atualizarTabela();
    }

    public void atualizarUsuario(int linhaSelecionada, String nome, String idade, String string, String string2) {
        if (linhaSelecionada != -1) {
            int idadeInt = Integer.parseInt(idade);
            Usuario usuario = new Usuario(nome, idadeInt);
            usuarios.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

     public void atualizarUsuarioAgenda(int linhaSelecionada, String data, String hora, String nome, String descricao) {
        if (linhaSelecionada != -1) {
          
            Usuario usuario = new Usuario(data,hora,nome,descricao);
            usuarios.set(linhaSelecionada, usuario);
            atualizarTabela();
        }
    }

    public void apagarUsuario(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            usuarios.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    public void apagarTodosUsuarios() {
        usuarios.clear();
        atualizarTabela();
    }

    public void salvarUsuarios() {
        Serializacao.serializar("dados1.txt", usuarios);
    }

    public void salvarUsuariosAgenda() {
        Serializacao.serializar("dados2.txt", usuarios);
    }


    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
        }
    }

    
    private void atualizarTabelaAgenda() {
        tableModel.setRowCount(0);
        for (Usuario usuario : usuarios) {
            tableModel.addRow(new Object[] {usuario.getData(),usuario.getHora(), usuario.getNome(), usuario.getDescrição() });
        }
    }
    public void cadastrarUsuarioC(String text, String text2) {
    }
}