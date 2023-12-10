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

import java.io.IOException;

@WebServlet(name = "Cadastrar", value = "/cadastrar")
public class Cadastrar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext aplicacao=getServletContext();
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String login=request.getParameter("login");
        String senha=request.getParameter("senha");
        //se os dados existirem
        if(Validador.temValor(login)&& Validador.temValor(senha)) {
            //instancia o usuário e coloca no conjunto
            Usuario u=new Usuario(login,senha);
            try {
                UsuarioDaoInterface dao=new UsuarioDao();
                dao.inserir(u);
                dao.sair();
                //envia para o relatorio com a mensagem de sucesso
                response.sendRedirect("relatorio.jsp?mensagem=cadastradocomsucesso");
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else //senão
        {
            //envia para o index com a mensagem de erro
            response.sendRedirect("index.jsp?mensagem=faltadados");
        }
    }
}
