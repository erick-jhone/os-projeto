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
import java.util.Set;

@WebServlet("/redirecionarrelatorioprodutos")
public class RedirectRelatorioProduto extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProdutoDAO produtoDAO = null;
        try {
            produtoDAO = new ProdutoDAO();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        Set<Produto> produtos = null;
        try {
            produtos = produtoDAO.buscar();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("produtos", produtos);

        RequestDispatcher dispatcher = request.getRequestDispatcher("relatorio-produto.jsp");
        dispatcher.forward(request, response);
    }
}


