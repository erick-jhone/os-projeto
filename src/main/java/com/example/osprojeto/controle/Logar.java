package com.example.osprojeto.controle;


import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.UsuarioDao;
import com.example.osprojeto.DAO.UsuarioDaoInterface;
import com.example.osprojeto.model.Usuario;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Logar", value = "/logar")
public class Logar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        HttpSession sessao=request.getSession();
        //se os dados existirem
        if(Validador.temValor(login)&&Validador.temValor(senha)) {

            try {
                UsuarioDaoInterface dao = new UsuarioDao();
                Usuario u=dao.buscar(login,senha);
                dao.sair();
                if(u!=null)
                {
                    sessao.setAttribute("usuario",u);
                    response.sendRedirect("dashboard.jsp?mensagem=logadocomsucesso");
                }
                else {
                    response.sendRedirect("index.jsp?mensagem=loginousenhaincorretos");

                }
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaologar");            }
        }
        else //senão
        {
            response.sendRedirect("index.jsp?mensagem=faltadados");
        }
    }
}

