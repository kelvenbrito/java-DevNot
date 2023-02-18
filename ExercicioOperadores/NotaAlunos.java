package ExercicioOperadores;

import java.util.Scanner;

public class NotaAlunos {
    public void media(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a 1ª nota do aluno ");
        double nota1Aluno = sc.nextDouble();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a 2ª nota do aluno ");
        double nota2Aluno = sc.nextDouble();

        double mediaAluno = (nota1Aluno + nota2Aluno)/2;
        System.out.println("A média é "+mediaAluno);
    }
}

