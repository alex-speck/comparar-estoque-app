package br.com.comparacaoestoque.model;

import java.math.BigInteger;

public class PedidoItem {

    private BigInteger codigoItem;
    private double quantidadeItem;
    private String nomeItem;

    public PedidoItem(BigInteger codigoItem, double quantidadeItem, String nomeItem) {
        this.codigoItem = codigoItem;
        this.quantidadeItem = quantidadeItem;
        this.nomeItem = nomeItem;
    }

    public BigInteger getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(BigInteger codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getQuantidadeItem() {
        return quantidadeItem;
    }

    public void setQuantidadeItem(int quantidadeItem) {
        this.quantidadeItem = quantidadeItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public String toString() {
        return "PedidoItem {" +
                "codigoItem=" + codigoItem +
                ", quantidadeItem=" + quantidadeItem +
                ", nomeItem='" + nomeItem + '\'' +
                '}';
    }
}
