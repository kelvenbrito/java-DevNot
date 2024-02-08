package model;

public class Tarefas {
    // atributos
  
    String descricao;
    boolean condicao;

    // contrutor
    public Tarefas(String descricao) {
        this.descricao = descricao;
        this.condicao = false;
       
    }

 

    public Tarefas(String string, String string2) {
        //TODO Auto-generated constructor stub
    }



    // getters and setters
    public String getDescricao() {
        return descricao;
    }




    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean iscondicao() {
        return condicao;
    }

    public void setcondicao(boolean condicao) {
        this.condicao = condicao;
    }

}
