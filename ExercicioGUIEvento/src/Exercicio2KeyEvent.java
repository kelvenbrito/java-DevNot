import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Exercicio2KeyEvent extends JFrame {
    //construtor
    public Exercicio2KeyEvent() {
        super("Exercicio2");
        //criar um painel principal
        JPanel mainPanel = new JPanel();
        this.add(mainPanel);
        //add os componentes
        mainPanel.add(new JLabel("Digite seu Texto:"));
        JLabel texto2 = new JLabel();
        mainPanel.add(texto2);
        JTextField caixa1 = new JTextField(20);
        mainPanel.add(caixa1);
        JLabel texto1 = new JLabel();
        mainPanel.add(texto1);
        //set Frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 200);
        this.setVisible(true);
        //tratamento de eventos
        caixa1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
                char typedKey = e.getKeyChar();
                texto1.setText(caixa1.getText());
                texto2.setText(""+typedKey);
            }
            @Override
            public void keyPressed(KeyEvent e) {
                // Este método é chamado quando uma tecla é pressionada
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Este método é chamado quando uma tecla é liberada
            }
        });
    }
}