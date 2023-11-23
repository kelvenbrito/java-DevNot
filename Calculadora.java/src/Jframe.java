import javax.swing.JFrame;


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
