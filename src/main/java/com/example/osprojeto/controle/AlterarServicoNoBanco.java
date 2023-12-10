package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.*;
import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.Servico;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@WebServlet("/atualizarservico")
public class AlterarServicoNoBanco extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String nome=request.getParameter("nome");
        String descricao=request.getParameter("descricao");
        String valor=request.getParameter("valor");

        //se os dados existirem
        if(Validador.temValor(id)&&Validador.temValor(nome)&&Validador.temValor(descricao)&&Validador.temValor(valor)) {

            Servico s = new Servico(Integer.parseInt(id), nome, descricao, BigDecimal.valueOf(Double.parseDouble(valor)));

            try {
                ServicoDAOInterface dao = new ServicoDAO();
                dao.editar(s);
                Set<Servico> servicos = dao.buscar();
                request.setAttribute("servicos", servicos);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-servico.jsp");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("relatorio-servico.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else
        {
            response.sendRedirect("relatorio-servico.jsp?mensagem=faltadados");
        }
    }
}

