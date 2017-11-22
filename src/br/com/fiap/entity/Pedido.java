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

}
