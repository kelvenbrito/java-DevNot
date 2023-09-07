import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LayoutCalculadoraGUI {
    public LayoutCalculadoraGUI() {
       //Construir o Layout  de uma calculadora
       JFrame janelaP = new JFrame("Layout Calculadora");
       BorderLayout border = new BorderLayout();
       janelaP.setLayout(border);
       JPanel painelV = new JPanel();//padrao FlowLayout
       JPanel painelB = new JPanel();//padrao FlowLayout
       janelaP.getContentPane().add(painelB, BorderLayout.CENTER);
       janelaP.getContentPane().add(painelV, BorderLayout.NORTH);
       //adicionar o textFild no PainelV
       JTextField caixa1 = new JTextField(25);
       painelV.add(caixa1);
       //set Layout do JPAnel
       GridLayout grid = new GridLayout(4,4);
       painelB.setLayout(grid);
       //Vetor com os texto dos botões 
       String textBotoees[]={"C", "9","8","7","/","6","5","4","*","3","2","1","-","+","0","="};
       for (int i = 0; i < textBotoees.length; i++) {
            painelB.add(new JButton(textBotoees[i]));
       }
       //set doframe
       janelaP.setDefaultCloseOperation(2);
       janelaP.pack();
       janelaP.setVisible(true);

    }
}
