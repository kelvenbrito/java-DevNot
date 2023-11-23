import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de FocusListener");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        JTextField textField = new JTextField("Digite algo aqui...",20);
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                textField.setText(""); // Limpa o texto quando ganha o foco
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Nada a fazer quando perde o foco
            }
        });

        // Configuração do layout para o contentPane do JFrame
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(textField);
        frame.setVisible(true);
    }
}
