package Model;

public class Clientes {
    //=============Atributos=============
    private String nome;
    private String cpf;
    //=============Construtor=============
    public Clientes(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    //=============Get and Set=============
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
