package POOHeranca;

public class Funcionarios extends Pessoas {

    // atributos especificos
    private int Registro;
    private double horario;
    private double salario;
    private String funcao;
    private String estrumentosTrabalho;

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int registro) {
        Registro = registro;
    }

    public double getHorario() {
        return horario;
    }

    public void setHorario(double horario) {
        this.horario = horario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getEstrumentosTrabalho() {
        return estrumentosTrabalho;
    }

    public void setEstrumentosTrabalho(String estrumentosTrabalho) {
        this.estrumentosTrabalho = estrumentosTrabalho;
    }

}
