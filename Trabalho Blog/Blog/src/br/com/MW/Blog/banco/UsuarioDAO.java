package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface UsuarioDAO {
    public Usuario Inserir(Usuario usuario) throws SQLException;
    public Usuario BuscarpId(Long id) throws SQLException;
    public Usuario BuscarpUsu(String nomeUsuario) throws SQLException, ClassNotFoundException;
    public List<Usuario> BuscarTodos();
    public Usuario Atualizar(Usuario usuarioAnt, Usuario usuarioAt);
    public boolean ExcluirpUsu(Usuario usuario);
    public boolean ExcluirpId(Long id);

}
