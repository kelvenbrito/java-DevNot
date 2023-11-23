package app;

import Connection.ConnectionDAO;

public class Main {
    public static void main(String[] args) {
        new ConnectionDAO().listarTodos();
        //  new ConnectionDAO().inserir("Kelven", "kelven@email.com");
        //   new ConnectionDAO().inserir("maicon");
        //    new ConnectionDAO().buscarPorId(1);
    }
}