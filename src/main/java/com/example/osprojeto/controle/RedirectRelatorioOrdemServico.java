package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.*;
import com.example.osprojeto.model.OrdemServico;
import com.example.osprojeto.model.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/redirecionarrelatorioordemservico")
public class RedirectRelatorioOrdemServico extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrdemServicoDAOInterface ordemServicoDAO = null;
        try {
            ordemServicoDAO = new OrdemServicoDAO();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        Set<OrdemServico> ordensDeservico = null;
        try {
            ordensDeservico = ordemServicoDAO.buscar();


        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("ordensdeservico", ordensDeservico);
        RequestDispatcher dispatcher = request.getRequestDispatcher("relatorio-os.jsp");
        dispatcher.forward(request, response);

    }

}
