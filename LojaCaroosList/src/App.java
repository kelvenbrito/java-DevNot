import java.util.*;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        // Criar uma classe (carros) criar atributos e metodos
        // App
        List<Carros> listaCarros = new ArrayList<>();

        boolean aberto = true;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n" + " 2-Listar\n" + " 3-Consultar\n"));
            if (acao == 1) { // 1-Cadastrar Carros na Lista
                // criar um objeto

                String marcaCar = JOptionPane.showInputDialog("Marca do Carro");
                String modeloCar = JOptionPane.showInputDialog("Modelo do Carro");
                String anoCar = JOptionPane.showInputDialog("Ano do Carro");
                String corCar = JOptionPane.showInputDialog("Cor do Carro");

                Carros car = new Carros(marcaCar, modeloCar, anoCar, corCar);
                listaCarros.add(car);
            } else if (acao == 2) {// 2-Lista Carros Cadastro
                String listar = "";
                for (Carros carros : listaCarros) {
                    listar += carros.imprimirLN();
                }
                JOptionPane.showMessageDialog(null, listar);
            } else if (acao == 3) {// 3-Consultar um carro cadastro
                
                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Escolah o Carro:\n" + listar));
                listaCarros.get(acao2).imprimir();
            } else if (acao == 4) {
                String listar = "";
                int i = 0;
                for (Carros carros : listaCarros) {
                    listar += i + carros.imprimirLN();
                    i++;
                }
                int acao2 = Integer.parseInt(
                        JOptionPane.showInputDialog(
                                "Escolah o Carro Para Excluir:\n" + listar));
                listaCarros.get(acao2).imprimir();
                listaCarros.remove(acao2);

            }
        }
    }

    // 4-Apagar um carro cadastrado
}
