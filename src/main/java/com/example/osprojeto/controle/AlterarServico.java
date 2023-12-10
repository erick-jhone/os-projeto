package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.ClienteDAO;
import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ServicoDAO;
import com.example.osprojeto.DAO.ServicoDAOInterface;
import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/alterarservico")
public class AlterarServico extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            ServicoDAOInterface dao = new ServicoDAO();
            Servico servico = dao.buscar(id);

            request.setAttribute("servico", servico);

            RequestDispatcher dispatcher = request.getRequestDispatcher("editservico-form.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | ErroDao e) {
            e.printStackTrace();
        }
    }
}


