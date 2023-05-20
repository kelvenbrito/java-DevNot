package SAG;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SAG {
    Scanner sc = new Scanner(System.in);
    DecimalFormat ft = new DecimalFormat("0.00");

    public void cjd() {
        String nome, sexo;
        double  alt, peso, pesoNesc,pesoIdeal,imc =0;
        int idade;

        System.out.println("Digite seu nome! ");
        nome = sc.nextLine();

        System.out.println("Digite sua idade! ");
        idade = sc.nextInt();

        System.out.println("Digite seu sexo! ");
        System.out.println("Digite (F) para feminino ou (M) para Masculino ");
        sexo = sc.next();

        System.out.println("Digite sua Altura(m) ");
        alt = sc.nextDouble();

        System.out.println("Digite seu peso (KG)");
        peso = sc.nextDouble();

        System.out.println("Nome: " +nome);
        System.out.println("Idade: "+idade);

        if (sexo.toUpperCase().charAt(0) == 'F') {// Feminino
            pesoIdeal = 62.1 * alt - 44.7;
            System.out.println("Seu peso idel é " +ft.format(pesoIdeal) + " Kg");
            pesoNesc = peso - pesoIdeal;

            if (pesoNesc > 0) {
                System.out.println("Você precisa perder " +ft.format(pesoNesc) +" Kg");

            } else{
                pesoNesc *= -1;
                System.out.println("Você precisa ganhar " +ft.format(pesoNesc) +"Kg");
            }
        } else if (sexo.toUpperCase().charAt(0) == 'M') { // Masculino
            pesoIdeal = 72.7 * alt - 58;
            System.out.println("Seu peso idel é " +ft.format(pesoIdeal) + " Kg");
            pesoNesc = peso - pesoIdeal;
            if (pesoNesc > 0) {
                System.out.println("Você precisa perder " +ft.format(pesoNesc) +"Kg");

            } else {
                pesoNesc *= -1;
                System.out.println("Você precisa ganhar " +ft.format(pesoNesc) +"kg");
            }

        } else {
            System.out.println("Letra Invalida!");
            return;
        }

        imc = peso / (alt * alt);

        System.out.println("seu Imc: " +ft.format(imc));

        if(imc < 20){
            System.out.println("Abaixo do Peso");
            System.out.println("Atividade Difícil - Precisa Ganhar Massa Muscular");
            if(idade >= 16 && idade <= 25){
                System.out.println("Faixa Etária - I");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Luta");
            }else if(idade > 25 && idade <= 35){
                System.out.println("Faixa Etária - II");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Intensa e Luta");
            }else if(idade > 35 && idade <= 45){
                System.out.println("Faixa Etária - III");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Intensa e Luta");
            }else if(idade > 45 && idade <= 55){
                System.out.println("Faixa Etária - IV");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Luta e Pilates");
            }else if(idade > 55 && idade <= 65){
                System.out.println("Faixa Etária - V");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Pilates");
            }else if(idade > 65){
                System.out.println("Faixa Etária - VI");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Pilates");
            }else{
                System.out.println(nome +":" +idade +" anos: é muito novo é muito novo para praticar exercicios");
            }
        }else if(imc >= 20 && imc <=27){
            System.out.println( "Peso Normal");
            System.out.println("Atividade Moderada -");
            if(idade >= 16 && idade <= 25){
                System.out.println("Faixa Etária - I");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Moderada e Dança");
            }else if(idade > 25 && idade <= 35){
                System.out.println("Faixa Etária - II");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Moderada, Dança e Corrida");
            }else if(idade > 35 && idade <= 45){
                System.out.println("Faixa Etária - III");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Moderada, Dança e Corrida");
            }else if(idade > 45 && idade <= 55){
                System.out.println("Faixa Etária - IV");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Moderada, Dança e Corrida");
            }else if(idade > 55 && idade <= 65){
                System.out.println("Faixa Etária - V");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Dança e Corrida");
            }else if(idade > 65){
                System.out.println("Faixa Etária - VI");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Dança");
            }else{
                System.out.println(nome +":" +idade +" anos: é muito novo é muito novo para praticar exercicios");
            }
        }else{
            System.out.println("Perder Peso");
            System.out.println("Atividade Leve");
            if(idade >= 16 && idade <= 25){
                System.out.println("Faixa Etária - I");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Leve e Ioga");
            }else if(idade > 25 && idade <= 35){
                System.out.println("Faixa Etária - II");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Ioga");
            }else if(idade > 35 && idade <= 45){
                System.out.println("Faixa Etária - III");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Ioga");
            }else if(idade > 45 && idade <= 55){
                System.out.println("Faixa Etária - IV");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Leve e Ioga");
            }else if(idade > 55 && idade <= 65){
                System.out.println("Faixa Etária - V");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Leve e Ioga");
            }else if(idade > 65){
                System.out.println("Faixa Etária - VI");
                System.out.println("Recomendado para: " +idade +" anos:");
                System.out.println("Musculação Leve e Ioga");
            }else{
                System.out.println(nome +":" +idade +" anos: é muito novo para praticar exercicios");
            }
        }
        

        }

    }


