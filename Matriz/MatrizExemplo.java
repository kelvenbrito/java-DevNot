package Matriz;

import java.util.Random;
import java.util.Scanner;



public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void Exemoplo1() {
        // Criar uma matriz 10X9, preencher, imprimir e manipular
        // declarar a matriz
        int matriz[][] = new int[10][9];// 10 linhas X 9 colunas
        // prencher a minha matriz
        for (int i = 0; i < 10; i++) {// laço referente a 1º dimensão
            for (int j = 0; j < 9; j++) {// laço referente a 2º dimensão
                matriz[i][j] = rd.nextInt(9);
            }

        }
        // mostrar a minha matriz (imprimir)
        for (int i = 0; i < 10; i++) {// laço referente a 1º dimensão
            for (int j = 0; j < 9; j++) {// laço referente a 2º dimensão
                System.out.println("matriz[" + i + "][" + j + "]=" + matriz[i][j]);
            }

        }
        // Imprimir em formato de matriz
        for (int i = 0; i < 10; i++) {
            System.out.print("| ");
            for (int j = 0; j < 9; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println("|");

        }
        // somar todos os elementos da 4º linha
        int somal = 0;
        for (int i = 0; i < 9; i++) {
            somal += matriz[3][i];

            System.out.println("---------------------------------");
            System.out.println("Soma da 4º linha: " + somal);
        }

        // somar todos os elementos da 4º coluna
        int somac = 0;
        for (int i = 0; i < 10; i++) {
            somac += matriz[i][3];

            System.out.println("---------------------------------");
            System.out.println("Soma da 4º coluna: " + somac);
        }
    }

    public void Exercicio1() {
        int matriz[][] = new int[5][5];
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz.length; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
    }

    public void Exercicio2() {
        int matriz[][] = new int[4][4];
        int somc=0;
        

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                matriz[i][j] = rd.nextInt(9);
            }

        }
        for (int i = 0; i < 4; i++) {
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
                System.out.print(matriz[i][j] + " ");

            }
            System.out.println("|");

        }
        int matrizb[][] = new int[4][4];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matrizb[j][i]=matriz[i][j];
            }
        }
        System.out.println("------------------");
        for (int i = 0; i < 4; i++) {
           
            System.out.print("| ");
            for (int j = 0; j < 4; j++) {
               
                System.out.print(matrizb[i][j] + " ");

              if(i==j){
                somc+=matriz[i][j];
              }

            } 
            System.out.println("|");

        }
        System.out.println("---------------------------------");
            System.out.println("Soma da diagonal principal: " + somc);

       
    }
}
