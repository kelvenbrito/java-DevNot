package ListaExtraMatrizes;

import java.util.Random;
import java.util.Scanner;

public class ExMatriz {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exercicio1() {
        int matriz[][] = new int[4][4];

        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = i * j;
                System.out.print(matriz[i][j]);
            }

            System.out.println("|");
        }
    }

    public void exercicio2() {
        int matriz[][] = new int[4][4];
        int maiorV = 0, x = 0, y = 0;
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = rd.nextInt(100);
                System.out.print(matriz[i][j] + "; ");
                if (matriz[i][j] > maiorV) {
                    maiorV = matriz[i][j];
                    x = i;
                    y = j;

                }
            }
            System.out.println("|");
        }

        System.out.print("O maior valor da matriz: " + maiorV);
        System.out.print("\nlocalização - linha:" + x + " coluna:" + y);

    }

    public void exercicio3() {
        int matriz[][] = new int[5][5];

        int n, x = 0;

        System.out.println("Informe um numero a ser verificado!");
        n = sc.nextInt();
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = rd.nextInt(10);
                System.out.print(matriz[i][j] + "; ");

            }
            System.out.println("|");

        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (n == matriz[i][j]) {

                    System.out.println(
                            "O valor:" + n + " está localizado na linha:" + i + " e coluna:" + j + " da matriz!");
                    x++;
                }

            }

        }
        if (x == 0) {
            System.out.println("O valor:" + n + " não foi encontrado na matriz!");
        }
    }

    public void exercicio4() {
        int matriz[][] = new int[10][10];
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matriz.length; j++) {
                if (i < j) {
                    matriz[i][j] = 2 * i + 7 * j - 2;
                } else if (i > j) {
                    matriz[i][j] = 4 * (i * i * i) - 5 * (j * j) + 1;
                } else {
                    matriz[i][j] = 3 * (i * i) + 1;
                }
                System.out.print(matriz[i][j] + ";");
            }
            System.out.println("|");
        }
    }

    public void exercicio5() {
        int matriz[][] = new int[5][4];
        int matric, media = 0, trab = 0, notaF = 0, maiorN = 0, matricMN = 0, mediaNF = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    System.out.println("Digite o número de matricula do " + (i + 1) + "º aluno");
                    matric = sc.nextInt();
                    matriz[i][j] = matric;
                } else if (j == 1) {
                    System.out.println("Digite a média das provas!");
                    media = sc.nextInt();
                    matriz[i][j] = media;
                } else if (j == 2) {
                    System.out.println("Digite a média dos trabalhos!");
                    trab = sc.nextInt();
                    matriz[i][j] = trab;

                } else {
                    notaF = media + trab;
                    matriz[i][j] = notaF;
                    mediaNF += notaF;
                    if (maiorN < notaF) {
                        maiorN = notaF;
                        matricMN = matriz[i][0];

                    }
                }
            }
        }

        mediaNF /= 5;

        for (int i = 0; i < 5; i++) {
            System.out.print("|");
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + ";");
            }
            System.out.println("|");
        }

        System.out.println("Aluno com a maior nota final - matricula: " + matricMN + " Nota final: " + maiorN
                + " \nMédia das notas finais: " + mediaNF);
    }

    public void exercicio6() {
        int matrizA[][] = new int[3][3];
        int matrizB[][] = new int[3][3];
        int matrizC[][] = new int[3][3];

        System.out.println("Informe os valores da matrizA:");

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA.length; j++) {
                System.out.println("matrizA[" + i + "][" + j + "]");
                matrizA[i][j] = sc.nextInt();
            }
        }

        System.out.println("Informe os valores da matrizB:");
        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                System.out.println("matrizB[" + i + "][" + j + "]");
                matrizB[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB.length; j++) {
                matrizC[i][j] = matrizA[i][j] * matrizB[j][i];
            }
        }

        System.out.println("--------------------------");
        System.out.println("MatrizA:");

        for (int i = 0; i < matrizA.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizA.length; j++) {
                System.out.print(matrizA[i][j] + ";");

            }
            System.out.println("|");
        }

        System.out.println("--------------------------");
        System.out.println("MatrizB:");
        for (int i = 0; i < matrizB.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizB.length; j++) {
                System.out.print(matrizB[i][j] + ";");

            }
            System.out.println("|");
        }
        System.out.println("--------------------------");
        System.out.println("Resultado da  Multiplicação da Matriz A e B:");
        for (int i = 0; i < matrizC.length; i++) {
            System.out.print("|");
            for (int j = 0; j < matrizC.length; j++) {
                System.out.print(matrizC[i][j] + ";");

            }
            System.out.println("|");
        }
    }

}