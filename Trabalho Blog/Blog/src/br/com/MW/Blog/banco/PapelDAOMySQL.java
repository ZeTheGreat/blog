package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.EnumPapeis;
import br.com.MW.Blog.Modelo.Papel;


import java.sql.*;
import java.util.List;

public class PapelDAOMySQL implements PapelDAO {

    private Connection conexao;

    public PapelDAOMySQL() throws ClassNotFoundException, SQLException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/mwblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        final String USER = "root";
        final String PW = "tison123";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists papel(id_pap int primary key," +
                "tipo_pap enum('ADM', 'USU', 'VIS')" +
                ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);
    }

    @Override
    public Papel Inserir(Papel papel) throws SQLException {
        Papel p = null;

        PreparedStatement comandoSQL = conexao.prepareStatement("select * from papel where id_pap = ?");
        ResultSet rs = comandoSQL.executeQuery();
        rs.next();
        p = new Papel();
        p.AlterarId(rs.getLong(1));
        p.AlterarDescricao(EnumPapeis.valueOf(rs.getString(2)));
        System.out.println(rs.getString(2));
        rs.close();
        conexao.close(); // usando singleton não precisa fechar a conexão.

        return p;
    }

    @Override
    public Papel BuscarpId(Long id) throws SQLException {
        Papel papel = null;
        PreparedStatement query = conexao.prepareStatement("select * from papel where id_pap = ?");
        query.setLong(1, id);

        ResultSet rs = query.executeQuery();

        if (rs.next()){
            papel = new Papel();

            papel.AlterarId(rs.getLong(1));
            String descricao = rs.getString(2);

            EnumPapeis desc = EnumPapeis.valueOf(descricao);
            papel.AlterarDescricao(desc);
        }

        return papel;
    }

    @Override
    public List<Papel> BuscarTodos() throws SQLException {

        PreparedStatement query = conexao.prepareStatement("select * from papel");
        ResultSet rs = query.executeQuery();
        Papel papel = null;

        while(rs.next()){
            papel = new Papel();

            papel.AlterarId(rs.getLong(1));
            String descricao = rs.getString(2);

            EnumPapeis desc = EnumPapeis.valueOf(descricao);
        }

        return null;
    }

    @Override
    public Papel BuscarpDesc(EnumPapeis desc) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Papel Atualizar(Papel papelA, Papel N) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean Deletar(Papel papel) {
        // TODO Auto-generated method stub
        return false;
    }

}
