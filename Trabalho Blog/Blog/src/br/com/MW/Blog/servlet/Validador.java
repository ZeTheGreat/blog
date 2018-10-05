package br.com.MW.Blog.servlet;

import br.com.MW.Blog.Modelo.Usuario;
import br.com.MW.Blog.banco.UsuarioDAO;
import br.com.MW.Blog.servico.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class Validador extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = req.getServletContext();
        try {
            req.setCharacterEncoding("UTF-8");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        String nomeUsuario = req.getParameter("nomeUsuario");
        String senha = req.getParameter("senha");
        ServicoUsuario sUsuario = new ServicoUsuarioImp();
        try {
            Usuario uBD = sUsuario.achaUsuarioPorNome(nomeUsuario);
            System.out.println(nomeUsuario);
            if (uBD != null && uBD.BuscarSenha().equals(senha) && uBD.BuscarNomeUsuario().equals(nomeUsuario)) {
                req.setAttribute("usuarioLogado", uBD);
                sc.getRequestDispatcher("/home.jsp").forward(req, resp);
            } else {
                req.setAttribute("falhaAutenticação", true);
                sc.getRequestDispatcher("/login.jsp").forward(req, resp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}