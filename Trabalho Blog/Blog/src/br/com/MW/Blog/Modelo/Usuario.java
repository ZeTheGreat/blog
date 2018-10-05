package br.com.MW.Blog.Modelo;

import java.util.List;

public class Usuario extends Identificador {
    private Long id;
    private String nome;
    private String senha;
    private String nomeUsuario;
    private String email;
    private List<Papel> papeis;

    public Usuario(){}
    public Usuario(Long id, String nome, String senha,
                   String nomeUsuario, String email,
                   List<Papel> papeis){
        super(id);
        this.AlterarNome(nome);
        this.AlterarSenha(senha);
        this.AlterarNomeUsuario(nomeUsuario);
        this.AlterarEmail(email);
        this.AlterarPapeis(papeis);
    }
    public Usuario(String nome, String email, String senha, String nomeUsuario) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nomeUsuario = nomeUsuario;
    }
    public String BuscarNome() {
        return nome;
    }

    public void AlterarNome(String nome) {
        this.nome = nome;
    }

    public String BuscarSenha() {
        return senha;
    }

    public void AlterarSenha(String senha) {
        this.senha = senha;
    }

    public Long BuscarId() {
        return id;
    }

    public void AlterarId(Long id) {
        this.id = id;
    }

    public String BuscarNomeUsuario() {
        return nomeUsuario;
    }

    public void AlterarNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String BuscarEmail() {
        return email;
    }

    public void AlterarEmail(String email) {
        this.email = email;
    }

    public List<Papel> BuscarPapeis() {
        return papeis;
    }

    public void AlterarPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

}
