import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ContainersComponentes extends JFrame {
    //atributo
     int clickCount = 0;
    //construtor
    public ContainersComponentes() {
        super("JFlame");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("I am a Swing button");
        JLabel texto = new JLabel("Number of button clicks: ");
        JPanel painel = new JPanel();
        painel.add(but);
        painel.add(texto);
        this.getContentPane().add(painel);
        this.pack();
              
       
        but.addActionListener(e -> {
      
            clickCount++;
            texto.setText("Number of button clicks: " + clickCount);
        });


     
        this.setVisible(true);
    }

}
