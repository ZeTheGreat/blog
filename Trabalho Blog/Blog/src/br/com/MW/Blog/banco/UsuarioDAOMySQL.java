package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.Papel;
import br.com.MW.Blog.banco.PapelDAO;
import br.com.MW.Blog.Modelo.Usuario;

import br.com.MW.Blog.banco.*;


import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAOMySQL implements UsuarioDAO {

    private Connection conexao;

    public UsuarioDAOMySQL() throws SQLException, ClassNotFoundException {
        final String DRIVER = "com.mysql.cj.jdbc.Driver";
        final String URL = "jdbc:mysql://localhost:3306/mwblog?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
        final String USER = "root";
        final String PW = "tison123";

        Class.forName(DRIVER);
        conexao = DriverManager.getConnection(URL, USER, PW);

        String query = "create table if not exists usuario( id_usu int auto_increment primary key ," + "nome_usu varchar(100)," + "senha_usu varchar(200)," + "login_usu varchar(100)," + "email_usu varchar(100)" + ");";

        Statement statement = conexao.createStatement();
        statement.execute(query);
    }

    @Override
    public Usuario Inserir(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario (nome_usu, senha_usu, login_usu, email_usu) VALUES (?,?,?,?);";
        java.sql.PreparedStatement statement = conexao.prepareStatement(query);

        statement.setString(1, usuario.BuscarNome());
        statement.setString(2, usuario.BuscarSenha());
        statement.setString(3, usuario.BuscarNomeUsuario());
        statement.setString(4, usuario.BuscarEmail());

        statement.execute();
        statement.close();

        return usuario;
    }

    @Override
    public Usuario BuscarpUsu(String nomeUsuario) throws SQLException, ClassNotFoundException {

        PapelDAO papelDAO = new PapelDAOMySQL();
        UsuarioPapelDAO usuarioPapelDAO = new UsuarioPapelDAOMySQL();
        List<Long> idPapeis = new ArrayList<>();
        List<Papel> papeis = new ArrayList<>();


        Usuario achado = null;

        PreparedStatement query = conexao.prepareStatement("select * from usuario where nome_usu = ?");
        query.setString(1, nomeUsuario);

        ResultSet rs = query.executeQuery();

        System.out.println("Conectado...");


        if (rs.next()) {

            achado = new Usuario();
            achado.AlterarId(rs.getLong(1));
            achado.AlterarNome(rs.getString(2));
            achado.AlterarSenha(rs.getString(3));
            achado.AlterarNomeUsuario(rs.getString(4));
            achado.AlterarEmail(rs.getString(5));

            idPapeis = usuarioPapelDAO.BuscarpUsu(achado);
            for(Long idPapel: idPapeis){
                papeis.add(papelDAO.BuscarpId(idPapel));
            }

            achado.AlterarPapeis(papeis);

            System.out.println(achado.toString());
        }

        query.close();

        rs.close();

        return achado;
    }

    @Override
    public Usuario BuscarpId(Long idUsuario) throws SQLException {

        Usuario u = null;

        java.sql.PreparedStatement comandoSQL = conexao.prepareStatement("select * from usuario where id_usu = ?");
        comandoSQL.setString(1, idUsuario.toString());
        ResultSet rs = comandoSQL.executeQuery();
        System.out.println("Conectei...");
        rs.next();
        u = new Usuario();
        u.AlterarId(rs.getLong(1));
        u.AlterarNomeUsuario(rs.getString(2));
        u.AlterarSenha(rs.getString(3));
        u.AlterarNome(rs.getString(4));
        u.AlterarEmail(rs.getString(5));
        comandoSQL.close();
        rs.close();

        return u;
    }

    @Override
    public List<Usuario> BuscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Usuario Atualizar(Usuario usuarioAnt, Usuario usuarioAt) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean ExcluirpUsu(Usuario usuario) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean ExcluirpId(Long id) {
        // TODO Auto-generated method stub
        return false;
    }
}

