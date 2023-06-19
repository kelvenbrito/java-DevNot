package POOEx3;

import javax.swing.JOptionPane;

public class Elevador {
    // atributos
    int capacidadeMax;
    int nMaxAndar;
    int andarAtual;
    int capacidadeAtual;

    // métodos - construtor
    public Elevador(int capacidadeMax, int nMaxAndar) {
        this.capacidadeMax = capacidadeMax;
        this.nMaxAndar = nMaxAndar;
        capacidadeAtual = 0;// predefinido
        andarAtual = 0;// predefinido
    }

    // setters and getters
    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }

    public void setCapacidadeAtual(int capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }

    // métodos adicionais
    // entrar
    public int entrar() {
        if (capacidadeAtual < capacidadeMax) {
            capacidadeAtual++;
        } else {
            JOptionPane.showMessageDialog(null,
                    "Capacidade Máxima Atingida \n Não vai subir ninguem");
        }
        return capacidadeAtual;

    }

    // sair
    public int sair() {
        if (capacidadeAtual > 0) {
            capacidadeAtual--;
        } else {
            JOptionPane.showMessageDialog(null,
                    "não tem ninguem para sair");
        }
        return capacidadeAtual;
    }

    // subir
    public int acao(int nAndares) {
        if (nAndares <= nMaxAndar && nAndares >= 0 && nAndares != andarAtual) {
            andarAtual = nAndares;
        } else {
            JOptionPane.showMessageDialog(null, "Digite um Andar Válido");
        }

        return andarAtual;
    }

    // iniciar
    public void iniciar() {
        andarAtual = 0;
        capacidadeAtual = 0;
    }

}
