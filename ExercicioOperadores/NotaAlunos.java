package ExercicioOperadores;

import java.util.Scanner;

public class NotaAlunos {
    public void notaFrequencia(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a 1ª nota do aluno ");
        double nota1Aluno = sc.nextDouble();
        Scanner sd = new Scanner(System.in);
        System.out.println("Digite a 2ª nota do aluno ");
        double nota2Aluno = sc.nextDouble();

        double mediaAluno = (nota1Aluno + nota2Aluno)/2;
        System.out.println("A média do aluno é "+mediaAluno);

        boolean mediaAprovado = mediaAluno >= 5;
        
        System.out.println("O aluno está aprovado por nota:" +mediaAprovado);
        System.out.println("Informe a frequencia do Aluno");
        int frequenciaAluno = sc.nextInt();
        boolean frequenciaAprovada = frequenciaAluno >= 75;
        System.out.println("O aluno esta aprovado por frequencia? "+frequenciaAprovada);
        boolean aprocacaoFinal = ((mediaAprovado == true) && (frequenciaAprovada==true));
        System.out.println("O aluno está aprovado no curso? "+aprocacaoFinal);
    }
}

