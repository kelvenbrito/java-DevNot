package ExerciciosIfElse;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sd = new Scanner(System.in);
       
        Exercicios obj = new Exercicios();
        String resp = "";

        for (int c = 0; c != 1;) {

            System.out.println("Informe o numero da questão que você deseja:");
            int numquest = sc.nextInt();

            switch (numquest) {
                case 1:
                    obj.Exercicio1();
                    break;
                case 2:
                    obj.Exercicio2();
                    break;
                case 3:
                    obj.Exercicio3();
                    break;
                case 4:
                    obj.Exercicio4();
                    break;
                case 5:
                    obj.Exercicio5();
                    break;
                case 6:
                    obj.Exercicio6();
                    break;
                case 7:
                    obj.Exercicio7();
                    break;
                case 8:
                    obj.Exercicio8();
                    break;
                case 9:
                    obj.Exercicio9();
                    break;
                case 10:
                    obj.Exercicio10();
                    break;
                case 11:
                    obj.Exercicio11();
                    break;
                case 12:
                    obj.Exercicio12();
                    break;
                default:
                    System.out.println(numquest + " É um valor invalido digite do numero 1 até 12\n");

            }

            int respCert = 0;
            while (respCert != 1) {
                System.out.println(
                     "Você deseja encerrar o programa? \ndigite sim para encerrar o programa ou nao para continuar!");
                resp = sd.nextLine();
                if (resp.toLowerCase().equals("sim")) {
                    c = 1;
                    respCert = 1;
                    System.out.println("Programa encerrado");
                } else if (resp.toLowerCase().equals("nao")) {
                    c = 0;
                    respCert = 1;
                } else {
                    System.out.println("Resposta invalida!\n");
                }
            }
        }

    }

}
