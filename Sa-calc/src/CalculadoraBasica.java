
    import java.awt.*;
    import javax.swing.*;
    
    public class CalculadoraBasica extends JFrame {
        private JTextField display;
    
        public CalculadoraBasica() {
            // Configurar a janela
            setTitle("Calculadora Básica");
            setSize(300, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new BorderLayout());
    
            // Adicionar um campo de texto para exibir os números e resultados
            display = new JTextField();
            add(display, BorderLayout.NORTH);
    
            // Adicionar botões para números e operações
            JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
            String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
            };
            
            for (String label : buttonLabels) {
                JButton button = new JButton(label);
                buttonPanel.add(button);
                // Adicione aqui a lógica para lidar com os cliques nos botões
            }
            
            add(buttonPanel, BorderLayout.CENTER);
        }
    
        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                CalculadoraBasica calc = new CalculadoraBasica();
                calc.setVisible(true);
            });
        }
    }
    

