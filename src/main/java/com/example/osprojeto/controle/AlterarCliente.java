package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.ClienteDAO;
import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.model.Cliente;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/alterarcliente")
public class AlterarCliente extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ClienteDAO dao = new ClienteDAO();
            Cliente cliente = dao.buscar(id);

            request.setAttribute("cliente", cliente);

            RequestDispatcher dispatcher = request.getRequestDispatcher("editcliente-form.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | ErroDao e) {
            e.printStackTrace();
        }
    }
}
