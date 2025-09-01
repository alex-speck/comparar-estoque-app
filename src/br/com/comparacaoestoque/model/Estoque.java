package br.com.comparacaoestoque.model;

import java.math.BigInteger;

public class Estoque {

    private BigInteger codigoItem;
    private double quantidadeDisp;

    public Estoque(BigInteger codigoItem, double quantidadeDisp) {
        this.codigoItem = codigoItem;
        this.quantidadeDisp = quantidadeDisp;
    }

    public BigInteger getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(BigInteger codigoItem) {
        this.codigoItem = codigoItem;
    }

    public double getQuantidadeDisp() {
        return quantidadeDisp;
    }

    public void setQuantidadeDisp(int quantidadeDisp) {
        this.quantidadeDisp = quantidadeDisp;
    }
}
