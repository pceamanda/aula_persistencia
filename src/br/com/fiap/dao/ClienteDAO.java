package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> getClientes() throws Exception;
    Cliente getCliente(Integer id) throws Exception;
    Cliente inserirCliente(Cliente cliente) throws Exception;

}
