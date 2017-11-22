package br.com.fiap.dao;

import br.com.fiap.dao.factory.MySQLDAOFactory;
import br.com.fiap.entity.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLPedidoDAO implements PedidoDAO {

    Connection connection = null;
    PreparedStatement stmt;
    ResultSet resultSet = null;

    @Override
    public Pedido incluirPedido(Pedido pedido) throws Exception {

        try {
            connection = MySQLDAOFactory.criarConexao();

            String sql="INSERT INTO PEDIDOS (ID_CLIENTE,DATA,DESCRICAO,VALOR) VALUES (?,?,?,?)";
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pedido.getIdCliente());
            stmt.setDate(2, new Date(pedido.getData().getTime()));
            stmt.setString(3, pedido.getDescricao());
            stmt.setDouble(4, pedido.getValor());
            stmt.execute();

            resultSet = stmt.getGeneratedKeys();
            if (resultSet.next()){
                pedido.setId(resultSet.getInt(1));
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            connection.close();
            if (stmt != null) stmt.close();
            if (resultSet != null) resultSet.close();
        }
        return pedido;
    }

    @Override
    public List<Pedido> listarPedidos(int idCliente) throws Exception {
        List<Pedido> pedidos = new ArrayList<>();

        try {
            connection = MySQLDAOFactory.criarConexao();


            String sql = "SELECT ID,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE ID_CLIENTE=?";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            resultSet = stmt.executeQuery();
            while (resultSet.next()){
                pedidos.add(new Pedido(resultSet.getDate("DATA"), resultSet.getString("DESCRICAO"), resultSet.getDouble("VALOR"),
                        resultSet.getInt("ID"), idCliente));
            }
        } catch (Exception e) {
            throw e;
        }
        finally{
            connection.close();
            if (stmt != null) stmt.close();
            if (resultSet != null) resultSet.close();
        }

        return pedidos;

    }

}
