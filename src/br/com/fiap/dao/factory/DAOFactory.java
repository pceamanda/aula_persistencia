package br.com.fiap.dao.factory;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PedidoDAO;

public abstract class DAOFactory {

    public static DAOFactory getDAOFactory(){
        return new MySQLDAOFactory();
    }

    public abstract ClienteDAO getClienteDAO();
    public abstract PedidoDAO getPedidoDAO();

}
