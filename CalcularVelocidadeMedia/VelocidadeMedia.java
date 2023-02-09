package CalcularVelocidadeMedia;

public class VelocidadeMedia {
    public static void main(String[] args) {
        //obter distancia percorrida pelo usuario
        int distanciaPercorrida = 150;

        /*obter tempo gasto pelo usuario */
        int tempoGasto = 2;

        //calcular veloocidade média
        float VelocidadeMedia = distanciaPercorrida/tempoGasto;
        
        //Mostre a velocidade média
        System.out.print("A velocidade média foi de: ");
        System.out.println(VelocidadeMedia+" km/h");
    }
}
