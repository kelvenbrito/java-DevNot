import java.sql.*;

/**
 * ConnectionFactory
 */
public class ConnectionFactory {
    // ATRIBUTOS DA CONEXÃO
    private static final String url = "jdbc:progres://localhost:5432/postgres";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection con){
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}