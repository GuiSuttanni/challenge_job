package com.guiSuttanni.testeSpringH2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenda;
    private Date dataVenda;
    private Date dataVencimento;

    private String tipoVenda;

    @ManyToOne
    @JoinColumn(name = "id_cooperado")
    private Cooperado cooperado;

    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private UnidadeCooperativa unidade;

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getTipoVenda() {
        return tipoVenda;
    }

    public void setTipoVenda(String tipoVenda) {
        this.tipoVenda = tipoVenda;
    }

    public Cooperado getCooperado() {
        return cooperado;
    }

    public void setCooperado(Cooperado cooperado) {
        this.cooperado = cooperado;
    }

    public UnidadeCooperativa getUnidade() {
        return unidade;
    }

    public void setUnidade(UnidadeCooperativa unidade) {
        this.unidade = unidade;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
}
