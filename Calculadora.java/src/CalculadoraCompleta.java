import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraCompleta extends JPanel {
 
    public CalculadoraCompleta() {
        createGUI();
    }

    public void createGUI() {
               setLayout(new BorderLayout());

        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setHorizontalAlignment(JTextField.RIGHT);
        add(textField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JButton[] buttons = new JButton[16];
        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (int i = 0; i < 16; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Segoe UI", Font.PLAIN, 18));
            buttons[i].setBackground(new Color(245, 245, 245));
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String label = ((JButton) e.getSource()).getText();
                    if (label.equals("C")) {
                        textField.setText("");
                    } else if (label.equals("=")) {
                        String expression = textField.getText();
                        try {
                            double result = eval(expression);
                            textField.setText(String.valueOf(result));
                        } catch (Exception ex) {
                            textField.setText("Erro");
                        }
                    } else {
                        textField.setText(textField.getText() + label);
                    }
                }

                private double eval(String expression) {
                    return new Object() {
                        int pos = -1, ch;

                        void nextChar() {
                            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
                        }

                        boolean eat(int charToEat) {
                            while (ch == ' ')
                                nextChar();
                            if (ch == charToEat) {
                                nextChar();
                                return true;
                            }
                            return false;
                        }

                        double parse() {
                            nextChar();
                            double x = parseExpression();
                            if (pos < expression.length())
                                throw new RuntimeException("Caractere inesperado: " + (char) ch);
                            return x;
                        }

                        double parseExpression() {
                            double x = parseTerm();
                            for (;;) {
                                if (eat('+'))
                                    x += parseTerm(); // Adição
                                else if (eat('-'))
                                    x -= parseTerm(); // Subtração
                                else
                                    return x;
                            }
                        }

                        double parseTerm() {
                            double x = parseFactor();
                            for (;;) {
                                if (eat('*'))
                                    x *= parseFactor(); // Multiplicação
                                else if (eat('/'))
                                    x /= parseFactor(); // Divisão
                                else
                                    return x;
                            }
                        }

                        double parseFactor() {
                            if (eat('+'))
                                return parseFactor(); // + unário
                            if (eat('-'))
                                return -parseFactor(); // - unário

                            double x;
                            int startPos = this.pos;
                            if (eat('(')) { // Parênteses
                                x = parseExpression();
                                eat(')');
                            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Números
                                while ((ch >= '0' && ch <= '9') || ch == '.')
                                    nextChar();
                                x = Double.parseDouble(expression.substring(startPos, this.pos));
                            } else {
                                throw new RuntimeException("Caractere inesperado: " + (char) ch);
                            }

                            return x;
                        }
                    }.parse();
                }
            });
            buttonPanel.add(buttons[i]);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }
}
