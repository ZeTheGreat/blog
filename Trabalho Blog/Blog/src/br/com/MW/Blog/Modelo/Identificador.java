package br.com.MW.Blog.Modelo;

public class Identificador {
    private Long id;

    public Identificador(){

    }
    public Identificador(Long id){
        this.AlterarId(id);
    }
    public Long Buscarid() {
        return id;
    }

    public void AlterarId(Long id) {
        this.id = id;
    }
}
