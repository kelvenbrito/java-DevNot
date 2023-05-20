package InteracaoWhile;

import java.util.Scanner;

public class ExerciciosWhile {
    Scanner sc = new Scanner(System.in);

    public void Exercicio1() {
        //  vetorB[] recebe vetorA[]
        int[] vetorA = new int[5], vetorB = new int[5];
        int i = 0, x = 1;
        while (i < vetorA.length) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[i] = sc.nextInt();
            vetorB[i] = vetorA[i];
            x++;
            i++;
        }
        i = 0;
        while (i < vetorB.length) {
            System.out.println("VetorB[" + i + "]" + "=" + vetorB[i]);
            i++;

        }
    }

    public void Exercicio2() {
        //VetorB recebe VetorA Mutiplicado por 2
        int vetorA[] = new int[8], vetorB[] = new int[vetorA.length];
        int x = 1, i = 0;

        while (i < vetorA.length) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[i] = sc.nextInt();

            vetorB[i] = vetorA[i] * 2;
            x++;
            i++;
        }
        i = 0;
        while (i < vetorB.length) {
            System.out.println("VetorB[" + i + "]" + "* 2 =" + vetorB[i]);
            i++;

        }
    }

    public void Exercicio3() {
        //VetorB recebe o quadrado do VetorA
        int vetorA[] = new int[15], vetorB[] = new int[vetorA.length];
        int x = 1, i = 0;

        while (i < vetorA.length) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[i] = sc.nextInt();

            vetorB[i] = vetorA[i] * vetorA[i];
            x++;
            i++;
        }
        i = 0;

        while (i < vetorB.length) {
            System.out.println(vetorA[i] + " A o quadrado é: " + vetorB[i]);
            i++;
        }

    }

    public void Exercicio4() {
        //VetorB recebe a Raiz quadrada do VetorA
        int vetorA[] = new int[15];
        double vetorB[] = new double[vetorA.length];
        int x = 1, i = 0;

        while (i < vetorA.length) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[i] = sc.nextInt();

            vetorB[i] = Math.sqrt(vetorA[i]);
            x++;
            i++;
        }
        i = 0;
        while (i < vetorB.length) {
            System.out.println(" A Raiz quadrada de " + vetorA[i] + " é: " + vetorB[i]);
            i++;
        }

    }

    public void Exercicio5() {
         //VetorB recebe elemento de A multiplicado por seu índice
        int vetorA[] = new int[10], vetorB[] = new int[vetorA.length];
        int x = 1, i = 0;

        while (i < vetorA.length) {
            System.out.println("Digite o " + x + " numeros");
            vetorA[i] = sc.nextInt();

            vetorB[i] = vetorA[i] * i;
            x++;
            i++;
        }

        i = 0;

        while (i < vetorB.length) {
            System.out.println("VetorB[" + i + "]" +"+" +i + "=" + vetorB[i]);
            i++;
        }

    }

    public void Exercicio6() {
         //VetorC recebe a soma dos valores do indices iguais de VetorA e VetorB
        int vetorA[] = new int[10], vetorB[] = new int[vetorA.length], vetorC[] = new int[vetorA.length];
        int x = 1, i = 0;

        while (i < vetorA.length) {
            System.out.println("Digite os" +x +"º numeros serem somados");
            System.out.println("Digite o valor do Vetor A");
            vetorA[i] = sc.nextInt();
            System.out.println("Digite o valor do Vetor B");
            vetorB[i] = sc.nextInt();

            vetorC[i] = vetorA[i] + vetorB[i];
            i++;
            x++;

        }

        i=0;
        while (i < vetorC.length) {
            System.out.println("VetorA[" + i + "]" + "+" +"VetorB[" + i + "]" +"=" +vetorC[i]);

            i++;
        }
    }
}
