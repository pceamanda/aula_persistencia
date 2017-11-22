package br.com.fiap.dao;

import br.com.fiap.entity.Pedido;

import java.util.List;

public interface PedidoDAO {

    List<Pedido> listarPedidos(int idCliente) throws Exception;
    Pedido incluirPedido(Pedido pedido) throws Exception;

}
