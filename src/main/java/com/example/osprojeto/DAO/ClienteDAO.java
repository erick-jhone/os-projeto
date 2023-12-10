package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ClienteDAO implements  ClienteDAOInterface {

    private Connection con;
    public ClienteDAO() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Cliente c) throws ErroDao {
        try {
            con=FabricaConexao.pegaConexao();
            PreparedStatement stm = con.prepareStatement(
                    "insert into cliente(nome, telefone, endereco) values (?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stm.setString(1, c.getNome());
            stm.setString(2, c.getTelefone());
            stm.setString(3, c.getEndereco());

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    c.setId(rs.getInt(1));
                }
                rs.close();
            }

            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Cliente c) throws ErroDao {

    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from cliente where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }

    }

    @Override
    public void editar(Cliente c) throws ErroDao {
        try {
            PreparedStatement stm = con.prepareStatement
                    ("update cliente set nome=?, telefone=?, endereco=? where id=?");

            stm.setString(1,c.getNome());
            stm.setString(2, c.getTelefone());
            stm.setString(3, c.getEndereco());
            stm.setInt(4, c.getId());

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
    public Cliente buscar(int id) throws ErroDao {
        try{
            PreparedStatement stm= con.prepareStatement("select * from cliente where id=?");
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));
                return c;
            } else {
                return null;
            }

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Cliente> buscar() throws ErroDao {
        try {
            Set<Cliente> clientes = new HashSet<>();
            PreparedStatement stm = con.prepareStatement("select * from cliente");

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEndereco(rs.getString("endereco"));

                clientes.add(c);
            }

            return clientes;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }


    @Override
    public void sair() throws ErroDao {

    }
}
