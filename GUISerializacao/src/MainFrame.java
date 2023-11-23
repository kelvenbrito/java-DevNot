import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame{
    public MainFrame() {
        super("App");
        setDefaultCloseOperation(2);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro de Usuários", new CadastroUsuarios());
          abas.add("Agenda de Usuários", new AgendaUsuarios());
        add(abas);
    }
    public void run(){
        pack();
        setVisible(true);
    }
}
