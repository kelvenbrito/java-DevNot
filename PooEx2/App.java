package PooEx2;

import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {

        Random rd = new Random();

        // criar um array de objetos
        agenda contatos[] = new agenda[10];
        // craiar e preencher os objetos
        for (int i = 0; i < contatos.length; i++) {
            contatos[i] = new agenda();
            // preencher
            contatos[i].setNome(JOptionPane.showInputDialog("Nome:"));
            contatos[i].setIdade(i + 18);
            contatos[i].setAltura(rd.nextDouble());
        }

        // busca de um objeto da Agenda(nome)
        String nomeBuscado = JOptionPane.showInputDialog("Informe o nome busacado");
        int cont = 0;// contador
        boolean procure = true;
        while(procure){//enquanto procure for verdadeiro loop
            if(nomeBuscado.equals(contatos[cont].getNome())){
                procure = false;//parar o laço
                JOptionPane.showMessageDialog(null, "idade:" +contatos[cont].getIdade() +"\n Altura: "+contatos[cont].getAltura());
            }
            cont++;
        }

    }
}
