package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ProdutoDAO implements ProdutoDAOInterface {

    private Connection con;
    public ProdutoDAO() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }

    @Override
    public void inserir(Produto p) throws ErroDao {
        try {
            con=FabricaConexao.pegaConexao();
            PreparedStatement stm = con.prepareStatement(
                    "insert into produto(numero_serie, nome, modelo, marca) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stm.setString(1, p.getNumeroDeSerie());
            stm.setString(2, p.getNome());
            stm.setString(3, p.getModelo());
            stm.setString(4, p.getMarca());

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    p.setId(rs.getInt(1));
                }
                rs.close();
            }

            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Produto p) throws ErroDao {

    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from produto where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Produto p) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update produto set numero_serie=?, nome=?, marca=?, modelo=?  where id=?");

            stm.setString(1, p.getNumeroDeSerie());
            stm.setString(2, p.getNome());
            stm.setString(3, p.getMarca());
            stm.setString(4, p.getModelo());
            stm.setInt(5, p.getId());

            int linhas = stm.executeUpdate();

            if(linhas > 0){
                System.out.println("Atualização bem-sucedida.");
            } else {
                System.out.println("Não foi possível alterar");
            }

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Produto buscar(int id) throws ErroDao {
        try{
            PreparedStatement stm= con.prepareStatement("select * from produto where id=?");
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNumeroDeSerie(rs.getString("numero_serie"));
                p.setNome(rs.getString("nome"));
                p.setMarca(rs.getString("marca"));
                p.setModelo(rs.getString("modelo"));
                return p;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Produto> buscar() throws ErroDao {

        try {
            Set<Produto> produtos=new HashSet<>();
            PreparedStatement stm=con.prepareStatement
                    ("select * from produto");

            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNumeroDeSerie(rs.getString("numero_serie"));
                p.setNome(rs.getString("nome"));
                p.setNumeroDeSerie(rs.getString("numero_serie"));
                p.setModelo(rs.getString("modelo"));
                p.setMarca(rs.getString("marca"));



                produtos.add(p);
            }
            return produtos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void sair() throws ErroDao {

    }
}
