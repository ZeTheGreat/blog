package br.com.MW.Blog.servlet;

import br.com.MW.Blog.Modelo.Usuario;
import br.com.MW.Blog.servico.ServicoUsuario;
import br.com.MW.Blog.servico.ServicoUsuarioImp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class Cadastro extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext sc = request.getServletContext();

        String usuario = request.getParameter("nomeUsuario");
        String senha = request.getParameter("senha");
        String login = request.getParameter("apelidoUsuario");
        String email = request.getParameter("emailUsuario");

        Usuario novoUsuario = new Usuario(usuario, email, senha, login);

        ServicoUsuario servicoUsuario = new ServicoUsuarioImp();

        try {
            servicoUsuario.insereUsuario(novoUsuario);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        sc.getRequestDispatcher("/login.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

