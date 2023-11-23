import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de WindowListener");
        frame.setSize(300, 200);
        

        // Criação de um objeto WindowListener
        WindowListener windowListener = new WindowAdapter() {
         

            @Override
            public void windowClosing(WindowEvent e) {
               mostrarJanelaDialogo(frame);
            }

           

           
        };

   

        // Adiciona o WindowListener ao JFrame
        frame.addWindowListener(windowListener);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

         private static void mostrarJanelaDialogo(JFrame parentFrame) {
            int opcaoEscolhida = JOptionPane.showConfirmDialog(
                    parentFrame,
                    "Você gostaria de continuar?",
                    "Confirmação",
                    JOptionPane.YES_NO_OPTION
            );
    
            if (opcaoEscolhida == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(parentFrame, "Você escolheu Sim!");
            } else if (opcaoEscolhida == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(parentFrame, "Você escolheu Não!");
            } else if (opcaoEscolhida == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(parentFrame, "A janela foi fechada sem seleção.");
            }
        }
}
