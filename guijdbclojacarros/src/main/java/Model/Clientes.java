package Model;

public class Clientes {
     // atributos
     private String nome;
     private String endereco;
     private String telefone;
     private String cpf;

     // contrutor
    public Clientes(String nome, String endereco, String telefone, String cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

       // getters and setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Object getMarca() {
        return null;
    }

    public Object getModelo() {
        return null;
    }

    public Object getAno() {
        return null;
    }

    public Object getPlaca() {
        return null;
    }

   

     
   
}
