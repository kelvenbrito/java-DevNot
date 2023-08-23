
    
    import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ExcContComp  extends JFrame {
    //atributo
     int clickCount = 0;
    //construtor
    public ExcContComp() {
      
        super("JFlame");
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JButton but = new JButton("criar botao");
       
        JPanel painel = new JPanel();
        painel.add(but);
        
        this.getContentPane().add(painel);
        this.pack();
              
        
       
        but.addActionListener(e -> {
     
            clickCount++;
              JButton but2 = new JButton(String.valueOf(clickCount));
             FlowLayout flow = new FlowLayout(); // Define o layout do container
            this.setLayout(flow); // Seta layout do container
           
              JPanel painel2 = new JPanel();
              painel.add(but2);
        
            this.getContentPane().add(painel2);
            this.pack();
           


        });


     
        this.setVisible(true);
    }

}

