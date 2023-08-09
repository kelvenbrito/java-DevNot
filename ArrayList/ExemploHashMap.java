package ArrayList;

import java.util.HashMap;

public class ExemploHashMap {
    // criar um HashMap Cidades
    public static void main(String[] args) {
        HashMap<String, String> capitaisCidades = new HashMap<>();
        capitaisCidades.put("SP", "São Paulo");
        capitaisCidades.put("RJ", "Rio de Janeiro");
        capitaisCidades.put("MG", "BeloHorizonte");
        capitaisCidades.put("ES", "Vitória");
        // Imprime valor correspondente a chave
        System.out.println(capitaisCidades.get("ES"));
        // Imprime chave e valor
        System.out.println(capitaisCidades);
        // Imprime somente chave
        System.out.println(capitaisCidades.keySet());
        // imprimir somente valores
        for (String i : capitaisCidades.keySet()) {
            System.out.println(capitaisCidades.get(i));
        }
System.out.println("-------------------------------------");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
        HashMap<String, Integer> pessoas = new HashMap<>();
        pessoas.put("Maria", 67);
        pessoas.put("João", 37);
        pessoas.put("Marcos", 27);
         // Imprime valor correspondente a chave
        System.out.println(pessoas.get("Marcos"));
        // Imprime chave e valor
        System.out.println(pessoas);
        // Imprime somente chave
        System.out.println(pessoas.keySet());
        // imprimir somente valores
        for (String i : pessoas.keySet()) {
            System.out.println(pessoas.get(i));
        }

    }
}
