package br.com.MW.Blog.servico;

import br.com.MW.Blog.Modelo.Usuario;
import br.com.MW.Blog.banco.*;

import java.sql.SQLException;

public class ServicoUsuarioImp implements ServicoUsuario {

    @Override
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAOMySQL();
        usuarioDAO.Inserir(usuario);
        return null;
    }

    @Override
    public Usuario achaUsuarioPorId(long id) throws SQLException, ClassNotFoundException {
        UsuarioDAO usuarioDAO = new UsuarioDAOMySQL();
        Usuario usuario = usuarioDAO.BuscarpId(id);
        return usuario;
    }

    @Override
    public Usuario achaUsuarioPorNome(String nomeUsuario) throws SQLException, ClassNotFoundException {
        UsuarioDAO uDao = new UsuarioDAOMySQL();
        Usuario u = uDao.BuscarpUsu(nomeUsuario);
        return u;
    }



    @Override
    public void deletaUsuario(String idUsuario) {

    }

    @Override
    public void alteraUsuario(String idUsuario) {

    }
}

