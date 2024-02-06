package model;

public class Tarefas {
    // atributos
    private String idTarefa;
    String descricao;
    boolean condicao;

    // contrutor
    public Tarefas(String descricao, String string,String idTarefa) {
        this.descricao = descricao;
        this.condicao = false;
        this.idTarefa = idTarefa;
    }

    // getters and setters
    public String getDescricao() {
        return descricao;
    }

    public String getIdTarefa() {
        return idTarefa;
    }

    public void setIdTarefa(String idTarefa) {
        this.idTarefa = idTarefa;
    }

    public Tarefas(String idTarefa) {
     
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
