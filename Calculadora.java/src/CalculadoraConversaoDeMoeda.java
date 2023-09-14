import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

//A classe é uma extensão do Jpanel
public class CalculadoraConversaoDeMoeda extends JPanel {
    // declaração dos componentes
    JTextField caixa1 = new JTextField(19);
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel label3 = new JLabel();
    JLabel label4 = new JLabel();

    JComboBox<String> comboBox1 = new JComboBox<>();
    JComboBox<String> comboBox2 = new JComboBox<>();

    // atributos de instância para armazenar os itens selecionado no comboBox1
    String itemSelecionado1 = "";
    String itemSelecionado2 = "";

    // Variaveis usadas nos metodos
    char euroS = 8364, libraS = 163, yuan_ieneS = 165;
    String simb1 = "", simb2 = "";
    double moeda;

    boolean converterPressionado = false;

    public CalculadoraConversaoDeMoeda() {
        super();
        // Define o GridBagLayout como layout do container
        GridBagLayout gridb = new GridBagLayout();
        this.setLayout(gridb);
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.BOTH;
        constraints1.insets = new Insets(1, 5, 1, 5); // Margens
   
        // Paineis principais
        
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();
        // Subpaineis
        JPanel painel2a = new JPanel();
        JPanel painel3a = new JPanel();
        JPanel painel3b = new JPanel();
        // Inserir os subpaineis dentro dos paineis principais
        painel2.add(painel2a);
        painel3.add(painel3a);
        painel3.add(painel3b);

           // Adicione bordas apenas à esquerda e à parte superior
        int top = 0; // Espessura da borda superior
        int left = 2; // Espessura da borda à esquerda
        int bottom = 0; // Sem borda na parte inferior
        int right = 2; // Sem borda à direita

        MatteBorder borda = BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
        painel2.setBorder(borda);

        //Adiciona borda embaixo do painel3 
        bottom=2;
       borda = BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
          painel3.setBorder(borda);

           //Adiciona borda embaixo e encima do painel1 
          top=2;
      borda = BorderFactory.createMatteBorder(top, left, bottom, right, Color.BLACK);
          painel1.setBorder(borda);
       


        // alinhar os paineis principais em colunas
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        this.add(painel1, constraints1);

        constraints1.gridy = 1;
        this.add(painel2, constraints1);

        constraints1.gridy = 2;
        this.add(painel3, constraints1);

       

        painel1.add(new JLabel("Calculadora de conversão de moeda"));

        //adiciona itens no comboBox1 e 2
        comboBox1.addItem("Escolha a moeda");
        comboBox1.addItem("Real");
        comboBox1.addItem("Dolar Americano");
        comboBox1.addItem("Euro");
        comboBox1.addItem("Libra Esterlina");
        comboBox1.addItem("Iene");
        comboBox1.addItem("Yuan chinês");
        comboBox1.addItem("Peso Argentino");

        comboBox2.addItem("Escolha a moeda");
        comboBox2.addItem("Real");
        comboBox2.addItem("Dolar Americano");
        comboBox2.addItem("Euro");
        comboBox2.addItem("Libra Esterlina");
        comboBox2.addItem("Iene");
        comboBox2.addItem("Yuan chinês");
        comboBox2.addItem("Peso Argentino");

        // Instancia os comboBox1 e comboBox2 nos medotos
        comboBox1.addItemListener(e1 -> itemSelecionadoComboBox1(e1));
        comboBox2.addItemListener(e2 -> itemSelecionadoComboBox2(e2));

        // Define o GridLayout como layout do painel 2a
        painel2a.setLayout(new GridLayout(2, 3));

        painel2a.add(comboBox1);

        label1.setHorizontalAlignment(SwingConstants.CENTER);
        label1.setText("Para");
        painel2a.add(label1);

        painel2a.add(comboBox2);

        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setText("");
        painel2a.add(label2);

        label3.setHorizontalAlignment(SwingConstants.CENTER);
        label3.setText("É igual a:");
        painel2a.add(label3);

        label4.setHorizontalAlignment(SwingConstants.CENTER);
        label4.setText("");
        painel2a.add(label4);

        painel3.setLayout(new BorderLayout());// Define o BorderLayout como layout do painel 3

        painel3.add(painel3a, BorderLayout.NORTH);
        painel3.add(painel3b, BorderLayout.CENTER);

        caixa1.setPreferredSize(new Dimension(caixa1.getPreferredSize().width, 60));// altera o height do JTextField
        Font fonte = new Font("Arial", Font.PLAIN, 24); // Altere o tipo e o tamanho da fonte
        caixa1.setFont(fonte);
        caixa1.setHorizontalAlignment(SwingConstants.CENTER);
        painel3a.add(caixa1);
        // Define o GridBagLayoutLayout como layout do painel 3b para organização dos
        // botoes
        GridBagLayout grid2 = new GridBagLayout();
        painel3b.setLayout(grid2);

        GridBagConstraints constraints2 = new GridBagConstraints();
        constraints2.fill = GridBagConstraints.BOTH;
        constraints2.insets = new Insets(2, 2, 2, 2); // Margens

        String textBotoes[] = { "C", "9", "8", "7", "6", "5", "4", "3", "2", "1", "0", ".", "Converter" };

        int gridx = 0;
        int gridy = 0;

        constraints2.gridwidth = 2;

        for (int i = 0; i < textBotoes.length; i++) {
            JButton button = new JButton(textBotoes[i]);

            if (textBotoes[i].equals("Converter")) {
                constraints2.gridwidth = 4;// o botao Converter tera o tamanho de 4 botoes
            } else {
                constraints2.gridwidth = 1;
            }

            constraints2.gridx = gridx;
            constraints2.gridy = gridy;

            button.setPreferredSize(new Dimension(93, 60)); // Altere o tamanho dos botoes

            painel3b.add(button, constraints2);

            // Adicionea o mmetodo ActionListener ao botão
            button.addActionListener(e -> botao(e));

            gridx++;
            if (gridx > 3) {
                gridx = 0;
                gridy++;
            }
        }

        constraints2.gridx = 0;
        constraints2.gridy = 2;
        constraints2.gridwidth = 2; //

    }

    public void itemSelecionadoComboBox1(ItemEvent e1) {

        // Quando for selecionado um item no comboBox1
        if (e1.getStateChange() == ItemEvent.SELECTED) {
            itemSelecionado1 = (String) e1.getItem();
            itemSelecionado2 = "";

            comboBox2.setSelectedIndex(0);
            label4.setText("");

            moeda = 1.00;
            // estrutura de condição que faz a comparaçao dos valores do ComboBox1
            // modifica o label2
            if (itemSelecionado1.equals("Real")) {
                simb1 = "R$";
                label2.setText(simb1 + moeda);
            } else if (itemSelecionado1.equals("Dolar Americano")) {
                simb1 = "U$";
                label2.setText(simb1 + moeda);
            } else if (itemSelecionado1.equals("Euro")) {
                simb1 = euroS + "";
                label2.setText(simb1 + moeda);

            } else if (itemSelecionado1.equals("Libra Esterlina")) {
                simb1 = libraS + "";
                label2.setText(simb1 + moeda);
            } else if (itemSelecionado1.equals("Yuan chinês")) {
                simb1 = "Y" + yuan_ieneS;
                label2.setText(simb1 + moeda);
            } else if (itemSelecionado1.equals("Iene")) {
                simb1 = "I" + yuan_ieneS;
                label2.setText(simb1 + moeda);
            } else {
                simb1 = "A$";
                label2.setText(simb1 + moeda);
            }
            caixa1.setText(simb1);
        }
    }

    public void itemSelecionadoComboBox2(ItemEvent e2) {
        // Quando for selecionado um item no comboBox2
        if (e2.getStateChange() == ItemEvent.SELECTED) {
            itemSelecionado2 = (String) e2.getItem();
            // estrutura de condição que faz a comparaçao dos valores do ComboBox1 e ComboBox2
            // modifica o label4
            if (itemSelecionado1.equals("Dolar Americano")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 4.93;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 0.92;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.79;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 7.26;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Iene")) {
                    moeda = 146.19;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 349.95;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                }
            } else if (itemSelecionado1.equals("Euro")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 5.37;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 1.08;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.86;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 7.72;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Iene")) {
                    moeda = 157.86;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 379.60;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "" + euroS;
                    label4.setText(simb2 + moeda);
                }
            } else if (itemSelecionado1.equals("Libra Esterlina")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 6.27;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 1.26;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 1.17;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 9.00;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Iene")) {
                    moeda = 184.03;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 442.51;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "" + libraS;
                    label4.setText(simb2 + moeda);
                }
            } else if (itemSelecionado1.equals("Yuan chinês")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 0.70;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 0.14;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.11;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 0.13;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Iene")) {
                    moeda = 20.45;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 49.17;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                }
            } else if (itemSelecionado1.equals("Peso Argentino")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 0.014;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 0.0028;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 0.0026;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 0.020;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Iene")) {
                    moeda = 0.42;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.0023;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                }
            } else if (itemSelecionado1.equals("Iene")) {
                if (itemSelecionado2.equals("Real")) {
                    moeda = 0.034;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 0.0068;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 0.0063;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 0.049;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 2.40;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.0054;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                }
            } else {
                if (itemSelecionado2.equals("Iene")) {
                    moeda = 29.37;
                    simb2 = "I" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Dolar Americano")) {
                    moeda = 0.20;
                    simb2 = "U$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Euro")) {
                    moeda = 0.19;
                    simb2 = euroS + "";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Yuan chinês")) {
                    moeda = 1.44;
                    simb2 = "Y" + yuan_ieneS;
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Peso Argentino")) {
                    moeda = 70.63;
                    simb2 = "A$";
                    label4.setText(simb2 + moeda);
                } else if (itemSelecionado2.equals("Libra Esterlina")) {
                    moeda = 0.16;
                    simb2 = libraS + "";
                    label4.setText(simb2 + moeda);
                } else {
                    moeda = 1.00;
                    simb2 = "R$";
                    label4.setText(simb2 + moeda);
                }
            }

        }
    }

    public void botao(ActionEvent e) {
        JButton button = (JButton) e.getSource(); // Obtém o botão que disparou o evento
        String buttonText = button.getText(); // recebe o valor dos botoes

        if (buttonText.equals("C")) {
            // Se o botão for "C", limpa o conteúdo do JTextField
            caixa1.setText("");
            caixa1.setText(simb1);
        } else if (buttonText.equals("Converter")) {
            try {
                String textoCaixa = caixa1.getText().replaceAll("[^\\d.]", "");// recebe o valor do JTextField
                if (textoCaixa != null && !textoCaixa.isEmpty()) {
                    double cValor = Double.parseDouble(textoCaixa); // transforma a variavel string em double
                    // faz a operação de multiplicação do valor do JTextField com o valor da
                    // variavel Moeda
                    double resultado = cValor * moeda;
                    caixa1.setText(simb2 + String.format("%.2f", resultado));
                   
                } else {
                    caixa1.setText("Preencha um valor válido");
                    converterPressionado = false; // Certifique-se de redefinir a variável em caso de erro
                }
            } catch (NumberFormatException ex) {
                // Lidar com erro de entrada inválida, se necessário
                caixa1.setText("Erro!");
                converterPressionado = false; // Certifique-se de redefinir a variável em caso de erro
            }
             converterPressionado = true; // Marque o botão "Converter" como pressionado

        } else {
            // Verifique se o botão "Converter" foi pressionfado antes de adicionar texto ao
            // JTextField
            if (converterPressionado) {

                caixa1.setText("");
                caixa1.setText(simb1);
                converterPressionado = false;
            }
            // adiciona o texto do botão ao JTextField
            caixa1.setText(caixa1.getText() + buttonText);

        }

    }
}