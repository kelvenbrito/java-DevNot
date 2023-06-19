package PooEx2;

public class agenda {
     //atributos
    String nome;
    int idade;
    double altura;


    //metodos
    //construtor(Atributos)//construtor metodo que tem o mesmo nome da clase
    public agenda(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }
    
    //construtor default(vazio)
    public agenda(){

    }
     //getters and setters
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }

       //métodos Imprimir e Buscar pessoas

       public void imprimeAgenda() {
        System.out.println("Nome: "+nome);
        System.out.println("Altura: "+altura);
        System.out.println("Idade: "+idade);
    }
    public void imprimirInfo() {
    }
}
