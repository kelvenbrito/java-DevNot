package EstruturaDecisaoSwitch;

import java.util.Scanner;

public class SwitchCase {
    Scanner sc = new Scanner(System.in);

    public void letra() {
        System.out.println("Informe uma letra");
        String letraDigitada = sc.nextLine();
        switch (letraDigitada.toLowerCase()) {
            case "a":
                System.out.println(letraDigitada + " É vogal");
                break;
            case "e":
                System.out.println(letraDigitada + " É vogal");
                break;
            case "i":
                System.out.println(letraDigitada + " É vogal");
                break;
            case "o":
                System.out.println(letraDigitada + " É vogal");
                break;
            case "u":
                System.out.println(letraDigitada + " É vogal");
                break;
            default:
                System.out.println(letraDigitada + " É Consoante");
        }

    }

    public void mes() {
        System.out.println("Informe o numero correspondente ao mês que você deseja");
        int numMes = sc.nextInt();
        String nomeMes = "";
        switch (numMes) {
            case 1:
                nomeMes = " Janeiro";
                break;
            case 2:
            nomeMes =  " Fevereiro";
                break;
            case 3:
            nomeMes = " Março";
                break;
            case 4:
            nomeMes =" Abril";
                break;
            case 5:
            nomeMes = " Maio";
                break;
            case 6:
            nomeMes = " Junho";
                break;
            case 7:
            nomeMes =" Julho";
                break;
            case 8:
            nomeMes = " Agosto";
                break;
            case 9:
            nomeMes = " Setembro";
                break;
            case 10:
            nomeMes = " Outubro";
                break;
            case 11:
            nomeMes = " Novembro";
                break;
            case 12:
            nomeMes = " Dezembro";
                break;
            default:
                System.out.println(numMes + " É um valor invalido digite do numero 1 até 12");

        }
        System.out.println(nomeMes);
    }
}