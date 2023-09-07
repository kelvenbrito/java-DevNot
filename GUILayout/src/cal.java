import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.*;

public class cal {
    

    private JTextField display;
    
   public cal() {
   
   
    

   // configurando o Layout do frame
  


        // Configurar a janela
       this.setTitle("Calculadora Básica");
        this.setSize(300, 400);
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




    }

