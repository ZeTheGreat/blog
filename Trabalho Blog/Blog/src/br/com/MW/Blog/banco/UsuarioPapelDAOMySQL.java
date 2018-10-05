package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.Papel;
import br.com.MW.Blog.Modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPapelDAOMySQL implements UsuarioPapelDAO {

    Connection conexao;

    public UsuarioPapelDAOMySQL() throws ClassNotFoundException, SQLException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/mwblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        final String USER = "root";
        final String PW = "tison123";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists papelusu(idusuario int," +
                "idpapel int," +
                "constraint idusuario foreign key(idusuario) references usuario (id_usu)," +
                "constraint idpapel foreign key(idpapel) references papel (id_pap)," +
                "constraint pk primary key (idusuario, idpapel)" +
                ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);
    }

    @Override
    public List<Long> BuscarpUsu(Usuario u) throws SQLException {

        List<Long> idpapeis = new ArrayList<>();

        PreparedStatement query = conexao.prepareStatement("select * from papelusu where idusuario = ?");
        query.setLong(1, u.BuscarId());

        ResultSet rs = query.executeQuery();

        while(rs.next()){
            idpapeis.add(rs.getLong(2));
        }

        return idpapeis;
    }

    @Override
    public List<Long> BuscarpPapel(Papel u) {
        return null;
    }
}
