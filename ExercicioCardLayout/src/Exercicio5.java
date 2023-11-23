import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Exercicio5 extends JFrame {
    public Exercicio5() {
        super("Exercico 5");
        JPanel pMain = new JPanel();// Painel Principal dentro do JFrame
        this.add(pMain); // add painel principal ao jFrame

        // criar o objeto do cardCayout
        CardLayout cl = new CardLayout();

        // Criar os cards
        JPanel pCards = new JPanel(cl);// painel de cards no padrão CL

        pMain.add(new JLabel("Jogo do Quis!"));
        pMain.add(pCards);

        // Criar os cards da pilha

        JPanel cardI = new JPanel();
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel card4 = new JPanel();
        JPanel card5 = new JPanel();
        JPanel cardF = new JPanel();

        JButton bInicio = new JButton("Inicio");

         card1.add(new JLabel("Ex1"));
         card2.add(new JLabel("Ex2"));
         card3.add(new JLabel("Ex3"));
         card4.add(new JLabel("Ex4"));
         card5.add(new JLabel("Ex5"));
         cardF.add(new JLabel("Final"));
                  


        cardI.add(bInicio);

        card1.setLayout(new GridLayout(3, 1));

        // add os card1, car2, card3 ao cards
        pCards.add(cardI, "Home");
        pCards.add(cardI, "Home");
        pCards.add(cardI, "Home");
        pCards.add(cardI, "Home");
        pCards.add(cardI, "Home");
        pCards.add(cardI, "Home");

       

           // set do flame
           this.setDefaultCloseOperation(2);// fecha a janela e o programa
           this.setBounds(100, 100, 500, 500);
           this.setVisible(true);

    }
}
