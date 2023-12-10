package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.*;
import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.Produto;
import com.example.osprojeto.model.Servico;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xalan.processor.ProcessorUnknown;

import java.io.IOException;
import java.util.Set;

@WebServlet("/iniciarordemservico")
public class IniciarOrdemServico extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            ProdutoDAOInterface produtoDAO = new ProdutoDAO();
            Set<Produto> produtos = produtoDAO.buscar();
            request.setAttribute("produtos", produtos);
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }

        try {
            ClienteDAOInterface clienteDAO = new ClienteDAO();
            Set<Cliente> clientes = clienteDAO.buscar();
            request.setAttribute("clientes", clientes);
        } catch (ErroDao e) {
            throw new RuntimeException(e);
        }

        try {
            ServicoDAOInterface servicoDao = new ServicoDAO();
            Set<Servico> servicos = servicoDao.buscar();
            request.setAttribute("servicos", servicos);
        } catch (ErroDao e){
            throw new RuntimeException(e);
        }

        RequestDispatcher despacho = request.getRequestDispatcher("os-form.jsp");
        despacho.forward(request, response);


    }
}
