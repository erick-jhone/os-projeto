package com.example.osprojeto.DAO;


import com.example.osprojeto.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDao implements UsuarioDaoInterface {

    private Connection con;
    public UsuarioDao() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(Usuario u) throws ErroDao {
        try {
            con=FabricaConexao.pegaConexao();
            PreparedStatement stm = con.prepareStatement(
                    "insert into usuario(login, senha) values (?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stm.setString(1, u.getLogin());
            stm.setString(2, u.getSenha());

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    u.setId(rs.getInt(1));
                }
                rs.close();
            }

            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(Usuario u) throws ErroDao {
        deletar(u.getId());
    }

    @Override
    public void deletar(int id) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("delete from usuario where id=?");
            stm.setInt(1,id);
            stm.executeUpdate();
            stm.close();
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void editar(Usuario u) throws ErroDao {

    }

    @Override
    public Usuario buscar(String login, String senha) throws ErroDao {
        try {
            PreparedStatement stm=con.prepareStatement
                    ("select * from usuario where login=? and senha=?");
            stm.setString(1,login);
            stm.setString(2,senha);
            ResultSet rs= stm.executeQuery();
            if(rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                return u;
            }
            else
                return null;

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public Set<Usuario> buscar() throws ErroDao {
        try {
            Set<Usuario> usuarios=new HashSet();
            PreparedStatement stm=con.prepareStatement
                    ("select * from usuario");
            ResultSet rs= stm.executeQuery();
            while (rs.next()){
                Usuario u=new Usuario();
                u.setId(rs.getInt("id"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);

            }
            return usuarios;
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void sair() throws ErroDao {

    }
}
