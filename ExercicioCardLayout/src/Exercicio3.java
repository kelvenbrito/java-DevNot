import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;

public class Exercicio3 extends JFrame {
    public Exercicio3() {
        super("Exercicio 3");
        JPanel pMain1 = new JPanel();// Painel Principal dentro do JFrame
        JPanel pMain2 = new JPanel();// Painel Principal dentro do JFrame
        // add painel principal ao jFrame
        this.add(pMain1);
        this.add(pMain2);

        // criando um botão e um painel de cards
        JButton bLogin = new JButton("Login");
        JButton bCadastro = new JButton("Cadastro");

        // criar o objeto do cardCayout
        CardLayout cl = new CardLayout();

        // Criar os cards
        JPanel cards = new JPanel(cl);// painel de cards no padrão CL

        BorderLayout border1 = new BorderLayout();
        this.setLayout(border1);
        this.add(pMain1, BorderLayout.NORTH);
        this.add(pMain2, BorderLayout.CENTER);
        pMain1.add(bLogin);
        pMain1.add(bCadastro);
        pMain2.add(cards);

        // Criar os cards da pilha
        JPanel cardI = new JPanel();
        cardI.setLayout(new GridLayout(3, 1));

        cardI.add(new JLabel("Seja bem vindo!"));
        cardI.add(new JLabel("Cadastre-se e fique por dentro das novidades!"));
        cardI.add(new JLabel("Caso já tiver um cadastro, faça login para receber as noticias!"));

        JPanel cardL = new JPanel();
        cardL.setLayout(new GridLayout(6, 2));
        cardL.add(new JLabel("Tela de login!"));
        cardL.add(new JLabel("E-mail:"));
        cardL.add(new JTextField("email", 20));
        cardL.add(new JLabel("Senha:"));
        cardL.add(new JTextField("senha", 20));
        cardL.add(new JButton("Logar"));

        JPanel cardC = new JPanel();
        cardC.setLayout(new GridLayout(15, 2));
        cardC.add(new JLabel("Tela de Cadastro!"));
        cardC.add(new JLabel("Nome:"));
        cardC.add(new JTextField("nome", 20));
        cardC.add(new JLabel("Cidade:"));
        cardC.add(new JTextField("cidade", 20));
        cardC.add(new JLabel("Endereço:"));
        cardC.add(new JTextField("end", 20));
        cardC.add(new JLabel("E-mail:"));
        cardC.add(new JTextField("email", 20));
        cardC.add(new JLabel("Senha:"));
        cardC.add(new JTextField("senha", 20));
        cardC.add(new JLabel("Confirmar Senha:"));
        cardC.add(new JTextField("confirmar senha", 20));

        cardC.add(new JButton("Logar"));

        // add os card1, car2, card3 ao cards
        cards.add(cardI, "Inicio");
        cards.add(cardL, "Login");
        cards.add(cardC, "Cadastro");

        // set do flame
        this.setDefaultCloseOperation(2);// fecha a janela e o programa
        this.setBounds(100, 100, 500, 500);
        this.setVisible(true);
        bLogin.addActionListener(e -> {
            if (bLogin.getText() == "Login") {

                cl.show(cards, "Login");
                bLogin.setText("Inicio");
                bCadastro.setText("Cadastro");

            } else {

                cl.show(cards, "Inicio");
                bLogin.setText("Login");
            }
        });
        bCadastro.addActionListener(e -> {

            if (bCadastro.getText() == "Cadastro") {

                cl.show(cards, "Cadastro");
                bCadastro.setText("Inicio");
                bLogin.setText("Login");

            } else {

                cl.show(cards, "Inicio");
                bCadastro.setText("Cadastro");

            }

        });
    }
}