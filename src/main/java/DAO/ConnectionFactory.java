package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String usuario = "root";
    private static String senha = "root";
    private static String host = "localhost";
    private static String porta = "3306";
    private static String bd = "greencity";

    public static Connection obtemConexao() {
        try {
            Connection c = DriverManager.getConnection(
                    "jdbc:mysql://" + host + ":" + porta + "/" + bd +"?useTimezone=true&serverTimezone=America/Sao_Paulo",
                    usuario,
                    senha
            );
            System.out.println("conectado com sucesso");
            return c;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
