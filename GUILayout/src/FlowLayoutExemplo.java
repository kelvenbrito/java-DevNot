import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlowLayoutExemplo {
    public FlowLayoutExemplo() {
        JFrame frame = new JFrame("Janela");
        JPanel c = new JPanel();
        c.add(new JButton("1"));
        c.add(new JTextField(9));
        c.add(new JButton("dois"));
        c.add(new JButton("três"));
        frame.getContentPane().add(c);
        frame.pack();
        frame.setVisible(true);
    }
}
