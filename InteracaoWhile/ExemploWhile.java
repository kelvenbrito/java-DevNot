package InteracaoWhile;

import java.util.Random;
import java.util.Scanner;


public class ExemploWhile {
    Scanner sc = new Scanner(System.in);

    public void Exemplo1() {
        int iteracao = 0;
        while (iteracao < 100) {
            iteracao += 1;
            System.out.println("Essa é interacao de numero " + iteracao);
        }
    }

    public void Exemplo2() { // jogo de adivilhação
        Random random = new Random(); // metodo para escolher um numero aleatorio
        System.out.println("============================");
        // Aleatórios de 0 até 9
        int numeroAleatorio = random.nextInt(10);
        boolean tentarNovamente = true;
        System.out.println("Aperte CTRL+C, a qualquer momento, para parar.");
        // Enquanto tentarNovamente igual a true, itera novamente.
        while (tentarNovamente) {
            System.out.print("Tente adivinhar o número: ");
            int numero = sc.nextInt();
            // Repare que a relação abaixo e a de diferença,
            // enquanto diferente, retorna true e, por isso,
            // tenta novamente.
            tentarNovamente = numeroAleatorio != numero;
            if (tentarNovamente) {
                System.out.println("Errado!");
            }
        }
        System.out.println("Parabéns! Você adivinhou. Era o número"
                + numeroAleatorio + " mesmo.");
        System.out.println("Fim!");
        System.out.println("============================");

    }

    public void Exemplo3(){
        int[] vetor = new int[5];
        int i = 0;

        while (i<5) {
            vetor[i] =sc.nextInt();
            i++;
        }
    }
}
