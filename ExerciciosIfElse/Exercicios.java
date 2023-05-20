package ExerciciosIfElse;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Exercicios {
    Scanner sc = new Scanner(System.in);
    DecimalFormat formatador = new DecimalFormat("0.00");

    public void Exercicio1() {
        System.out.println("Informe o primeiro valor:");
        int valor1 = sc.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = sc.nextInt();
        if (valor1 == valor2) {
            System.out.println("Os valores são iguais");
        } else if (valor1 > valor2) {
            System.out.println("O maior valor é " + valor1);
        } else {
            System.out.println("O maior valor é " + valor2);
        }
    }

    public void Exercicio2() {
        System.out.println("Informe o ano de seu nascimento");
        int valorData = sc.nextInt();
        int Idade = 2023 - valorData;
        System.out.println("Você tem " + Idade + " Anos ");
        if (Idade >= 18) {
            System.out.println("Voto obrigatório, você deve votar neste ano!");
        }else if(Idade >=16){
            System.out.println("Voto opcional, você pode votar neste ano!");
        } else {
            System.out.println("Você ainda não tem idade para votar neste ano!");
        }
    }

    public void Exercicio3() {
        System.out.println("Informe a sua senha");
        int valorSenha = sc.nextInt();
        if (valorSenha == 1234) {
            System.out.println("ACESSO PERMITIDO");
        } else {
            System.out.println("ACESSO NEGADO");
        }
    }

    public void Exercicio4() {
        Double valorMacas;
        System.out.println("Informe quantas maças você quer comprar");
        Double numMaca = sc.nextDouble();
        if (numMaca>= 12) {
            valorMacas = 0.25;

        } else {
            valorMacas = 0.30;
        }
        double valort = (valorMacas * numMaca);
        
        System.out.println("O valor total da compra é " + formatador.format(valort) + " R$");
    }

    public void Exercicio5() {
        System.out.println("Informe o primeiro valor:");
        int valor1 = sc.nextInt();
        System.out.println("Informe o segundo valor:");
        int valor2 = sc.nextInt();
        System.out.println("Informe o Terceiro valor:");
        int valor3 = sc.nextInt();
        if (valor1 < valor2 && valor2 < valor3) {
            System.out.println(valor1 + "," + valor2 + "," + valor3);

        } else if (valor1 < valor3 && valor2 > valor3) {
            System.out.println(valor1 + "," + valor3 + "," + valor2);

        } else if (valor2 < valor1 && valor1 < valor3) {
            System.out.println(valor2 + "," + valor1 + "," + valor3);

        } else if (valor2 < valor3 && valor1 > valor3) {
            System.out.println(valor2 + "," + valor3 + "," + valor1);

        } else if (valor3 < valor1 && valor1 < valor2) {

            System.out.println(valor3 + "," + valor1 + "," + valor2);

        } else if (valor3 < valor2 && valor1 > valor2) {

            System.out.println(valor3 + "," + valor2 + "," + valor1);

        }else {
            System.out.println("Os três numeros devem ter valores diferentes!, operação invalida!");
        }

    }

    public void Exercicio6() {
        System.out.println("Digite o numero 1 se vc for do sexo feminino ou numero 2 se for masculino");
        int valorSex = sc.nextInt();
        System.out.println("Informe a sua altura:");
        Double valorAlt = sc.nextDouble();
        double pesoId = 0;
        if (valorSex == 1) {
            pesoId = (62.1 * valorAlt) - 44.7;

        } else if (valorSex == 2) {
            pesoId = (72.7 * valorAlt) - 58.0;
        } else {
            System.out.println("Valor invalido");
        }
        
        System.out.println("Seu peso ideal é: " +formatador.format(pesoId) + "Kg");
    }

    public void Exercicio7() {
        System.out.println("Digite a 1ª nota do aluno ");
        double nota1Aluno = sc.nextDouble();

        System.out.println("Digite a 2ª nota do aluno ");
        double nota2Aluno = sc.nextDouble();

        System.out.println("Informe a porcentagem de frequencia do Aluno");
        int frequenciaAluno = sc.nextInt();

        double mediaAluno = (nota1Aluno + nota2Aluno) / 2;
        System.out.println("A média do aluno é " + mediaAluno);

        if ((mediaAluno >= 5) && (frequenciaAluno >= 75)) {
            System.out.println("Media:Aprovado\nFrequecia:Aprovado\nO aluno foi aprovado no curso!");

        } else if ((mediaAluno >= 5) && (frequenciaAluno < 75)) {
            System.out.println("Media:Aprovado\nFrequecia:Reprovado\nO aluno foi Reprovado no curso!");

        } else if ((mediaAluno < 5) && (frequenciaAluno >= 75)) {
            System.out.println("Media:Reprovado\nFrequecia:Aprovado\nO aluno  foi Reprovado no curso!");
        } else {
            System.out.println("Media:Reprovado\nFrequecia:Reprovado\nO aluno foi Reprovado no curso!");
        }

    }

    public void Exercicio8() {
        System.out.println("Informe o numero:");
        Double valorNum = sc.nextDouble();
        Double valorPI = valorNum % 2;
        if (valorPI == 0) {
            System.out.println("O número é par!!");
        } else {
            System.out.println("O numero é impar!!");
        }
    }

    public void Exercicio9() {
        System.out.println("Digite a 1ª nota do aluno ");
        double nota1Aluno = sc.nextDouble();

        System.out.println("Digite a 2ª nota do aluno ");
        double nota2Aluno = sc.nextDouble();

        double mediaAluno = (nota1Aluno + nota2Aluno) / 2;
        System.out.println("A média do aluno é " + mediaAluno);
        if (mediaAluno >= 7) {
            System.out.println("O aluno esta aprovado!!");
        } else if ((mediaAluno >= 5) && (mediaAluno < 7)) {
            System.out.println("O aluno tem direito de fazer uma prova de recuperação");
        } else {
            System.out.println("O aluno esta rerovado!!");
        }
    }

    public void Exercicio10() {
        System.out.println("Informe uma letra");
        String letra = sc.nextLine();

        if (letra.equals("a") || letra.equals("A") 
                || letra.equals("e") || letra.equals("E")
                || letra.equals("i") || letra.equals("I") 
                || letra.equals("o") || letra.equals("O")
                || letra.equals("u") || letra.equals("U")) {
            System.out.println(letra + " É uma Vogal");
        } else {
            System.out.println(letra + " É uma Consoante");
        }
    }

    public void Exercicio11() {
        System.out.println("Informe seu salário");
        double valorSalar = sc.nextDouble();
        double porcent = 0;
        double valorAum = 0;
        double novoSalar = 0;
        if (valorSalar >= 2500) {
            porcent = 5;

        } else if ((valorSalar < 2500) && (valorSalar >= 1700)) {
            porcent = 10;

        } else if ((valorSalar < 1700) && (valorSalar > 1280)) {
            porcent = 15;
        } else {
            porcent = 20;
        }

        valorAum = (valorSalar * porcent) / 100;
        novoSalar = valorSalar + valorAum;

        System.out.println(" Salário antes do reajuste: R$" + valorSalar + "\n Porcentual de aumento aplicado: "
                + porcent + " %" + "\n Valor de aumento: R$" + valorAum + "\n Novo salário: R$" + novoSalar);

    }

    public void Exercicio12() {
        System.out.println("Informe as quantidades de horas trabalhadas no mês.");
        double quantHora = sc.nextDouble();
        System.out.println("Informe o valor da hora trabalhada.");
        double valorHora = sc.nextDouble();
        double salarBruto = quantHora * valorHora;
        double porcIR = 0;

        if (salarBruto > 2500) {
            porcIR = 20;

        } else if ((salarBruto <= 2500) && (salarBruto > 1500)) {
            porcIR = 10;

        } else if ((salarBruto <= 1500) && (salarBruto > 900)) {
            porcIR = 5;
        } else {
            System.out.println("\n IR: Isento");
        }

        double descontoIR = (salarBruto * porcIR) / 100;
        double descSind = (salarBruto * 3) / 100;
        double descFGTS = (salarBruto * 11) / 100;
        double descINSS = (salarBruto * 10) / 100;
        double totalDesc = descontoIR + descSind + descINSS;
        double salarLiq = salarBruto - totalDesc;

        System.out.println("Salário bruto: " + valorHora + " * " + quantHora + ": R$" + salarBruto + "\n (-) IR ("
                + porcIR + "%): " + " R$" + descontoIR
                + "\n (-) INSS (10%): R$" + descINSS + "\n (-) Desconto Sindicato (3%): R$" + descSind
                + "\n     FGTS (11%): R$" + descFGTS
                + "\n     Total de descontos: R$" + totalDesc + "\n     Salário Líquido:   R$" + salarLiq);
    }
}