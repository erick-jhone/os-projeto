package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Cliente;

import java.util.Set;

public interface ClienteDAOInterface {

    public void inserir(Cliente c) throws ErroDao;
    public void deletar(Cliente c) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Cliente c)throws ErroDao;
    public Cliente buscar(int id) throws ErroDao;
    public Set<Cliente> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
