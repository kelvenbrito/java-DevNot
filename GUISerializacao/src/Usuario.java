import java.io.Serializable;

public class Usuario implements Serializable {
    //atributos
    String nome;
    String data;
    String hora;
    String descrição;
    int idade;
    //métodos
    public Usuario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }



    public Usuario(String data, String hora,String nome, String descricao) {
        this.data = data;
        this.hora = hora;
        this.descrição = descrição;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public String getDescrição() {
        return descrição;
    }



    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }



    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
  
   
    
}
