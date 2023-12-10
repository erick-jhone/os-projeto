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

import java.io.IOException;
import java.util.Set;


@WebServlet(name = "CadastrarCliente", value = "/cadastrarcliente")
public class CadastrarCliente extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String nome=request.getParameter("nome");
        String telefone=request.getParameter("telefone");
        String endereco=request.getParameter("endereco");

        if(Validador.temValor(nome)&&Validador.temValor(telefone)&&Validador.temValor(endereco)) {
            Cliente c = new Cliente(nome, telefone, endereco);
            try {
                ClienteDAOInterface dao = new ClienteDAO();
                dao.inserir(c);
                dao.sair();
                Set<Cliente> clientes = dao.buscar();
                request.setAttribute("clientes", clientes);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-cliente.jsp?mensagem=cadastradocomsucesso");
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
