package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ProdutoDAO;
import com.example.osprojeto.DAO.ServicoDAO;
import com.example.osprojeto.DAO.ServicoDAOInterface;
import com.example.osprojeto.model.Produto;
import com.example.osprojeto.model.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/redirecionarrelatorioservicos")
public class RedirectRelatorioServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServicoDAOInterface servicoDAO = null;
        try {
            servicoDAO = new ServicoDAO();
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        Set<Servico> servicos = null;
        try {
            servicos = servicoDAO.buscar();

        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("servicos", servicos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("relatorio-servico.jsp");
        dispatcher.forward(request, response);

    }

}
