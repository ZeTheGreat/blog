package br.com.MW.Blog.Modelo;

public class Papel extends Identificador{
    private EnumPapeis descricao;

    public Papel(){}

    public Papel(Long id, EnumPapeis desc){
        super(id);
        this.AlterarDescricao(desc);
    }

    public EnumPapeis BuscarDescricao() {
        return descricao;
    }

    public void AlterarDescricao(EnumPapeis descricao) {
        this.descricao = descricao;
    }

}
