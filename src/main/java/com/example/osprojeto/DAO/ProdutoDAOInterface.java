package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Produto;

import java.util.Set;

public interface ProdutoDAOInterface {

        public void inserir(Produto p) throws ErroDao;
        public void deletar(Produto p) throws ErroDao;
        public void deletar(int id) throws ErroDao;
        public void editar(Produto p)throws ErroDao;
        public Produto buscar(int id) throws ErroDao;
        public Set<Produto> buscar()throws ErroDao;
        public void sair() throws ErroDao;

}