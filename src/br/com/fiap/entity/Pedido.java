package br.com.fiap.entity;

import java.util.Date;

public class Pedido {

    private Integer id;
    private Integer idCliente;
    private Date data;
    private String descricao;
    private Double valor;

    public Pedido(){

    }

    public Pedido(Date data, String descricao, Double valor, Integer id, Integer idCliente) {
        super();
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.id=id;
        this.idCliente=idCliente;
    }

    public Pedido(Date data, String descricao, Double valor, int idCliente) {
        super();
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.idCliente=idCliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        if (id != null ? !id.equals(pedido.id) : pedido.id != null) return false;
        if (idCliente != null ? !idCliente.equals(pedido.idCliente) : pedido.idCliente != null) return false;
        if (data != null ? !data.equals(pedido.data) : pedido.data != null) return false;
        if (descricao != null ? !descricao.equals(pedido.descricao) : pedido.descricao != null) return false;
        return valor != null ? valor.equals(pedido.valor) : pedido.valor == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idCliente != null ? idCliente.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (valor != null ? valor.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                '}';
    }
}
