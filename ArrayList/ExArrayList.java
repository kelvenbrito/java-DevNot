package ArrayList;

import java.util.*;

import javax.swing.JOptionPane;

/**
 * ExemploArrayList
 */
public class ExArrayList {
    public static void main(String[] args) {
        // criando a Arraylista de String com obj de nome carros
        ArrayList<String> carros = new ArrayList<String>();// ArrayList
        List carro1 = new ArrayList<>();// coleção
        // Adicionando elementos na coleção(ArrayList)
        // carros.add(JOptionPane.showInputDialog("Digite uma marca de carro"));
        carros.add("Fusca");
        carros.add("Brasilia");
        carros.add("Chevete");
        carros.add("Monza");
        carros.add("Monza");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));
        }

        // ordenar uma lista(sort - Collections)
        Collections.sort(carros);
        // ordenar uma lista(sort - Collections)
        Collections.reverse(carros);

        // Iterando com For-each
        for (String i : carros) {
            System.out.println(i);

        }

        carros.clear(); // apaga o ArrayList
        // Imprimindo a coleção

        System.out.println(carros);

        ArrayList<Integer> num = new ArrayList<>();

        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o 1º")));
        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o 2º")));
        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o 3º")));
        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o 4º")));
        num.add(Integer.parseInt(JOptionPane.showInputDialog("Digite o 5º")));

        Collections.sort(num);
        for (int i = 0; i < num.size(); i++) {
            System.out.println(num.get(i));
        }
System.out.println("\n");
        Collections.reverse(num);
        for (int i : num) {
            System.out.println(i);

        }

    }
}
