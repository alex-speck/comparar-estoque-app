package br.com.comparacaoestoque.model;

import java.math.BigInteger;
import java.util.List;

public class Pedido {

    private BigInteger codigo;
    private String nome;
    private List<PedidoItem> pedidoItems;

    public Pedido(BigInteger codigo, String nome, List<PedidoItem> pedidoItems) {
        this.codigo = codigo;
        this.nome = nome;
        this.pedidoItems = pedidoItems;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<PedidoItem> getPedidoItems() {
        return pedidoItems;
    }

    public void setPedidoItems(List<PedidoItem> pedidoItems) {
        this.pedidoItems = pedidoItems;
    }

    @Override
    public String toString() {
        return "Pedido {" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", pedidoItems=" + pedidoItems +
                '}';
    }
}
