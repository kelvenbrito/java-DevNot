package CalculadoraDescontos;

import java.util.Scanner;

public class CalculadoraDescontos {
        public void calcular20() {
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite o preço do protudo ");
            double precoProtudo = sc.nextDouble();
            final int desconto20 =20;
            double precoDesconto = precoProtudo -((precoProtudo * desconto20) / 100);
            System.out.println("O preço com desconto é " +precoDesconto+ " Reais");
        }

        public void calcular30() {
            Scanner sd = new Scanner(System.in);
            System.out.println("Digite o preço do protudo ");
            double precoProtudo = sd.nextDouble();
            final int desconto30 =30;
            double precoDesconto = precoProtudo - ((precoProtudo * desconto30) / 100);
            System.out.println("O preço com desconto é " +precoDesconto+ " Reais");
          
        }

        }

