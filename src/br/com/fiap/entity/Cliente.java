package br.com.fiap.entity;

import java.util.List;

public class Cliente {

    private Integer id;
    private String nome;
    private String email;
    private List<Pedido> pedidos;

    public Cliente(){

    }

    public Cliente(String nome, String email, List<Pedido> pedidos) {
        super();
        this.nome = nome;
        this.email = email;
        this.pedidos = pedidos;
    }

    public Cliente(Integer id, String nome, String email, List<Pedido> pedidos) {
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pedidos = pedidos;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
