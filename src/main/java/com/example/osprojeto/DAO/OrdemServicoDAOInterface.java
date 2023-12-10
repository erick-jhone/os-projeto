package com.example.osprojeto.DAO;

import com.example.osprojeto.model.OrdemServico;
import com.example.osprojeto.model.Produto;

import java.util.Set;

public interface OrdemServicoDAOInterface {


    public void inserir(OrdemServico os) throws ErroDao;
    public void deletar(OrdemServico os) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(OrdemServico os)throws ErroDao;
    public OrdemServico buscar(int id) throws ErroDao;
    public Set<OrdemServico> buscar()throws ErroDao;
    public void sair() throws ErroDao;



}
