package com.example.osprojeto.DAO;

import com.example.osprojeto.model.Cliente;
import com.example.osprojeto.model.OrdemServico;
import com.example.osprojeto.model.Servico;

import java.sql.*;
import java.sql.Date;
import java.util.*;


public class OrdemServicoDAO implements  OrdemServicoDAOInterface {

    private Connection con;
    public OrdemServicoDAO() throws ErroDao{
        con=FabricaConexao.pegaConexao();
    }
    @Override
    public void inserir(OrdemServico os) throws ErroDao {

        try {
            con=FabricaConexao.pegaConexao();
            PreparedStatement stm = con.prepareStatement(
                    "insert into ordemservico(cliente_id, observacao, data_entrada, data_saida) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );

            stm.setString(1, os.getCliente().getId().toString());
            stm.setString(2, os.getObservacao());
            stm.setDate(3, new java.sql.Date(os.getDataEntrada().getTime()));
            stm.setDate(4, new java.sql.Date(os.getDataSaida().getTime()));

            int rowsAffected = stm.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = stm.getGeneratedKeys();
                if (rs.next()) {
                    os.setId(rs.getInt(1));
                }
                rs.close();
            }

            stm.close();
            for (Servico servico : os.getServicos()) {
                PreparedStatement stmServicoOrdemServico = con.prepareStatement(
                        "insert into servico_ordem_servico (servico_id, ordem_servico_id) values (?, ?)"
                );

                stmServicoOrdemServico.setInt(1, servico.getId());
                stmServicoOrdemServico.setInt(2, os.getId());

                stmServicoOrdemServico.executeUpdate();
                stmServicoOrdemServico.close();
            }
        } catch (SQLException e) {
            throw new ErroDao(e);
        }
    }

    @Override
    public void deletar(OrdemServico os) throws ErroDao {

    }

    @Override
    public void deletar(int id) throws ErroDao {

    }

    @Override
    public void editar(OrdemServico os) throws ErroDao {

    }

    @Override
    public OrdemServico buscar(int id) throws ErroDao {
        return null;
    }

    @Override
    public Set<OrdemServico> buscar() throws ErroDao {
        Set<OrdemServico> ordensDeServico = new HashSet<>();

        try {
            PreparedStatement preparedStatement = con.prepareStatement(
                    "SELECT os.id, os.cliente_id, os.observacao, os.data_entrada, os.data_saida, c.id as cliente_id, c.nome, c.telefone, sos.servico_id, s.descricao " +
                            "FROM ordemservico os " +
                            "INNER JOIN cliente c ON os.cliente_id = c.id " +
                            "INNER JOIN servico_ordem_servico sos ON os.id = sos.ordem_servico_id " +
                            "INNER JOIN servico s ON sos.servico_id = s.id "
            );

            ResultSet resultSet = preparedStatement.executeQuery();

            Map<Integer, OrdemServico> ordensServicoMap = new HashMap<>();

            while (resultSet.next()) {
                int ordemServicoId = resultSet.getInt("id");

                // Cria uma instância de Cliente
                Cliente cliente = new Cliente();
                cliente.setId(resultSet.getInt("cliente_id"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setTelefone(resultSet.getString("telefone"));

                // Verifica se a OrdemServico já foi criada
                OrdemServico ordemServico = ordensServicoMap.computeIfAbsent(ordemServicoId, k -> {
                    // Se não existir, cria uma nova instância de OrdemServico
                    OrdemServico novaOrdemServico = new OrdemServico();
                    novaOrdemServico.setId(ordemServicoId);
                    novaOrdemServico.setCliente(cliente);
                    novaOrdemServico.setServicos(new ArrayList<>());
                    return novaOrdemServico;
                });

                // Adiciona o serviço à lista associada à ordem de serviço
                ordemServico.getServicos().add(new Servico(
                        resultSet.getInt("servico_id"),
                        resultSet.getString("descricao")
                ));

                // Configura a observação e as datas na OrdemServico, se ainda não estiverem configuradas
                if (ordemServico.getObservacao() == null) {
                    ordemServico.setObservacao(resultSet.getString("observacao"));
                }

                if (ordemServico.getDataEntrada() == null) {
                    ordemServico.setDataEntrada(resultSet.getDate("data_entrada"));
                }

                if (ordemServico.getDataSaida() == null) {
                    ordemServico.setDataSaida(resultSet.getDate("data_saida"));
                }

                // ... outras leituras necessárias para OrdemServico
            }

            // Adiciona as instâncias de OrdemServico ao conjunto final
            ordensDeServico.addAll(ordensServicoMap.values());

        } catch (SQLException e) {
            throw new ErroDao(e);
        }
        return ordensDeServico;
    }



    @Override
    public void sair() throws ErroDao {

    }
}
