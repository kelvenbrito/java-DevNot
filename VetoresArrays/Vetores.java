package VetoresArrays;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);

    public void Exemplo1() {
        double[] valores = new double[] { 10.5, 15.8, 7.6, -17.6 };
        System.out.println("O primeiro elemento do vetor - valores[0] é " + valores[0]);
        System.out.println("O segundo elemento do vetor - valores[1] é " + valores[1]);
        System.out.println("O terceiro elemento do vetor - valores[2] é " + valores[2]);
        System.out.println("O quarto elemento do vetor - valores[3] é " + valores[3]);
        System.out.println("Digite um novo valor para a 4º posição/indice 3 ");
        valores[3] = sc.nextDouble();
        System.out.println("O novo valor da 4ºPosição/indice 3 é " + valores[3]);

    }

    public void Exemplo2() {
        // criando um vetor [vazio]

        int valoresInt[] = new int[5];
        System.out.println("Digite 5 valores inteiros ");
        valoresInt[0] = sc.nextInt();
        valoresInt[1] = sc.nextInt();
        valoresInt[2] = sc.nextInt();
        valoresInt[3] = sc.nextInt();
        valoresInt[4] = sc.nextInt();
        System.out.println("O 1º elemento do Vetor - indice[0] " + valoresInt[0]);
        System.out.println("O 2º elemento do Vetor - indice[0] " + valoresInt[1]);
        System.out.println("O 3º elemento do Vetor - indice[0] " + valoresInt[2]);
        System.out.println("O 4º elemento do Vetor - indice[0] " + valoresInt[3]);
        System.out.println("O 5º elemento do Vetor - indice[0] " + valoresInt[4]);
    }

    public void Exercicio1() {
        int[] valores = new int[5];
        int x = 1;
        for (int c = 0; c < valores.length; c++) {
            System.out.println("Digite o " + x + "º valor");
            valores[c] = sc.nextInt();
            x++;
        }
        for (int n = 0; n < valores.length; n++) {

            System.out.println(x + "º numero é " + valores[n]);
            x++;
        }

    }

    public void Exercicio2() {
        double[] valores = new double[10];
        int x = 10, p = 1;

        for (int c = 0; c < valores.length; c++) {
            System.out.println("Digite o " + p + "º valor");
            valores[c] = sc.nextDouble();
            p++;
        }

        System.out.println("Os numeros em ordem decrescente são ");
        for (int n = 9; n >= 0; n--) {
            System.out.println(x + "º = " + valores[n] + ", ");
            x--;
        }

    }

    public void Exercicio3() {
        double[] notas = new double[4];
        double somaN = 0, media = 0;
        int x = 1;
        for (int c = 0; c < notas.length; c++) {
            System.out.println("Digite a " + x + "º Notas ");
            notas[c] = sc.nextDouble();

            somaN = somaN + notas[c];
            x++;
        }
        media = somaN / 4;

        System.out.println("A média é: " + media);
    }

    public void Exercicio4() {
        String[] caracter = new String[10], caract2 = new String[10];
        int p = 0, x = 1;
        for (int c = 0; c < caracter.length; c++) {

            System.out.println("Digite a " + x + "º caracter ");
            caracter[c] = sc.nextLine();
            if (caracter[c].toLowerCase().equals("a") || caracter[c].toLowerCase().equals("e")
                    || caracter[c].toLowerCase().equals("i") || caracter[c].toLowerCase().equals("o")
                    || caracter[c].toLowerCase().equals("u")) {
                p++;
                caract2[c] = caracter[c];
            }
            x++;
        }
        for (int d = 0; d >= caract2.length; d++) {
            System.out.println("As vogais é " +caract2[d]);
            System.out.println(p);

        }
    }
}