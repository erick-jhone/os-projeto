package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Servico;

import java.util.Set;

public interface ServicoDAOInterface {

    public void inserir(Servico servico) throws ErroDao;
    public void deletar(Servico servico) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Servico servico)throws ErroDao;
    public Servico buscar(Integer id) throws ErroDao;
    public Set<Servico> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
