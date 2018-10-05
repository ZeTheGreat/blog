package br.com.MW.Blog.servico;

import br.com.MW.Blog.Modelo.Usuario;

import java.sql.SQLException;

public interface ServicoUsuario {
    public Usuario insereUsuario(Usuario usuario) throws SQLException, ClassNotFoundException;
    public Usuario achaUsuarioPorNome(String nomeUsuario) throws SQLException, ClassNotFoundException;
    public Usuario achaUsuarioPorId(long id) throws SQLException, ClassNotFoundException;
    public void deletaUsuario(String idUsuario);
    public void alteraUsuario(String idUsuario);
}
