package Colecoes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // Cadastrar novo carro
        // Consultar carro
        // Excluir carro
        List<Carros> listaCarros = new ArrayList<>();
        boolean aberto = true;
        String  Consulta="";
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\\n" + //
                    " 2-Consulta\\n" + //
                    " 3-Excluir"));
            if (acao == 1) {

                Carros car = new Carros(JOptionPane.showInputDialog("Digite a marca do carro"), JOptionPane.showInputDialog("Digite o modelo do carro"), JOptionPane.showInputDialog("Digite a Ano do carro"), JOptionPane.showInputDialog("Digite a cor do carro"));

                listaCarros.add(car);
               
            }else if(acao == 2){
                for (Carros i : listaCarros) {
                  Consulta += i.getMarca()+" "+i.getModelo()+"\n";
        
                }
                JOptionPane.showMessageDialog(null, Consulta);
            }

        }
    }
}
