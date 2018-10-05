package br.com.MW.Blog.Modelo;


public enum EnumPapeis {
    ADMINISTRADOR ("ADM"),
    USUARIO_COMUM ("USU"),
    VISITANTE ("VIS");
    private final String descricao;
    EnumPapeis(String valor){
        this.descricao = valor;
    }
    @Override
    public String toString(){
        return this.descricao;
    }
}
