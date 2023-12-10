package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.*;
import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.Produto;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Set;

@WebServlet("/atualizarcliente")
public class AlterarClienteNoBanco extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String nome=request.getParameter("nome");
        String telefone=request.getParameter("telefone");
        String endereco=request.getParameter("endereco");

        //se os dados existirem
        if(Validador.temValor(id)&&Validador.temValor(nome)&&Validador.temValor(telefone)&&Validador.temValor(endereco)) {

            Cliente c = new Cliente(Integer.parseInt(id), nome, telefone, endereco);
            try {
                ClienteDAOInterface dao=new ClienteDAO();
                dao.editar(c);
                dao.sair();
                Set<Cliente> clientesList = dao.buscar();
                request.setAttribute("clientes", clientesList);
                RequestDispatcher despacho = request.getRequestDispatcher("relatorio-cliente.jsp");
                despacho.forward(request, response);
            } catch (ErroDao e) {
                response.sendRedirect("index.jsp?mensagem=erroaotentarcadastrar");
            }


        }
        else
        {
            response.sendRedirect("index.jsp?mensagem=faltadados");
        }
    }
}
