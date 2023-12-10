package com.example.osprojeto.controle;


import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.DAO.ProdutoDAO;
import com.example.osprojeto.DAO.ProdutoDAOInterface;
import com.example.osprojeto.model.Produto;
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

@WebServlet(name = "deletarproduto", value = "/deletarproduto")
public class DeletarProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //pegar os dados
        String tid=request.getParameter("id");

        HttpSession sessao=request.getSession();
        //se os dados existirem
        if(Validador.temValor(tid)) {
            int id=Integer.parseInt(tid);
            try {
                ProdutoDAOInterface dao = new ProdutoDAO();
                dao.deletar(id);
                dao.sair();
                Set<Produto> produtosList = dao.buscar();
                request.setAttribute("produtos", produtosList);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-produto.jsp");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("relatorio-produto.jsp");
            }



        }
        else //senão
        {
            response.sendRedirect("relatorio.jsp?mensagem=faltadados");
        }
    }
}
