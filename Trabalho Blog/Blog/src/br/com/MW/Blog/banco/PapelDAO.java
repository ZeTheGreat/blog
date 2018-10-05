package br.com.MW.Blog.banco;

import br.com.MW.Blog.Modelo.EnumPapeis;
import br.com.MW.Blog.Modelo.Papel;

import java.sql.SQLException;
import java.util.List;

public interface PapelDAO {
    public Papel Inserir(Papel papel) throws SQLException;
    public Papel BuscarpId(Long id) throws SQLException;
    public Papel BuscarpDesc(EnumPapeis desc);
    public List<Papel> BuscarTodos() throws SQLException;
    public Papel Atualizar(Papel papelA, Papel N);
    public boolean Deletar(Papel papel);

}
