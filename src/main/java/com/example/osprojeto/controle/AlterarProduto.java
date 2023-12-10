package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ProdutoDAO;
import com.example.osprojeto.model.Produto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/alterarproduto")
public class AlterarProduto extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProdutoDAO dao = new ProdutoDAO();
            Produto produto = dao.buscar(id);

            request.setAttribute("produto", produto);

            RequestDispatcher dispatcher = request.getRequestDispatcher("editproduto-form.jsp");
            dispatcher.forward(request, response);

        } catch (NumberFormatException | ErroDao e) {
            e.printStackTrace();
        }
    }
}
