package com.guiSuttanni.testeSpringH2.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
@Entity
@Table(name = "itens_venda")
public class ItemVenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    private Integer quantidade;
    private BigDecimal valorUnitario;
    private BigDecimal descontoAdicional;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    @NotNull
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @NotNull
    private Produto produto;

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public BigDecimal getDescontoAdicional() {
        return descontoAdicional;
    }

    public void setDescontoAdicional(BigDecimal descontoAdicional) {
        this.descontoAdicional = descontoAdicional;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
