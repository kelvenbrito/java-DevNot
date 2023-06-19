package POOHeranca;

public class Professores extends Pessoas {
    // atributos especificos
    private int Registro;
    private double horario;
    private double salario;
    private String curso;
    private String turma;

    public int getRegistro() {
        return Registro;
    }

    public void setRegistro(int registro) {
        Registro = registro;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public double getHorario() {
        return horario;
    }

    public void setHorario(double horario){
        this.horario = horario;
    }

}
