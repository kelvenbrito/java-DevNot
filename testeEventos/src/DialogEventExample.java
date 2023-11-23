import javax.swing.*;

public class DialogEventExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Janela de Diálogo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Mostrar Janela de Diálogo");
        button.addActionListener(e -> mostrarJanelaDialogo(frame));

        frame.getContentPane().add(button);
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
