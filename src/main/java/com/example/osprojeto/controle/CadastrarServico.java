package com.example.osprojeto.controle;


import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ServicoDAO;
import com.example.osprojeto.DAO.ServicoDAOInterface;
import com.example.osprojeto.model.Servico;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;

import static com.example.osprojeto.util.Validador.*;

@WebServlet(name = "CadastrarServico", value = "/cadastrarservico")
public class CadastrarServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String nome=request.getParameter("nome");
        String descricao=request.getParameter("descricao");
        String valor=request.getParameter("valor");

        if(temValor(nome)&& temValor(descricao)&& temValor(valor)) {
            Servico s = new Servico(nome, descricao, BigDecimal.valueOf(Long.parseLong(valor)));
            try {
               ServicoDAOInterface dao = new ServicoDAO();
                dao.inserir(s);
                dao.sair();
                response.sendRedirect("redirecionarrelatorioservicos");
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else
        {
            response.sendRedirect("index.jsp?mensagem=faltadados");
        }
    }
}
