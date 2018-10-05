package br.com.MW.Blog.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.MW.Blog.Modelo.Papel;

public class Conexao {
    public static Connection conn;
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/mwblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private final String USER = "root";
    private final String PW = "";

    public Conexao() {
        PegarC();
    }

    public void PegarC() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PW);
            System.out.println("Connected Successfully with the DB.\n");

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Connection error: ", ex);
        }
    }


    public static void FecharConexao(Connection con, PreparedStatement stmt) throws SQLException {
        if (con != null) {
            con.close();
        }
    }
}
