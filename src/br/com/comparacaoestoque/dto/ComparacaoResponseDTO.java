package br.com.comparacaoestoque.dto;

import java.math.BigInteger;

public class ComparacaoResponseDTO {

    private BigInteger codPedido;
    private String nomeCliente;

    private boolean emEstoque;
    private BigInteger codItem;
    private double qtdPedido;
    private double qtdEstoque;
    private String nomeItem;
    private double qtdAtendida;
    private double qtdFaltante;

    public double getQtdAtendida() {
        return qtdAtendida;
    }

    public void setQtdAtendida(double qtdAtendida) {
        this.qtdAtendida = qtdAtendida;
    }

    public double getQtdFaltante() {
        return qtdFaltante;
    }

    public void setQtdFaltante(double qtdFaltante) {
        this.qtdFaltante = qtdFaltante;
    }

    public BigInteger getCodPedido() {
        return codPedido;
    }

    public void setCodPedido(BigInteger codPedido) {
        this.codPedido = codPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public boolean isEmEstoque() {
        return emEstoque;
    }

    public void setEmEstoque(boolean emEstoque) {
        this.emEstoque = emEstoque;
    }

    public BigInteger getCodItem() {
        return codItem;
    }

    public void setCodItem(BigInteger codItem) {
        this.codItem = codItem;
    }

    public double getQtdPedido() {
        return qtdPedido;
    }

    public void setQtdPedido(double qtdPedido) {
        this.qtdPedido = qtdPedido;
    }

    public double getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(double qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public String toString() {
        return "Pedido " + codPedido +
                " | Cliente: " + nomeCliente +
                "\nItem: " + codItem + " - " + nomeItem +
                " | Pedido: " + qtdPedido +
                " | Atendido: " + qtdAtendida +
                " | Faltante: " + qtdFaltante +
                " | Estoque antes: " + qtdEstoque +
                " | " + (emEstoque ? "OK ✅" : (qtdAtendida > 0 ? "PARCIAL ⚠️" : "FALTA ❌"));
    }
}
