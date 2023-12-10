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

import java.io.IOException;
import java.util.List;
import java.util.Set;

@WebServlet(name = "CadastrarProduto", value = "/cadastrarproduto")
public class CadastrarProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nserie=request.getParameter("nserie");
        String nome=request.getParameter("nome");
        String marca=request.getParameter("marca");
        String modelo=request.getParameter("modelo");
        if(Validador.temValor(nserie)&&Validador.temValor(nome)&&Validador.temValor(marca)&&Validador.temValor(modelo)) {
            Produto p = new Produto(nserie, nome, modelo, marca);
            try {
                ProdutoDAOInterface dao=new ProdutoDAO();
                dao.inserir(p);
                dao.sair();
                Set<Produto> produtosList = dao.buscar();
                request.setAttribute("produtos", produtosList);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-produto.jsp");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else //senão
        {
            //envia para o index com a mensagem de erro
            response.sendRedirect("index.jsp?mensagem=faltadados");
        }
    }
}
