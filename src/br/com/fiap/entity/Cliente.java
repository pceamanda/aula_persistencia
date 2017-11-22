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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (id != null ? !id.equals(cliente.id) : cliente.id != null) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;
        return pedidos != null ? pedidos.equals(cliente.pedidos) : cliente.pedidos == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (pedidos != null ? pedidos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pedidos=" + pedidos +
                '}';
    }
}
