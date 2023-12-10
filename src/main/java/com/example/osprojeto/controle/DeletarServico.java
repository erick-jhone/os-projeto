package com.example.osprojeto.controle;


import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ServicoDAO;
import com.example.osprojeto.DAO.ServicoDAOInterface;
import com.example.osprojeto.model.Servico;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

@WebServlet(name = "deletarservico", value = "/deletarservico")
public class DeletarServico extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        String tid=request.getParameter("id");

        HttpSession sessao=request.getSession();

        if(Validador.temValor(tid)) {
            int id=Integer.parseInt(tid);
            try {
                ServicoDAOInterface dao = new ServicoDAO();
                dao.deletar(id);
                dao.sair();
                Set<Servico> servicos = dao.buscar();
                request.setAttribute("servicos", servicos);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-servico.jsp");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("relatorio-servico.jsp");
            }



        }
        else //senão
        {
            response.sendRedirect("relatorio.jsp?mensagem=faltadados");
        }
    }
}
