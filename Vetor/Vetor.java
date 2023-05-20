package Vetor;

import java.util.Scanner;

import javax.print.attribute.standard.Media;

public class Vetor {
    Scanner sc = new Scanner(System.in);

    public void Exercicio1() {
        int[] numeros = new int[] {4,5,3,2,1 };
        int x = 1;
        for (int c = 0; c < numeros.length; c++) {
            System.out.println ("Digite um valor para a posição "+ c +" do vetor");
            numeros[c] = sc.nextInt();
        }
        for(int n = 0; n < numeros.length; n++){
            
            System.out.println(x+ "º numero é " +numeros[n]);
            x++;
        }

    }

    public void Exercicio2() {
        double[] numeros = new double[10] ;
        int x = 10;
        for (int c = 0; c < numeros.length; c++) {
            System.out.println ("Digite um valor para a posição "+ c +" do vetor");
            numeros[c] = sc.nextDouble();
            
        }
          for(int n = 9; n>= 0; n-- ){ 
            System.out.println(x+ "º numero é " +numeros[n]);
            x--; 
        }

    }

  
    public void Exercicio3(){
        double[] numeros = new double[4];
        double somaN = 0, media=0;
       
        for (int c = 0; c < numeros.length; c++) {
            System.out.println ("Digite a"+ c  +"Notas ");
            numeros[c] = sc.nextDouble();

            somaN  = somaN+ numeros[c];
           
        
        } 
        media = somaN/4;

        System.out.println( "A média é: " +media);
    }
}
