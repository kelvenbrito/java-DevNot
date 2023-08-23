import javax.swing.JOptionPane;

public class JoptionPaneSwing extends JOptionPane {
    public JoptionPaneSwing() {

        String informacao = "Minha janela JOptionPane";
        JOptionPane.showMessageDialog(getComponentPopupMenu(), informacao, informacao, JOptionPane.INFORMATION_MESSAGE);
    }
}
