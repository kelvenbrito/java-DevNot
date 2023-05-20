package AtividadeRemota;

import java.util.Scanner;

public class Atividade {
    Scanner sc = new Scanner(System.in);
    Scanner sd = new Scanner(System.in);

    public void Exercicio1() {

        System.out.println("Informe o numero: ");
        int n = sc.nextInt();

        if (n >= 10) {
            System.out.println("O NUMERO É MAIOR QUE 10!");
        } else {
            System.out.println("O NUMERO NÃO É MAIOR QUE 10!");
        }

    }

    public void Exercicio2() {
        int h;
        double valorH, valorT, hEx;
        System.out.println("Informe o numero de horas trabalhada: ");
        h = sc.nextInt();
        System.out.println("Informe valor por hora trabalhada: ");
        valorH = sc.nextDouble();
        valorT = h * valorH;
        if (h > 200) {
            hEx = h - 200;
            valorT += (((hEx * valorH) * 50) / 100);
            System.out.println("salário total: " + valorT);

        } else {
            System.out.println("salário total: " + valorT);
        }

    }

    public void Exercicio3() {
        double sal, valorVend, valorT, valorC, valorE, valorCEx = 0;

        System.out.println("Informe seu Sálario: ");
        sal = sc.nextDouble();
        System.out.println("Informe o valor total de vendas: ");
        valorVend = sc.nextDouble();
        valorC = (valorVend * 3) / 100;

        if (valorVend > 2500) {
            valorE = valorVend - 2500;
            valorCEx = (valorE * 5) / 100;
            valorC += valorCEx;

            System.out.println("Comissão: " + valorC);
        } else {
            System.out.println("Comissão: " + valorC);
        }
        valorT = valorC + valorCEx + sal;
        System.out.println("salário total: " + valorT);

    }

    public void Exercicio4() {
        int numC;
        double saldo, dep, cret, saldoAt;
        System.out.println("Informe o numero da conta: ");
        numC = sc.nextInt();
        System.out.println("Informe o seu saldo: ");
        saldo = sc.nextDouble();
        System.out.println("Informe o seu Débito: ");
        dep = sc.nextDouble();
        System.out.println("Informe o seu Crédito: ");
        cret = sc.nextDouble();

        saldoAt = saldo - dep + cret;
        System.out.println("Conta: " + numC);
        System.out.println("Salto Atual: " + saldoAt);

        if (saldoAt >= 0) {
            System.out.println("Saldo Positivo!");
        } else {
            System.out.println("Saldo Negativo!");
        }
    }

    public void Exercicio5() {
        double n1, n2, n3, nm = 0;
        System.out.println("Escreva o 1º numero:");
        n1 = sc.nextDouble();
        System.out.println("Escreva o 2º numero:");
        n2 = sc.nextDouble();
        System.out.println("Escreva o 3º numero:");
        n3 = sc.nextDouble();
        System.out.println();
        if ((n1 > n2 && n2 > n3) || (n1 > n3 && n3 > n2)) {
            nm = n1;
        } else if ((n2 > n1 && n1 > n3) || (n2 > n3 && n3 > n1)) {
            nm = n2;
        } else if ((n3 > n2 && n2 > n1) || (n3 > n1 && n1 > n2)) {
            nm = n3;
        } else {
            System.out.println("Os numeros São Iguais!");

        }
        System.out.println("O maior numero: " + nm);

    }

    public void Exercicio6() {
        double qlv, valorT, desconto;
        String tipo;
        System.out.println("Informe  o tipo de combustível:");
        System.out.println("Digite (A) para álcool ou (G) para gasolina ");
        tipo = sd.next();
        System.out.println("Informe  a quantidade de litros comprado:");
        qlv = sc.nextDouble();

        if (tipo.toUpperCase().charAt(0) == 'A') {
            if (qlv <= 20) {
                desconto = (3.90 * 3) / 100;
            } else {
                desconto = (3.90 * 5) / 100;
            }
            valorT = qlv * (3.90 - desconto);
            System.out.println("Álcool");
            System.out.println("valor a ser pago: " + valorT);

        } else if (tipo.toUpperCase().charAt(0) == 'G') {
            if (qlv <= 20) {
                desconto = (5.30 * 4) / 100;
            } else {
                desconto = (5.30 * 6) / 100;
            }
            valorT = qlv * (3.90 - desconto);
            System.out.println("gasolina");
            System.out.println("valor a ser pago: " + valorT);
        } else {
            System.out.println("Letra Invalida!");
        }
    }

    public void Exercicio7() {
        double pu, desconto, total, tp;
        String nome;
        int quant;
        System.out.println("Descrição do produto:");
        nome = sd.nextLine();
        System.out.println("Digite a quantidade adquirida: ");
        quant = sd.nextInt();
        System.out.println("Informe o preço unitário:");
        pu = sc.nextDouble();
        total = quant * pu;

        if (quant > 10) {
            desconto = (total * 5) / 100;
            tp = total - desconto;
        } else if (quant <= 10 && quant > 5) {
            desconto = (total * 3) / 100;
            tp = total - desconto;
        } else {
            desconto = (total * 2) / 100;
            tp = total - desconto;
        }
        System.out.println("Produto: " + nome);
        System.out.println("Total: " + total);
        System.out.println("Desconto: " + desconto);
        System.out.println("Total a Pagar: " + tp);

    }

}
