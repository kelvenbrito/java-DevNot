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

                int contGatos = 0, contCachorros = 0, contOutros = 0, contData = 0;

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
                                int acao3 = Integer
                                                .parseInt(JOptionPane.showInputDialog(
                                                                "1-Marcar consulta\n 2- Desmacar Consulta\n  3-Sair"));
                                if (acao3 == 1) {
                                        Agenda consulta[] = new Agenda[10];
                                        String nomeProp = JOptionPane.showInputDialog("Informe Nome do animal");

                                        for (int i = 0; i < outros.length; i++) {
                                                if (nomeProp == gatos[i].getNome() || nomeProp == cachorros[i].getNome()
                                                                || nomeProp == outros[i].getNome()) {
                                                        JOptionPane.showMessageDialog(null,
                                                                        "O animal já tem uma consulta marcada!");
                                                } else {
                                                        int contConsuta = 0;
                                                        boolean escConsulta = true;

                                                        String consData = JOptionPane.showInputDialog(
                                                                        "Informe a data! \nPadrao DD-MM-AA");
                                                        String condHora = JOptionPane.showInputDialog(
                                                                        "Informe a hora! \nPadrao HH-MM");
                                                        while (escConsulta) {
                                                                if (consData + condHora == consulta[contConsuta].getDataHora()) {
                                                                        JOptionPane.showMessageDialog(null,
                                                                                        "Horario Ocupado - Por favor informe outro horario ou outra data!");
                                                                } else {
                                                                        consulta[contConsuta].setData(consData);
                                                                        consulta[contConsuta].setHora(condHora);
                                                                        consulta[contConsuta].setServico(
                                                                                        JOptionPane.showInputDialog(
                                                                                                        "Informe o serviço"));
                                                                }

                                                        }
                                                }

                                        }

                                }

                        }
                }
        }
}