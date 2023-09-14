import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Jframe extends JFrame {
    public Jframe() {
        super("Calculadoras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new Jtabbedpane());
        // set frame
        pack();
        setLocationRelativeTo(null); // Centraliza a janela
        setVisible(true);
    }

 
}
