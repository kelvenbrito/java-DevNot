package Model;

public class Produtos {
    //=============Atributos=============
    private String codigoBarra;
    private String nome;
    private double preco;
     private int quantidade;

    //=============Construtor=============
      public Produtos(String codigoBarra, String nome,  double preco, int quantidade) {
        this.codigoBarra = codigoBarra;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    //=============Get and Set=============
      public String getCodigoBarra() {
        return codigoBarra;
    }
    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
