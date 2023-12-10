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
import java.util.Set;

@WebServlet("/redirecionarrelatorioclientes")
public class RedirectRelatorioCliente extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteDAO clienteDAO = null;
        try {
            clienteDAO = new ClienteDAO();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        Set<Cliente> clientes = null;
        try {
            clientes = clienteDAO.buscar();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("relatorio-cliente.jsp");
        dispatcher.forward(request, response);
    }
}
