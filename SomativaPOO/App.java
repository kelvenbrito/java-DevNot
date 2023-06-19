package SomativaPOO;

import javax.swing.JOptionPane;

import SomativaPOO.Conta.ContaPF;
import SomativaPOO.Conta.ContaPJ;

public class App {
    public static void main(String[] args) {

        // criar os vetores de objetos
        ContaPF contasPf[] = new ContaPF[10];
        ContaPJ contasPj[] = new ContaPJ[10];
        // criar a aplicação do banco

        boolean op = true;
        int contPF = 0;
        int contPJ = 0;
        int contaAtual = 0;

        while (op) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Escolha a ção desejada:"
                            + "\n 1-Abrir Conta"
                            + "\n 2-Acessar Conta"
                            + "\n 3-Sair"));

            if (acao == 1) {// abrir conta
                // criar a conta
                
                int opConta = Integer.parseInt(JOptionPane.showInputDialog(
                        "Escolha a Tipo da conta:"
                                + "\n 1. Conta Fisica"
                                + "\n 2. Conta Juritica"
                                + "\n 3. cancelar a operação"));

                if (opConta == 1) {
                    // instanciar o objeto
                    contasPf[contPF] = new ContaPF();// objeto criado
                    // preencher as informações da conta PJ
                    contasPf[contPF].setNome(JOptionPane.showInputDialog("Informe o Nome:"));
                    contasPf[contPF].setnCpf(JOptionPane.showInputDialog("Informe o CPF:"));
                    contasPf[contPF].setSenha(JOptionPane.showInputDialog("Informe a senha:"));
                    contasPf[contPF].setSaldo(10);
                    contasPf[contPF].setnConta(1000 + contPF);
                    JOptionPane.showMessageDialog(null,
                            "Nome:" + contasPf[contPF].getNome() + "\nCPF:" + contasPf[contPF].getnCpf()
                                    + "\nNumero da conta:" + contasPf[contPF].getnConta() + "\nSenha:"
                                    + contasPf[contPF].getSenha() + "\nSaldo:"
                                    + contasPf[contPF].getSaldo());

                    contPF++;
                } else if (opConta == 2) {
                    // instanciar o objeto
                    contasPj[contPJ] = new ContaPJ();// objeto criado
                    // preencher as informações da conta PJ
                    contasPj[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empressa:"));
                    contasPj[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe CNPJ"));
                    contasPj[contPJ].setSenha(JOptionPane.showInputDialog("Informe a Senha:"));
                    contasPj[contPJ].setSaldo(1000);
                    contasPj[contPJ].setnConta(2000 + contPJ);

                    JOptionPane.showMessageDialog(null,
                            "Nome:" + contasPj[contPJ].getNome() + "\nCNPJ:" + contasPj[contPJ].getnCnpj()
                                    + "\nNumero da conta:" + contasPj[contPJ].getnConta() + "\nSenha:"
                                    + contasPj[contPJ].getSenha() + "\nSaldo:"
                                    + contasPj[contPJ].getSaldo());

                    contPJ++;
                } else if (opConta == 3) {
                    JOptionPane.showMessageDialog(null, "Operação Invalida!");

                }
            } else if (acao == 2) {// buscar a conta já criada da PF
                // if else
                // buscar conta pf e pj separdamente
                boolean tpc = true;
                while (tpc) {
                    int tipoC = Integer.parseInt(JOptionPane.showInputDialog(
                            "Informe o tipo de conta:"
                                    + "\n 1-Conta de Pessoa Fisica"
                                    + "\n 2-Conta de Pessoa juritica"
                                    + "\n 3-Sair"));
                    if (tipoC == 1) {
                        int nContaBusca = Integer
                                .parseInt(JOptionPane.showInputDialog("Informe o nº da conta buscada:"));
                        for (int i = 0; i < contasPf.length; i++) {
                            // busca pelo nº da conta

                            if (nContaBusca == contasPf[i].getnConta()) {

                                JOptionPane.showMessageDialog(null, "Conta Encontrada ");
                                boolean acessar = false;
                                String nsenha = JOptionPane.showInputDialog("Informe a senha:");

                                if (contasPf[i].getSenha().equals(nsenha)) {
                                    JOptionPane.showMessageDialog(null, "Senha valida");
                                    acessar = true;
                                    contaAtual = i;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha invalida");
                                }

                                while (acessar) {
                                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Ação desejada:"
                                            + "\n 1- verificar saldo"
                                            + "\n 2-Saque"
                                            + "\n 3-Deposito"
                                            + "\n 4-Empréstimo"
                                            + "\n 5-Transferencia"
                                            + "\n 6-Encerrar operação!"));
                                    if (acao2 == 1) {
                                        JOptionPane.showMessageDialog(null, "Saldo:" + contasPf[contaAtual].getSaldo());

                                    } else if (acao2 == 2) {
                                        contasPf[contaAtual].Saque();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado:" + contasPf[contaAtual].getSaldo());
                                    } else if (acao2 == 3) {
                                        contasPf[contaAtual].Deposito();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado::" + contasPf[contaAtual].getSaldo());
                                    } else if (acao2 == 4) {
                                        contasPf[contaAtual].Emprestimo();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado::" + contasPf[contaAtual].getSaldo());
                                    } else if (acao2 == 5) {
                                        int j = 0;
                                        boolean opTrans = true;

                                        int nTrans = Integer.parseInt(JOptionPane
                                                .showInputDialog(
                                                        "Informe a N. da Conta para quem  você deseja Enviar!"));
                                        while (opTrans) {

                                            if (contasPf[j].getnConta() == nTrans) {
                                                JOptionPane.showMessageDialog(null, "Nome:" + contasPf[j].getNome() +
                                                        "\nNº da Conta:" + contasPf[j].getnConta() + "\nCPF:"
                                                        + contasPf[j].getnCpf());
                                                contasPf[contaAtual].setValorTranf(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("Informe o valor:")));
                                                contasPf[contaAtual].enviarTrnsf();
                                                contasPf[j].receberTrnsf();

                                                JOptionPane.showMessageDialog(null,
                                                        "Nome:" + contasPf[contaAtual].getnConta() +
                                                                "\nSaldo Atualizado::"
                                                                + contasPf[contaAtual].getSaldo());

                                                opTrans = false;

                                            }
                                            j++;
                                        }

                                    } else if (acao2 == 6) {
                                         JOptionPane.showMessageDialog(null, "Operação encerrada!");
                                        acessar = false;
                                        tpc = true;
                                    }

                                    else {
                                        JOptionPane.showMessageDialog(null, "Ação invalida tente novamente!");
                                    }

                                }
                            }
                        }
                    } else if (tipoC == 2) {
                        int nContaBusca = Integer
                                .parseInt(JOptionPane.showInputDialog("Informe o nº da conta buscada:"));
                        for (int i = 0; i < contasPj.length; i++) {
                            if (nContaBusca == contasPj[i].getnConta()) {
                                JOptionPane.showMessageDialog(null, "Conta Encontrada ");
                                boolean acessar = false;
                                String nsenha = JOptionPane.showInputDialog("Informe a senha:");
                                if (contasPj[i].getSenha().equals(nsenha)) {
                                    JOptionPane.showMessageDialog(null, "Senha valida");
                                    acessar = true;
                                    contaAtual = i;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Senha Invalida");
                                }
                                while (acessar) {
                                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Ação desejada:"
                                            + "\n 1- verificar saldo"
                                            + "\n 2-Saque"
                                            + "\n 3-Deposito"
                                            + "\n 4-Empréstimo"
                                            + "\n 5-Transferencia"
                                            + "\n 6-Encerrar operação!"));
                                    if (acao2 == 1) {
                                        JOptionPane.showMessageDialog(null, "Saldo:" + contasPj[contaAtual].getSaldo());

                                    } else if (acao2 == 2) {
                                        contasPj[contaAtual].Saque();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado:" + contasPj[contaAtual].getSaldo());
                                    } else if (acao2 == 3) {
                                        contasPj[contaAtual].Deposito();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado::" + contasPj[contaAtual].getSaldo());
                                    } else if (acao2 == 4) {
                                        contasPj[contaAtual].Emprestimo();
                                        JOptionPane.showMessageDialog(null,
                                                "Saldo Atualizado::" + contasPj[contaAtual].getSaldo());
                                    } else if (acao2 == 5) {
                                        int j = 0;
                                        boolean opTrans = true;

                                        int nTrans = Integer.parseInt(JOptionPane
                                                .showInputDialog(
                                                        "Informe a N. da Conta para quem  você deseja Enviar!"));
                                        while (opTrans) {

                                            if (contasPj[j].getnConta() == nTrans) {
                                                JOptionPane.showMessageDialog(null, "Nome:" + contasPj[j].getNome() +
                                                        "\nNº da Conta:" + contasPj[j].getnConta() + "\nCNPJ:"
                                                        + contasPj[j].getnCnpj());
                                                contasPj[contaAtual].setValorTranf(
                                                        Integer.parseInt(
                                                                JOptionPane.showInputDialog("Informe o valor:")));
                                                contasPj[contaAtual].enviarTrnsf();
                                                contasPj[j].receberTrnsf();

                                                JOptionPane.showMessageDialog(null,
                                                        "Nome:" + contasPj[contaAtual].getnConta() +
                                                                "\nSaldo Atualizado::"
                                                                + contasPj[contaAtual].getSaldo());

                                                opTrans = false;

                                            }
                                            j++;
                                        }

                                    } else if (acao2 == 6) {
                                        JOptionPane.showMessageDialog(null, "Operação encerrada!");
                                        acessar = false;
                                        tpc = true;
                                    }

                                    else {
                                        JOptionPane.showMessageDialog(null, "Ação invalida tente novamente!");
                                    }

                                }
                            }

                            else {
                                JOptionPane.showMessageDialog(null, "Conta nao Encontrada \nDigite novamente!");

                            }
                        }
                    } else if(tipoC==3){
                        JOptionPane.showMessageDialog(null, "Sair");
                        
                    }else{
                          JOptionPane.showMessageDialog(null, "Operação Invalida!");
                    }
                   
                }
            } else if (acao == 3) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
                op = false;
            } else {
                JOptionPane.showMessageDialog(null, "Operação Invalida!");
            }
        }
    }
}