
    
    import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ExcContComp  extends JFrame {
    //atributo
     int clickCount = 0;
    //construtor
    public ExcContComp() {
      
        super("JFlame");
        this.setSize(400, 400);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("criar botao");
         JLabel texto = new JLabel("Number of button clicks: ");
        JPanel painel = new JPanel();
        painel.add(but);
        painel.add(texto);
        this.setContentPane(painel);
        this.pack();
       
       
              
        
       
        but.addActionListener(e -> {
     
            clickCount++;
            texto.setText("Number of button clicks: " + clickCount);
            this.add(new JButton(""+clickCount));


        });


     
        this.setVisible(true);
    }

}

