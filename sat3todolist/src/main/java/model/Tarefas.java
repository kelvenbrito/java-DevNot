package model;

public class Tarefas {
    // atributos
    int idTarefa;
    String descricao;
    boolean condicao;

    // contrutor
    public Tarefas(int idTarefa, String descricao) {
        this.idTarefa = idTarefa;
        this.descricao = descricao;
      
       
    }



    // getters and setters
    
    public int getIdTarefa() {
        return idTarefa;
    }



    public void setIdTarefa(int idTarefa) {
        this.idTarefa = idTarefa;
    }



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
