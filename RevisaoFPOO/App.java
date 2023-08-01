package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Agenda.Agenda;
import RevisaoFPOO.Cadastro.OutrosAnimais;

/**
 * App
 */
public class App {

        public static void main(String[] args) {
                // cria o cadastro(armazenar em um vetor)
                Gato gatos[] = new Gato[10];
                Cachorro cachorros[] = new Cachorro[10];
                OutrosAnimais outros[] = new OutrosAnimais[10];
                Agenda agendas[] = new Agenda[100];// armazernar as consultas()

                int contGatos = 0, contCachorros = 0, contOutros = 0, contData = 0, contAgenda = 0;
                ;

                // criar a minha aplicação
                JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consultório\n do Dr. Frankstein");
                boolean aberto = true;

                while (aberto) {
                        int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consulta\n 3-Sair"));
                        if (acao1 == 1) {// cadastro}
                                int acao2 = Integer.parseInt(
                                                JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                                // criar um objeto
                                if (acao2 == 1) {
                                        gatos[contGatos] = new Gato(); // utilizar o construtor
                                        gatos[contGatos].setNome(JOptionPane.showInputDialog("Informe o nome do gato"));
                                        gatos[contGatos].setraca(JOptionPane.showInputDialog("Informe a raça do gato"));
                                        gatos[contGatos]
                                                        .setPeso(Double.parseDouble(JOptionPane
                                                                        .showInputDialog("Informe o Peso do gato")));
                                        gatos[contGatos]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Informe o nome do proprietario do gato"));
                                        JOptionPane.showMessageDialog(null,
                                                        "Nome:" + gatos[contGatos].getNome() + "\nRaça:"
                                                                        + gatos[contGatos].getraca() + "\nPeso:"
                                                                        + gatos[contGatos].getPeso()
                                                                        + "\nNome do proprietario:"
                                                                        + gatos[contGatos].getProprietario());
                                        contGatos++;
                                } else if (acao2 == 2) {
                                        cachorros[contCachorros] = new Cachorro();
                                        cachorros[contCachorros].setNome(
                                                        JOptionPane.showInputDialog("Informe o nome do cachorro"));
                                        cachorros[contCachorros]
                                                        .setraca(JOptionPane
                                                                        .showInputDialog("Informe a raça do cachorro"));
                                        cachorros[contCachorros]
                                                        .setPeso(Double.parseDouble(JOptionPane.showInputDialog(
                                                                        "Informe o Peso do cachorro")));
                                        cachorros[contCachorros]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Informe o nome do proprietario do cachorro"));
                                        JOptionPane.showMessageDialog(null,
                                                        "Nome:" + cachorros[contCachorros].getNome() + "\nRaça:"
                                                                        + cachorros[contCachorros].getraca() + "\nPeso:"
                                                                        + cachorros[contCachorros].getPeso()
                                                                        + "\nNome do proprietario:"
                                                                        + gatos[contGatos].getProprietario());
                                        contCachorros++;

                                } else if (acao2 == 3) {
                                        outros[contOutros] = new OutrosAnimais();
                                        ;
                                        outros[contOutros].setNome(
                                                        JOptionPane.showInputDialog("Informe o nome do animal"));
                                        outros[contOutros]
                                                        .setraca(JOptionPane.showInputDialog("Informe a raça animal"));
                                        outros[contOutros]
                                                        .setPeso(Double.parseDouble(JOptionPane
                                                                        .showInputDialog("Informe o Peso do animal")));
                                        outros[contOutros]
                                                        .setProprietario(JOptionPane.showInputDialog(
                                                                        "Informe o nome do proprietario do animal"));
                                        JOptionPane.showMessageDialog(null,

                                                        "Nome:" + outros[contOutros].getNome() + "\nRaça:"
                                                                        + outros[contOutros].getraca()
                                                                        + "\nPeso:" + outros[contOutros].getPeso()
                                                                        + "\nNome do proprietario:"
                                                                        + outros[contOutros].getProprietario());
                                        contOutros++;

                                } else {
                                        JOptionPane.showMessageDialog(null, "Valor invalido!");
                                }
                        } else if (acao1 == 2) {// agendar consulta
                                // 1º verificação - cadastro do nome
                                boolean cadastroOK = false;
                                String nomeAgenda = JOptionPane.showInputDialog("Informe o Nome do PET");
                                for (int i = 0; i < contGatos; i++) {// busca no vetor de gatos
                                        if (gatos[i].getNome().equals(nomeAgenda)) {
                                                // mensagem de confirmação
                                                JOptionPane.showMessageDialog(null, "Pet Encontrado");
                                                cadastroOK = true;
                                                break;
                                        }
                                }
                                for (int i = 0; i < contCachorros; i++) {// busca no vetor de gatos
                                        if (cachorros[i].getNome().equals(nomeAgenda)) {
                                                // mensagem de confirmação
                                                JOptionPane.showMessageDialog(null, "Pet Encontrado");
                                                cadastroOK = true;
                                                break;
                                        }
                                }
                                for (int i = 0; i < contOutros; i++) {// busca no vetor de gatos
                                        if (outros[i].getNome().equals(nomeAgenda)) {
                                                // mensagem de confirmação
                                                JOptionPane.showMessageDialog(null, "Pet Encontrado");
                                                cadastroOK = true;
                                                break;
                                        }
                                }
                                // 2º Terminar o Cadastro
                                // 2º Terminar o Cadastro
                                if (cadastroOK) {
                                        boolean agendar = true;
                                        while (agendar) {
                                                String dataAgenda = JOptionPane
                                                                .showInputDialog("Informe a Data do Agendamento");
                                                String horaAgenda = JOptionPane
                                                                .showInputDialog("Informe a Hora do Agendamento");
                                                if (contAgenda == 0) {
                                                        agendas[contAgenda] = new Agenda();
                                                        agendas[contAgenda].setData(dataAgenda);
                                                        agendas[contAgenda].setHora(horaAgenda);
                                                        agendar = false;

                                                } else {
                                                        for (int i = 0; i < contAgenda; i++) {
                                                                if (agendas[i].getDataHora()
                                                                                .equals(dataAgenda + horaAgenda)) {
                                                                        // não pode agendar
                                                                        break;
                                                                }else{
                                                                        agendas[contAgenda] = new Agenda();
                                                                        agendas[contAgenda].setData(dataAgenda);
                                                                        agendas[contAgenda].setHora(horaAgenda);
                                                                        agendar = false;
                                                                    }                                                              

                                                        }

                                                }
                                        }
                                }

                        }

                }
        }
}
