package br.com.fiap.dao;

import br.com.fiap.dao.factory.MySQLDAOFactory;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLClienteDAO implements ClienteDAO {

    Connection cn = null;
    PreparedStatement stmt;
    ResultSet rs = null;

    @Override
    public Cliente inserirCliente(Cliente cliente) throws Exception {

        try {
            cn = MySQLDAOFactory.criarConexao();
            stmt = cn.prepareStatement("INSERT INTO CLIENTES (ID, NOME, EMAIL) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.executeUpdate();

            rs = stmt.getGeneratedKeys();
            while (rs.next()){
                cliente.setId(rs.getInt(1));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            cn.close();
            if (stmt != null) stmt.close();
        }
        return cliente;
    }

    @Override
    public Cliente getCliente(Integer id) throws Exception {

        Cliente cliente = null;
        List<Pedido> pedidos = new ArrayList<>();

        try {
            cn = MySQLDAOFactory.criarConexao();
            String sql = "SELECT ID,DATA,DESCRICAO,VALOR FROM PEDIDOS WHERE ID_CLIENTE=?";
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            while (rs.next()){
                pedidos.add(new Pedido(rs.getDate("DATA"),rs.getString("DESCRICAO"), rs.getDouble("VALOR"),
                        rs.getInt("ID"), id));
            }

            sql="SELECT NOME,EMAIL FROM CLIENTES WHERE ID=?";
            stmt = cn.prepareStatement(sql);
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if (rs.next()){
                cliente = new Cliente(rs.getString("NOME"), rs.getString("EMAIL"), pedidos);
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            cn.close();
            stmt.close();
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        }

        return cliente;

    }

    @Override
    public List<Cliente> getClientes() throws Exception {

        List<Cliente> clientes = new ArrayList<>();

        try {
            cn = MySQLDAOFactory.criarConexao();
            String sql="SELECT NOME,EMAIL FROM CLIENTES";
            stmt = cn.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.next()){
                clientes.add(new Cliente(rs.getString("NOME"), rs.getString("EMAIL"), null));
            }

        } catch (Exception e) {
            throw e;
        }
        finally{
            cn.close();
            stmt.close();
            if (stmt != null) stmt.close();
            if (rs != null) rs.close();
        }

        return clientes;

    }

}
