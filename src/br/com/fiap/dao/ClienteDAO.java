package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;

import java.util.List;

public interface ClienteDAO {

    List<Cliente> getClientes();
    void inserirCliente(Cliente cliente);

}
