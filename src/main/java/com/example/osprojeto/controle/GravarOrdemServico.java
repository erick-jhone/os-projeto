package com.example.osprojeto.controle;

import com.example.osprojeto.DAO.*;
import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.OrdemServico;
import com.example.osprojeto.model.Produto;
import com.example.osprojeto.model.Servico;
import com.example.osprojeto.util.Validador;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

@WebServlet("/gravarordemservico")
public class GravarOrdemServico extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String clienteID = request.getParameter("cliente");
        String produtoID = request.getParameter("produto");
        String observacao = request.getParameter("observacao");
        String dataEntrada = request.getParameter("dataentrada");
        String dataSaida = request.getParameter("datasaida");
        List<String> servicosID = new ArrayList<>(List.of(request.getParameterValues("servicos")));

        if (Validador.temValor(clienteID) && Validador.temValor(produtoID) && Validador.temValor(observacao)
                && Validador.temValor(dataEntrada) && Validador.temValor(dataSaida)) {
            OrdemServico ordemServico = new OrdemServico();

            try {
                Date dataEntradaDate = new SimpleDateFormat("yyyy-MM-dd").parse(dataEntrada);
                Date dataSaidaDate = new SimpleDateFormat("yyyy-MM-dd").parse(dataSaida);
                ordemServico.setDataEntrada(dataEntradaDate);
                ordemServico.setDataSaida(dataSaidaDate);

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }


            try {
                ProdutoDAOInterface produtoDAO = new ProdutoDAO();
                Produto produtoOS = produtoDAO.buscar(Integer.parseInt(produtoID));
                ordemServico.setProduto(produtoOS);
                request.setAttribute("produto", produtoOS);
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }

            try {
                ClienteDAOInterface clienteDAO = new ClienteDAO();
                Cliente cliente = clienteDAO.buscar(Integer.parseInt(clienteID));
                ordemServico.setCliente(cliente);
                request.setAttribute("cliente", cliente);
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }

            try {
                ServicoDAOInterface servicoDao = new ServicoDAO();
                List<Servico> servicos = new ArrayList<>();
                for (String idServico : servicosID) {
                    Servico servico = servicoDao.buscar(Integer.parseInt(idServico));
                    servicos.add(servico);
                }
                ordemServico.setServicos(servicos);
                request.setAttribute("servicos", servicos);
            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }

            try {
                OrdemServicoDAOInterface osDAO = new OrdemServicoDAO();
                ordemServico.setObservacao(observacao);

                osDAO.inserir(ordemServico);


            } catch (ErroDao e) {
                throw new RuntimeException(e);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("redirecionarrelatorioordemservico");
            dispatcher.forward(request, response);

        }





    }
}
