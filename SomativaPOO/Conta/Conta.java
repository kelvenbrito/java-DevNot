package SomativaPOO.Conta;

import javax.swing.JOptionPane;

public abstract class Conta {
    // atributos
    String nome;
    String senha;
    int nConta;
    double saldo;
    double valorTranf;
    
  // set get
    public double getValorTranf() {
        return valorTranf;
    }

    public void setValorTranf(double valorTranf) {
        this.valorTranf = valorTranf;
    }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnConta() {
        return nConta;
    }

    public void setnConta(int nConta) {
        this.nConta = nConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    // método vazio
    public void Saque() {
        int saque = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade que você deseja adiquirir"));
        if (saldo >= saque) {
            saldo = saldo - saque;
        } else {
            JOptionPane.showMessageDialog(null, "Errro! \nSaldo insuficiente! ");
        }
    }

    public void Deposito() {
        int deposito = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade que você deseja depositar"));
        if (deposito > 0) {
            saldo += deposito;
        } else {
            JOptionPane.showMessageDialog(null, "Errro! \nValor do deposito Insuficiente! ");
        }
    }

    public void Emprestimo() {
        int emprestimo = Integer
                .parseInt(JOptionPane.showInputDialog("Informe a quantidade que você deseja de Emprestimo"));
        if (emprestimo > 0 && emprestimo < (saldo * 5)) {
            JOptionPane.showMessageDialog(null, "Empréstimo Aceito!");
            saldo += emprestimo;

        } else {
            JOptionPane.showMessageDialog(null, "Empréstimo Negado!");
        }
    }

    public void enviarTrnsf() {

        this.saldo -= this.valorTranf;
    }

    public void receberTrnsf() {

        this.saldo += this.valorTranf;
    }

    

}