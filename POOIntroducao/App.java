package POOIntroducao;

public class App {
    public static void main(String[] args) {

        // criar 3 objetos ResgistraAluno
        RegistraAluno ana = new RegistraAluno();
        RegistraAluno beto = new RegistraAluno();
        RegistraAluno carlos = new RegistraAluno();
        //set do nome usando o setNome
        ana.setNome("Ana Machado");
        ana.setEndereco("Rua das flores, 123");
        ana.setIdade(14);
        ana.setNotaPortugues(9);
        ana.setNotaMatematica(8);
        ana.setNotaCiencias(9);

        beto.setNome("Roberto da Silva");
        beto.setEndereco("Rua j`da Dona, 434");
        beto.setIdade(16);
        beto.setNotaPortugues(6);
        beto.setNotaMatematica(4);
        beto.setNotaCiencias(3);

        carlos.setNome("Carlos Alberto");
        carlos.setEndereco("Rua carlso wilsel, 23");
        carlos.setIdade(17);
        carlos.setNotaPortugues(10);
        carlos.setNotaMatematica(10);
        carlos.setNotaCiencias(9);

        //Imprimir usando o método getNome()
        System.out.println("Nome:"+ana.getNome());
        System.out.println("Endereço:"+ana.getEndereco());
        System.out.println("Idade:"+ana.getIdade());
        System.out.println("Média:"+ana.getMedia());
        System.out.println("-------------------------------");

        System.out.println("Nome:"+beto.getNome());
        System.out.println("Endereço:"+beto.getEndereco());
        System.out.println("Idade:"+beto.getIdade());
        System.out.println("Média:"+beto.getMedia());

        System.out.println("-------------------------------");

        System.out.println("Nome:"+carlos.getNome());
        System.out.println("Endereço:"+carlos.getEndereco());
        System.out.println("Idade:"+carlos.getIdade());
        System.out.println("Média:"+carlos.getMedia());

        System.out.println("Contador: "
                + RegistraAluno.getQuantidadeAlunos());
    }
}
