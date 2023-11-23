import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class Exercicio1 extends JFrame {
    public Exercicio1() {
        super("Exercicio 1");
        JPanel pMain = new JPanel();// Painel Principal dentro do JFrame
        // add painel principal ao jFrame
        this.add(pMain);
        // criando um botão e um painel de cards
        JButton bNext = new JButton("Next");
        pMain.add(bNext);

        // criar o objeto do cardLayout
        CardLayout cl = new CardLayout();

        // Criar os cards
        JPanel cards = new JPanel(cl);// painel de cards no padrão CL

        // Criar os cards da pilha
        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
        card1.add(new JButton("Botao 1"));
        card1.add(new JButton("Botao 2"));
        card1.add(new JButton("Botao 3"));
        JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
        card2.add(new JTextField("Card com Jtext", 20));
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        card3.add(new JTextField("Card com Jtext", 20));
        card3.add(new JButton("Botao 1"));
        // add os card1, car2, card3 ao cards
        cards.add(card1, "Card 1");
        cards.add(card2, "Card 2");
        cards.add(card3, "Card 3");

        pMain.add(cards);

        // set do flame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        // criar a ação do botao
        bNext.addActionListener(e -> {
            cl.next(cards);
        });

    }
}
