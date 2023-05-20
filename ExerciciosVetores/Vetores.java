package ExerciciosVetores;

import java.util.Scanner;

public class Vetores {
    Scanner sc = new Scanner(System.in);

    public void Exercicio1() {
        int vetorA[] = new int[5], vetorB[] = new int[5];
        int x = 1;

        for (int c = 0; c < 5; c++) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[c] = sc.nextInt();

            vetorB[c] = vetorA[c];
            x++;

        }
        System.out.println("Os numeros dos indices do vetor B são: ");
        for (int s : vetorB) {
            System.out.print(s + ";");
        }
    }

    public void Exercicio2() {
        int vetorA[] = new int[8], vetorB[] = new int[vetorA.length];
        int x = 1;

        for (int c = 0; c < vetorA.length; c++) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[c] = sc.nextInt();

            vetorB[c] = vetorA[c] * 2;
            x++;

        }
        System.out.println("Os numeros digitados multiplicado por 2 são: ");
        for (int s : vetorB) {
            System.out.print(s + ";");
        }

    }

    public void Exercicio3() {
        int vetorA[] = new int[15], vetorB[] = new int[vetorA.length];
        int x = 1, s = 0;

        for (int c = 0; c < vetorA.length; c++) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[c] = sc.nextInt();

            vetorB[c] = vetorA[c] * vetorA[c];
            x++;

        }

        while (s != vetorB.length) {
            System.out.println(vetorA[s] + " A o quadrado é: " + vetorB[s]);
            s++;
        }

    }

    public void Exercicio4() {
        int vetorA[] = new int[15];
        double vetorB[] = new double[vetorA.length];
        int x = 1, s = 0;

        for (int c = 0; c < vetorA.length; c++) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[c] = sc.nextInt();

            vetorB[c] = Math.sqrt(vetorA[c]);
            x++;

        }
        System.out.println("A raiz quadrada dos numeros são: ");
        while (s != vetorB.length) {
            System.out.println(" A Raiz quadrada de " +vetorA[s] + " é: " + vetorB[s]);
            s++;
        }

    }

    public void Exercicio5() {
        int vetorA[] = new int[10], vetorB[] = new int[vetorA.length];
        int x = 1;

        for (int c = 0; c < vetorA.length; c++) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[c] = sc.nextInt();

            vetorB[c] = vetorA[c] * c;
            x++;

        }
        System.out.println("Os numeros são: ");
        for (int s : vetorB) {
            System.out.print(s + ";");
        }
    }

    public void Exercicio6() {
        int vetorA[] = new int[10], vetorB[] = new int[vetorA.length], vetorC[] = new int[vetorA.length];
        int x = 1,s=0;

        for (int c = 0; c < vetorA.length; c++) {
            System.out.println("Digite os numeros a serem somados");
            System.out.println("Digite o valor do Vetor A");
            vetorA[c] = sc.nextInt();
            System.out.println("Digite o valor do Vetor B");
            vetorB[c] = sc.nextInt();

            vetorC[c] = vetorA[c] + vetorB[c];
          x++;

        }
    
        while (s < vetorC.length) {
            System.out.println("As somas do indice" +s +"º dos vetores A e B é: " +vetorC[s]);

            s++;
        }
    }

}
