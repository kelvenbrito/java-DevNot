package ExemploFor;

import java.util.Scanner;

public class ExempFor {
    Scanner sc = new Scanner(System.in);

    public void Exemplo1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("O nº da interação é " + i);
        }
    }

    public void Exemplo2() {
        int vetor[] = new int[10];// criando um vetor 10 posiçoes
        // preenchendo o vetor for

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Vetor [" + i + "]=");
            vetor[i] = sc.nextInt();
        }
        // imprimir o vetor na ordem inversa
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.println("\nVetor [" + i + "]=" + vetor[i]);
        }
    }

    public void Exemplo3() {
        // carrinho de compra
        double[] carrinhoCompra = new double[] { 19.90, 35.70, 57.80, 70.90, 90.50 };
        double valorFinal = 0;
        for (int i = 0; i < carrinhoCompra.length; i++) {
            valorFinal += carrinhoCompra[i];

            System.out.println("Valor parcial da compra é R$" + valorFinal);

        }

        // mostrar o valor final da compra

        System.out.println("O valor da compra e R$" + valorFinal);
    }

    public void Exemplo4() {
        // ler 4 notas e mostrar as 4 notas e a média
        double vetorNotas[] = new double[4];
        double mediaNotas = 0;
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Digite a Nota " + (i + 1) + ":");
            vetorNotas[i] = sc.nextDouble();
        }
        // Imprimir as 4 notas e calcular a média

        for (int i = 0; i < vetorNotas.length; i++) {
            mediaNotas += vetorNotas[i];
            System.out.println("A " + (i + 1) + "º Nota é " + vetorNotas[i]);
        }
        // Imprimir a média
        mediaNotas /= vetorNotas.length;
        System.out.printf("A média do Aluno é %.2f", mediaNotas);

    }

    public void Exemoplo5() {
        // Ler quantro notas de 10 alunos

        // vetor guardar as médias
        double vetorMedia[] = new double[3];
        // vetor guardar os nomes
        String[] nome = new String[3];// nomeApro = new String[nome.length];
        // preencher o vetor de médias

        for (int i = 0; i < vetorMedia.length; i++) {
            int notas = 0;
            System.out.print("Digite o nome do aluno:");
            nome[i] = sc.next();
            for (int j = 0; j < 4; j++) {
                System.out.print("Nota " + (j + 1) + " Aluno " + (i + 1) + ":");
                notas += sc.nextDouble();
            }
            notas /= 4;
            vetorMedia[i] = notas;
            System.out.println("--------------------------");
        }
        // Imprimir notas maior ou igual 7 no vetor médias
        for (int i = 0; i < vetorMedia.length; i++) {
            if (vetorMedia[i] >= 7) {
                System.out.println("Aluno Aprovado:");
                System.out.println("Nome " + nome[i] + " média: " + vetorMedia[i]);
            }
        }

    }
    public void Exercicio3() {
    
        //Criar vetor para receber as notas
        double vetorNotas[] = new double[4];//vetor de 4 posiçôes
        
        //preencher o vetor de notas
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Informe a nota "+(i+1)+" do aluno:");
            vetorNotas[i] = sc.nextDouble();
        }
        //Mostrar as notas e calcular a média
        double media = 0;
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Nota "+(i+1)+"="+vetorNotas[i]);
            media += vetorNotas[i];

        }
        //Dividir a média pelo numeros de notas
        media /= vetorNotas.length;
        //Imprimir a média
        System.out.println("A média do Aluno é "+media);
    }

    public void Exercicio7() {
        int[] num = new int[5];
        int multp = 1, soma = 0;

        for (int i = 0; i < num.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor:");
            num[i] = sc.nextInt();
            soma += num[i];
            multp *= num[i];

        }
        System.out.println("Números: ");
        for (int s : num) {
            System.out.print(s + ",");
        }

        System.out.println("\nSoma dos numeros: " + soma);
        System.out.println("Multiplicação dos numeros: " + multp);
    }

    public void Exercicio8() {
        String[] nome = new String[3];
        double[] alt = new double[nome.length];
        int[] idade = new int[nome.length];

        for (int i = 0; i < nome.length; i++) {
            System.out.println((i + 1) + "º Pessoa");
            System.out.println("Digite o nome: ");
            nome[i] = sc.next();
            System.out.println("Digite a idade: ");
            idade[i] = sc.nextInt();
            System.out.println("Digite a altura: ");
            alt[i] = sc.nextDouble();

        }

        for (int i = nome.length - 1; i >= 0; i--) {
            System.out.println("--------------------");
            System.out.println("Nome: " + nome[i]);
            System.out.println("Idade: " + idade[i]);
            System.out.println("Altura: " + alt[i]);

        }

    }

    public void Exercicio9() {
        int[] num = new int[10], eleQuat = new int[num.length];
        int soma = 0;

        for (int i = 0; i < num.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º numero:");
            num[i] = sc.nextInt();
            eleQuat[i] = num[i] * num[i];
            soma += eleQuat[i];

        }
        for (int i = 0; i < eleQuat.length; i++) {

            System.out.println(num[i] + " Elevado ao quadrado: " + eleQuat[i]);
            
        }
        System.out.println("Soma dos números elevado ao quadrado: " + soma);

    }

    public void Exercicio5() {
        int[] numInter = new int[20], numPar = new int[numInter.length], numImpar = new int[numInter.length];
        int im = 0, p = 0, i;
       
        for (i = 0; i < numInter.length; i++) {
            System.out.println("Digite o " + (i + 1) + "º valor");
            numInter[i] = sc.nextInt();

           
            if (numInter[i] % 2 == 0) {
                numPar[p] = numInter[i];
                p++;
            } else {
                numImpar[im] = numInter[i];
                im++;
            }

        }

        System.out.println("\nNumeros!");
        for (i = 0; i < numInter.length; i++) {
            System.out.print(numInter[i] + ",");
        }
        System.out.println("\nNumeros Pares");
        for (i = 0; i < p; i++) {
            System.out.print(numPar[i] + ",");
        }
        System.out.println("\nNumeros Impares");
        for (i = 0; i < im; i++) {

            System.out.print(numImpar[i] + ",");

        }
    }

    public void Exercicio4() {
        String[] caracter = new String[10], caract1 = new String[caracter.length],
                caract2 = new String[caracter.length];
        int p = 0,  c = 0, i;

        for (i = 0; i < caracter.length; i++) {

            System.out.println("Digite a " + (i+1) + "º caracter ");
            caracter[i] = sc.nextLine();

            if (

            caracter[i].toLowerCase().equals("a")
                    || caracter[i].toLowerCase().equals("e")
                    || caracter[i].toLowerCase().equals("i")
                    || caracter[i].toLowerCase().equals("o")
                    || caracter[i].toLowerCase().equals("u")) {

                caract2[p] = caracter[i];
                p++;

            } else {
                caract1[c] = caracter[i];
                c++;
            }
            
        }

        System.out.println("As vogais são:");
        for (i = 0; i < p; i++) {
            System.out.print(caract2[i] + ",");
        }

        System.out.println("\nAs consoantes são:");
        for (i = 0; i < c; i++) {
            System.out.print(caract1[i] + ",");
        }

        System.out.println("\nNumero total de vogais: " + p);
        System.out.println("Numero total de consoantes: " + c);
    }

    //contando uma consoante de uma palavra

    public void Exercicio4b() {
        String palav;
        int  contConsoante = 0;
        ;

        System.out.println("Digite uma palavra: ");
        palav = sc.next();
        palav = palav.toLowerCase();
        //Ler a palavara letra  por letra e verificar se é consoante e "contar"
     

        for (int i = 0; i < palav.length(); i++) {
                char s = palav.charAt(i);
            if ((s == 'a') || (s =='e')|| (s == 'i') 
            || (s == 'o') || (s == 'u')) {

                System.out.println(s+" é vogal");
              

            }   else{
                System.out.println(s+" é consoante");
                contConsoante++;
            }
        
        System.out.println("O numero de consoantes é "+contConsoante);

        }
    }

    public void Exemplo6(){
        String letras[] = new String[]{"a", "b", "c", "d", "e", "f","g","h","i","j"};
        //ler o vetor letra por letra e verificar se é consoante e "contar"
        int contConsoante = 0;
        for (int i = 0; i < letras.length; i++) {
            if((letras[i]=="a")||(letras[i]=="e")||(letras[i]=="i")||(letras[i]=="o")||(letras[i]=="u")){
                System.out.println(letras[i]+" é vogal");
            }else{
                System.out.println(letras[i]+" é consoante");
                contConsoante++;
            }
        }
        System.out.println("O numero de consoantes é "+contConsoante);

    }

    public void Exemplo7(){
        //Ler um vetor de 20 numeros e determinar Impares e Pares
        //quardar dentro de outros vetores

        int numeros[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int contPar=0, contImpar=0;
        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i]%2==0){
                contPar++;
            }else{
                contImpar++;
            }
        }

        //Criar os vetores Par e Impar

        int nPar[] = new int[contPar];
        int nImpar[] = new int[contImpar];

        //Preencher os vetores par e impar
        contPar = 0;
        contImpar = 0;

        for (int i = 0; i < numeros.length; i++) {
            if(numeros[i]%2==0){
                nPar[contPar]=numeros[i];
                contPar++;//Atribui elementos do vetor numeros
                //a posição diferente do vetor nPar
            }else{
                nImpar[contImpar]=numeros[i];
            
                contImpar++;
            }
            
        }
        //Imprimir vetor de números
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("vetorNumeros["+i+"]="+numeros[i]);
        }
         //Imprimir vetor de Pares
         for (int i = 0; i < numeros.length; i++) {
            System.out.println("vetorPar["+i+"]="+nPar[i]);
        }

           //Imprimir vetor de Impares
           for (int i = 0; i < numeros.length; i++) {
            System.out.println("vetorImpar["+i+"]="+nImpar[i]);
        }
    }

} 