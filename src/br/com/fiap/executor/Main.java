package br.com.fiap.executor;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PedidoDAO;
import br.com.fiap.dao.factory.DAOFactory;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pedido;

import java.util.Collections;
import java.util.Date;

public class Main {

    public static void main(String[] args) {

        try {
            ClienteDAO clienteDAO = DAOFactory.getDAOFactory().getClienteDAO();

            Cliente cliente = new Cliente("Amanda Prado", "pce.amanda@gmail.com", null);
            cliente = clienteDAO.inserirCliente(cliente);

            PedidoDAO pedidoDAO = DAOFactory.getDAOFactory().getPedidoDAO();
            Pedido pedido = new Pedido();
            pedido.setData(new Date());
            pedido.setDescricao("Materiais Escritório");
            pedido.setValor(9000D);
            pedido.setIdCliente(cliente.getId());
            pedidoDAO.incluirPedido(pedido);

            cliente.setPedidos(Collections.singletonList(pedido));

            Cliente resultadoBusca = clienteDAO.getCliente(cliente.getId());

            System.out.println("Cliente conforme o esperado: " + resultadoBusca.equals(cliente));
            System.out.println("Cliente: " + resultadoBusca);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
