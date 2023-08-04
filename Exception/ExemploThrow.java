package Exception;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        // digitação de senhas e login
        boolean testSenha = true;

        while (testSenha) {
            try {
                String login = JOptionPane.showInputDialog("Informe um nome de login");
                String dataNascimento = JOptionPane.showInputDialog("Informe a Data de Nascimento [dd/mm/aa]");
                dataNascimento = dataNascimento.replace("/", "");
                String senhaDigitada = JOptionPane.showInputDialog("Informe uma Senha de 6 Digitos");
                
                if (senhaDigitada.length() != 6) {
                    throw new Exception("Senha Invalida! \n A senha de ve ter 6 digitos");
                }else if(senhaDigitada.equals(login)){
                    throw new Exception("Senha Invalida! \n A senha não pode ser igual a o login");
                }else if(senhaDigitada.equals(dataNascimento)){
                    throw new Exception("Senha Invalida! \n A senha não pode ser igual a data");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Senha cadastrada com sucesso!"); 
                    testSenha = false;
                }
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, erro.getMessage());
            }
        }
    }
}