package ListaExtraMatrizes;

import java.util.Scanner;

public class ExMatriz {
    Scanner sc = new Scanner(System.in);

    public void exercicio1(){
       int matriz[][] = new int[4][4];

       for (int i = 0; i < matriz.length; i++) {
        System.out.print("|");
        for (int j = 0; j < matriz.length; j++) {
            matriz[i][j]=i*j;
            System.out.print(matriz[i][j]);
        }

        System.out.println("|");
       }
    }

    public void exercicio2(){
        int matriz[][] = new int[4][4];
    }
}
