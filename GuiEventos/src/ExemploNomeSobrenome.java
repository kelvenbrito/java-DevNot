 import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExemploNomeSobrenome extends JFrame {
    //atributos
    public JTextField caixa1;
    public JTextField caixa2;
    public JLabel texto;
    
    // construtor
    public ExemploNomeSobrenome() {
        super("Nome Sobrenome");
        // criar painel principal -> gridLayout
        JPanel mainPanel = new JPanel(new GridLayout(3, 2));
        this.add(mainPanel);
        // criar os componentes e add
        mainPanel.add(new JLabel("Nome:"));
        caixa1 = new JTextField();
        mainPanel.add(caixa1);
        mainPanel.add(new JLabel("Sobrenome:"));
        caixa2 = new JTextField();
        mainPanel.add(caixa2);
        JButton botao = new JButton("Concatenar");
        mainPanel.add(botao);
        texto = new JLabel();
        mainPanel.add(texto);
        // set do Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        this.setVisible(true);
        // tratamento de eventos
        // 1º forma e->{}
        // botao.addActionListener(e->{
        // //concaterna o texto das caixas
        // texto.setText(caixa1.getText()+" "+caixa2.getText());
        // //apagar o texto das Caixas
        // caixa1.setText("");
        // caixa2.setText("");
        // });
        // 2º forma chamando Evento
        // botao.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         // concaterna o texto das caixas
        //         texto.setText(caixa1.getText() + " " + caixa2.getText());
        //         // apagar o texto das Caixas
        //         caixa1.setText("");
        //         caixa2.setText("");
        //     }
        // });
        // 3° forma chamando peolo Handler(manipulador)
        Handler evento = new Handler();
        botao.addActionListener(evento);
    }

    public class Handler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            // concaterna o texto das caixas
            texto.setText(caixa1.getText() + " " + caixa2.getText());
            // apagar o texto das Caixas
            caixa1.setText("");
            caixa2.setText("");
        }
    }
}
