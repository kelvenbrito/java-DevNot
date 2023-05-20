package EstruturaDecisaoIf;

import java.util.Scanner;

public class DecisaoIf {
    Scanner sc = new Scanner(System.in);

    // decisão if desencadeada
    public void calcularDescontoIf() {
        System.out.println("Informe o valor do produto ");
        double precoProduto = sc.nextDouble();
        // boolean produtoAltoValor = precoProduto >= 100;
        double percentualDesconto = 0.0;
        if (precoProduto >= 100 && precoProduto < 200) { // Estrutura de desisão if
            // Desconto para produtos de alto valor.
            percentualDesconto = 5.0;
        }

        if (precoProduto >= 200 && precoProduto < 300) {
            percentualDesconto = 10.0;
        }

        if (precoProduto >= 300) {
            percentualDesconto = 15.0;
        }
        // Regra de três
        double desconto = (precoProduto * percentualDesconto) / 100;
        double precoComDesconto = precoProduto - desconto;
        System.out.println("O produto sairá por R$" + precoComDesconto + ".");

    }

    // decisão if encadeada
    public void DecisaoIfElse() {
        System.out.println("Informe o valor do produto: ");
        double precoProduto = sc.nextDouble();
        double percentualDesconto;
        // Estrutura da Decisão Encadeada
        if (precoProduto >= 300) {
            percentualDesconto = 15.0;
        } else if(precoProduto>=200){
            percentualDesconto = 10.0;
        }else if(precoProduto>=100){
            percentualDesconto = 5.0;
        }
        else {
            percentualDesconto = 0.0;
        }

        // Regra de três
        double desconto = (precoProduto * percentualDesconto) / 100;
        double precoComDesconto = precoProduto - desconto;
        System.out.println("O produto sairá por R$" + precoComDesconto + ".");
    }
}
