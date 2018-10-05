package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.Papel;
import br.com.MW.Blog.Modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioPapelDAO {
    //Todos os papeis vinculados a um usuário.
    public List<Long> BuscarpUsu(Usuario u) throws SQLException;

    //Todos os usuários vinculados a um papel.
    public List<Long> BuscarpPapel(Papel p);
}
