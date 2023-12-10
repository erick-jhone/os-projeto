package com.example.osprojeto.controle;


import com.example.osprojeto.DAO.ClienteDAO;
import com.example.osprojeto.DAO.ClienteDAOInterface;
import com.example.osprojeto.DAO.ErroDao;
import com.example.osprojeto.model.Cliente;
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

@WebServlet(name = "deletarcliente", value = "/deletarcliente")
public class DeletarCliente extends HttpServlet {
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
                ClienteDAOInterface dao = new ClienteDAO();
                dao.deletar(id);
                dao.sair();
                Set<Cliente> clientes = dao.buscar();
                request.setAttribute("clientes", clientes);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-cliente.jsp?");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("relatorio-cliente.jsp");
            }

        }
        else //senão
        {
            response.sendRedirect("relatorio.jsp?mensagem=faltadados");
        }
    }
}
