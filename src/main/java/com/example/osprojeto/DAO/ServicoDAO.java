package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Produto;
import com.example.osprojeto.model.Servico;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ServicoDAO implements ServicoDAOInterface{
    private Connection con;
    public ServicoDAO() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }


    @Override
    public void inserir(Servico servico) throws ErroDao {
        try {
            con=FabricaConexao.pegaConexao();
            PreparedStatement stm = con.prepareStatement(
                    "insert into servico(nome, descricao, valor) values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stm.setString(1, servico.getNome());
            stm.setString(2, servico.getDescricao());
            stm.setString(3, servico.getValor().toString());

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    servico.setId(rs.getInt(1));
                }
                rs.close();
            }

            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

    }

    @Override
    public void deletar(Servico servico) throws ErroDao {

    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from servico where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Servico servico) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update servico set nome=?, descricao=?, valor=? where id=?");

            stm.setString(1,servico.getNome());
            stm.setString(2, servico.getDescricao());
            stm.setBigDecimal(3, servico.getValor());
            stm.setInt(4, servico.getId());

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
    public Servico buscar(Integer id) throws ErroDao {
        try{
            PreparedStatement stm= con.prepareStatement("select * from servico where id=?");
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setValor(rs.getBigDecimal("valor"));
                return s;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Servico> buscar() throws ErroDao {
        try {
            Set<Servico> servicos=new HashSet<>();
            PreparedStatement stm=con.prepareStatement
                    ("select * from servico");

            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Servico s = new Servico();
                s.setId(rs.getInt("id"));
                s.setNome(rs.getString("nome"));
                s.setDescricao(rs.getString("descricao"));
                s.setValor(rs.getBigDecimal("valor"));



                servicos.add(s);
            }
            return servicos;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void sair() throws ErroDao {

    }
}
