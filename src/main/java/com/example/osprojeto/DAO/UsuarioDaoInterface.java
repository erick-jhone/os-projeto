package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Usuario;

import java.util.Set;

public interface UsuarioDaoInterface {
    public void inserir(Usuario u) throws ErroDao;
    public void deletar(Usuario u) throws ErroDao;
    public void deletar(int id) throws ErroDao;
    public void editar(Usuario u)throws ErroDao;
    public Usuario buscar(String login,String senha) throws ErroDao;
    public Set<Usuario> buscar()throws ErroDao;
    public void sair() throws ErroDao;
}
