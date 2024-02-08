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
