package ExercicioJava;

/**
 * CustoViagem
 */
public class CustoViagem {
    public static void main(String[] args) {
        //distancia percorrida pelo usuario
        double distanciaPercorrida = 2838;
        //preço da gasolina de 1 litro
        double precoGas = 5;

        //quilometros por litro do carro do usuario  
        double consumoCarro = 10; 
        
        //calcular a quantidade de litros gasto e o custo total da viagem
       double CustoViagem = (distanciaPercorrida / consumoCarro) * precoGas;
        System.out.print("O valor gasto estimado é:: ");
        System.out.println(CustoViagem+" R$");
    }
    }
    
