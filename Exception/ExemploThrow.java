package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        // digitação de senhas
        boolean testSenha = true;

        while (testSenha) {
            try {

                String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
                if (senhaDigitada.length() != 6) {
                    throw new Exception("Senha Invalida");
                }

                else {
                    System.out.println("Senha cadastrada com sucesso!");
                    testSenha = false;
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
    }
}