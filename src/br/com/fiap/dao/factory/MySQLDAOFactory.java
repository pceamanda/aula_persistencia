package br.com.fiap.dao.factory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.MySQLClienteDAO;
import br.com.fiap.dao.MySQLPedidoDAO;
import br.com.fiap.dao.PedidoDAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDAOFactory extends DAOFactory {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/trabalho";

    public static Connection criarConexao() throws Exception{
        return DriverManager.getConnection(URL,"root","fiap");
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new MySQLClienteDAO();
    }

    @Override
    public PedidoDAO getPedidoDAO() {
        return new MySQLPedidoDAO();
    }
}
